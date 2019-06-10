package com.teachy.coins.tasks;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.enumers.CoinsType;
import com.teachy.coins.gateio.restApi.IStockRestApi;
import com.teachy.coins.gateio.restApi.impl.StockRestApiImpl;
import com.teachy.coins.model.BaseCoins;
import com.teachy.coins.model.Kbase;
import com.teachy.coins.utils.SendEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.toList;

/**
 * Timely tracking and early warning
 */
@Component
public class GateKline {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final static String query_url = "https://data.gateio.co";
    private final static String trade_url = "https://api.gateio.io";
    private static IStockRestApi stockGet = new StockRestApiImpl(query_url);
    private final static String WEBSITE = "gate";
    private final static String GROUP_SET = "group_set";
    private final static String GROUP_SEC = "group_sec";
    private boolean first = true;
    private final String CoinsType_USTD = CoinsType.USDT.getType();
    private static List<BaseCoins> coinsList;
    private Map<String, Long> emailList = new HashMap<>();
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    @Autowired
    protected SendEmail sendEmail;

    /**
     * 1m
     */
    @Scheduled(cron = "10 0/1 * * * ?")
    public void getKline1m() throws InterruptedException {
        if (first) {
            init();
            first = false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
        coinsList.stream().forEach(
                e -> insert(e.getName(), CoinsType_USTD, 60, 2, countDownLatch, e));
        countDownLatch.await();

    }

    /**
     * 5m
     */
    @Scheduled(cron = "12 0/5 * * * ?")
    public void getKline5m() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
        coinsList.stream().forEach(
                e -> insert(e.getName(), CoinsType_USTD, 300, 10, countDownLatch, e));
        countDownLatch.await();
    }

    /**
     * 10m
     */
    @Scheduled(cron = "17 0/10 * * * ?")
    public void getKline10m() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
        coinsList.stream().forEach(
                e -> insert(e.getName(), CoinsType_USTD, 600, 20, countDownLatch, e));
        countDownLatch.await();
    }

    /**
     * 30m
     */
    @Scheduled(cron = "27 0/30 * * * ?")
    public void getKline30m() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
        coinsList.stream().forEach(
                e -> insert(e.getName(), CoinsType_USTD, 1800, 60, countDownLatch, e));
        countDownLatch.await();
    }

    private void insert(String coinName, String coinType, int time, double hour,
                        CountDownLatch countDownLatch, BaseCoins baseCoins) {
        executorService.execute(() -> {
            try {
                String pairs = stockGet.candlestick2(coinName, coinType, time, hour, GROUP_SEC);
                JSONObject res = JSONObject.parseObject(pairs);
                if (hasData(res)) {
                    List<JSONArray> datas = (List<JSONArray>) res.get("data");
                    List<Kbase> klines = datas.stream().map(
                            (JSONArray line) -> getKbase(line, coinName, coinType)).sorted(Comparator.comparingLong(e -> e.getTimeLong())).limit(
                            datas.size() - 1).collect(
                            toList());
                    Collections.reverse(klines);
                    checkWarning(coinName, klines, time, baseCoins);
                }
            } catch (Exception e) {
                //do nothing
            } finally {
                countDownLatch.countDown();
            }
        });
    }

    private void checkWarning(String coinName, List<Kbase> klines, int time, BaseCoins baseCoins) {
        int volume = checkVolume(klines);
        int price = checkPrice(klines);
        int count = volume + price;
        if (count > 2 && price > 1) {
            int tem = baseCoins.getEmailTime();
            baseCoins.setEmailTime(++tem);
            if (baseCoins.getEmailTime() >= 2) {
                String title = WEBSITE + ":" + coinName + ":" + time / 60;
                sendEmail(title);
                baseCoins.setEmailTime(0);
            }
        } else {
            int tem = baseCoins.getEmailTime();
            if (tem > 0) {
                baseCoins.setEmailTime(--tem);
            }
        }
    }

    private void sendEmail(String title) {
        if (emailList.get(title) != null) {
            if (System.currentTimeMillis() - emailList.get(title) > 3600 * 1000) {
                emailList.put(title, System.currentTimeMillis());
                logger.info("send email begin......");
                sendEmail.sendEmail(title, "coinName：" + title);
                logger.info("send email end......");
            }
        } else {
            emailList.put(title, System.currentTimeMillis());
            logger.info("send email begin......");
            sendEmail.sendEmail(title, "coinName：" + title);
            logger.info("send email end......");
        }
    }

    private Kbase getKbase(JSONArray line, String name, String type) {
        long time = Long.parseLong(line.getString(0));
        Double volume = Double.parseDouble(line.getString(1));
        Double close = Double.parseDouble(line.getString(2));
        Double high = Double.parseDouble(line.getString(3));
        Double low = Double.parseDouble(line.getString(4));
        Double open = Double.parseDouble(line.getString(5));
        return new Kbase(time, volume, close, high, low, open, WEBSITE, type, name);
    }

    private boolean hasData(JSONObject res) {
        return res.getString("result").equals("true");
    }

    private void init() {
        try {
            String res = stockGet.pairs();
            JSONArray array = JSONArray.parseArray(res);
            coinsList = array.stream().map(e -> e.toString()).filter(e -> e.endsWith("_USDT")).map(
                    e -> new BaseCoins(e.replace("_USDT", ""), "gate", 1, 0)).collect(toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int checkPrice(List<Kbase> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        List<Double> avgList = list.stream().map(e -> (e.getClose() + e.getOpen()) / 2).collect(toList());
        double firstAvg = avgList.get(0);
        List<Double> newList = new ArrayList();
        for (Double d : avgList) {
            if (d <= firstAvg) {
                newList.add(d);
            } else {
                break;
            }
        }
        if (newList.size() > 10) {
            DoubleStream doubleStream = newList.stream().skip(1).mapToDouble(Double::doubleValue);
            DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
            double avg = doubleSummaryStatistics.getAverage();
            if (firstAvg > avg) {
                return (int) (new BigDecimal((firstAvg - avg) / avg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()
                        * 15);
            }
        }
        return 0;
    }

    public static int checkVolume(List<Kbase> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        double firstVolume = list.get(0).getVolume();
        if (firstVolume <= 0) {
            return 0;
        }
        List<Double> newList = new ArrayList();
        List<Double> not0List = new ArrayList();
        for (Kbase kbase : list) {
            double temdouble = kbase.getVolume();
            if (temdouble <= firstVolume) {
                newList.add(kbase.getVolume());
                if (temdouble > 0) {
                    not0List.add(temdouble);
                }
            } else {
                break;
            }
        }
        if (newList.size() > 10 && not0List.size() > 2) {
            DoubleStream doubleStream = newList.stream().skip(1).mapToDouble(Double::doubleValue);
            DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
            double avg = doubleSummaryStatistics.getAverage();
            if (avg <= 0) {
                return 0;
            }
            return (int) (firstVolume / avg);
        }
        return 0;
    }
}
