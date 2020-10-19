package com.teachy.coins.tasks;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.huobi.common.api.HbdmRestApiV1;
import com.teachy.coins.huobi.common.api.IHbdmRestApi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@Slf4j
public class HuobiTest31 {

    private static final String API_KEY = "83b82319-vqgdf4gsga-ee719d6c-b0b2-003";
    private static final String SECRET_KEY = "ae85e343-fb9df7fa-b7235f8c-8091-008";
    private static final String URL_PREX = "https://api.btcgateway.pro";
    private static IHbdmRestApi futureGetV1 = new HbdmRestApiV1(URL_PREX);
    private static IHbdmRestApi futurePostV1 = new HbdmRestApiV1(URL_PREX, API_KEY, SECRET_KEY);
    private static int buyOrSell = 0;
    private static double macd1 = 0;
    @Value("${huobi.volume}")
    int buySize;
    List<String> checkList = Arrays.asList("5min", "15min", "30min", "60min", "4hour");
    Set<Double> buyList = new HashSet<>();
    private static boolean isSell = false;
    private static int PRICES_SIZE = 10;
    private static String volume = "0";
    List<Double> prices = new ArrayList<>(PRICES_SIZE);
    List<Double> prices1 = new ArrayList<>(PRICES_SIZE);
    private static double last_sell_price = 0;
    private static double HASH_WIN = 0;
    int jishuqi = 10;


    @Scheduled(cron = "*/30 * * * * ?")
    public void doTask() {
        try {
            task();
        } catch (Exception e) {
            log.info("数据采集错误:{}", e.getMessage());
        }
    }

    @Scheduled(cron = "*/3 * * * * ?")
    public void doTask1() {
        try {
            task1();
        } catch (Exception e) {
            log.info("平仓跟踪错误:{}", e.getMessage());
        }
    }


    private void task1() throws IOException, HttpException {
        String positionInfo1 = futurePostV1.futureMarketHistoryTrade("BTC_CQ", "1");
        double last_price = JSON.parseObject(positionInfo1).getJSONArray("data").getJSONObject(0).getJSONArray("data").getJSONObject(0).getDouble("price");
        if (prices.size() < PRICES_SIZE) {
            prices.add(last_price);
        }
        if (prices.size() != PRICES_SIZE) {
            return;
        }
        synchronized (prices1) {
            prices1.clear();
            prices.forEach(e -> prices1.add(e));
        }
        if (isSell) {
            int checkPriceRes = checkPrice(prices);
            log.info("开始追踪卖点 checkPriceRes:{}  buyOrSell:{} last_price:{}", checkPriceRes, buyOrSell, last_price);
            if (checkPriceRes != 0 && buyOrSell != 0 && buyOrSell != checkPriceRes) {
                if (buyOrSell == 1) {
                    last_sell_price = last_price;
                    close("sell", volume);
                }
                if (buyOrSell == -1) {
                    last_sell_price = last_price;
                    close("buy", volume);
                }
            }
        }
        prices.remove(0);
        List<Double> tempPrices = prices.stream().collect(Collectors.toList());
        prices.clear();
        prices.addAll(tempPrices);
    }

    private int checkPrice(List<Double> prices) {
        synchronized (prices) {
            int temp = 0;
            DoubleSummaryStatistics stream = prices.stream().mapToDouble(e -> e).summaryStatistics();
            double avg = stream.getAverage();
            if (prices.get(prices.size() - 1) < prices.get(prices.size() - 2) && prices.get(prices.size() - 2) < avg && prices.get(prices.size() - 1) < avg) {
                temp = -1;
            }
            if (prices.get(prices.size() - 1) > prices.get(prices.size() - 2) && prices.get(prices.size() - 2) > avg && prices.get(prices.size() - 1) > avg) {
                temp = 1;
            }
            return temp;
        }
    }

    private void task() throws Exception {
        futurePostV1.futureContractCancelall("BTC");
        JSONObject jsonObject;
        double cost_open = 0;
        double last_price;
        String positionInfo = futurePostV1.futureContractPositionInfo("BTC");
        jsonObject = JSON.parseObject(positionInfo);
        if (jsonObject.getJSONArray("data").size() > 0) {
            cost_open = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("cost_open");
            String direction = jsonObject.getJSONArray("data").getJSONObject(0).getString("direction");
            volume = jsonObject.getJSONArray("data").getJSONObject(0).getString("volume");
            buyOrSell = direction.equalsIgnoreCase("buy") ? 1 : -1;
        } else {
            HASH_WIN = 0;
            volume = "0";
            buyOrSell = 0;
            isSell = false;
        }
        String positionInfo1 = futurePostV1.futureMarketHistoryTrade("BTC_CQ", "1");
        jsonObject = JSON.parseObject(positionInfo1);
        last_price = jsonObject.getJSONArray("data").getJSONObject(0).getJSONArray("data").getJSONObject(0).getDouble("price");
        if (volume.equals("0")) {
            int res = check1Min();
            if (res == 1) {
                open("buy", buySize + "");
            }
            if (res == -1) {
                open("sell", buySize + "");
            }
        } else {
            double temp;
            Node lastNode = getLast();
            if (buyOrSell == 1) {
                temp = last_price - cost_open;
                if (lastNode.getClose() + 12 < lastNode.getOpen()) {
                    isSell = true;
                    log.info("止损策略2");
                }
            } else {
                temp = cost_open - last_price;
                if (lastNode.getClose() - 12 > lastNode.getOpen()) {
                    isSell = true;
                    log.info("止损策略2");
                }
            }
            if (temp < -150) {
                log.info("止损策略");
                isSell = true;
            }
            if (temp > HASH_WIN) {
                HASH_WIN = temp;
            } else {
                if (HASH_WIN - temp > 150) {
                    log.info("止损策略1");
                    isSell = true;
                }
            }


        }


    }

    private Node getLast() throws IOException, HttpException {
        String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", "15min", "8");
        JSONObject obj = JSON.parseObject(res);
        JSONArray arr = obj.getJSONArray("data");
        List<Node> list = new ArrayList<>();
        Node lastNode = null;
        for (int i = 0; i < arr.size() - 1; i++) {
            JSONObject json = arr.getJSONObject(i);
            double open = json.getDouble("open");
            double close = json.getDouble("close");
            double high = json.getDouble("high");
            double low = json.getDouble("low");
            long vol = json.getLong("vol");
            if (i == arr.size() - 2) {
                lastNode = new Node(open, close, high, low, vol);
            } else {
                list.add(new Node(open, close, high, low, vol));
            }
        }
        return lastNode;
    }

    private int check1Min() throws IOException, HttpException {
        String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", "15min", "8");
        JSONObject obj = JSON.parseObject(res);
        JSONArray arr = obj.getJSONArray("data");
        List<Node> list = new ArrayList<>();
        Node lastNode = null;
        for (int i = 0; i < arr.size() - 1; i++) {
            JSONObject json = arr.getJSONObject(i);
            double open = json.getDouble("open");
            double close = json.getDouble("close");
            double high = json.getDouble("high");
            double low = json.getDouble("low");
            long vol = json.getLong("vol");
            if (i == arr.size() - 2) {
                lastNode = new Node(open, close, high, low, vol);
            } else {
                list.add(new Node(open, close, high, low, vol));
            }
        }
        List<Boolean> allRight = new ArrayList<>();
        int volCount = 0;
        for (Node eve : list) {
            if (lastNode.getVol() < eve.getVol()) {
                allRight.add(false);
            }
            if (lastNode.getVol() / eve.getVol() > 5) {
                volCount++;
            }
        }
        if (volCount < 2) {
            allRight.add(false);
        }
        if (allRight.size() > 0) {
            return 0;
        } else {
            List<Boolean> buy = new ArrayList<>();
            List<Boolean> sell = new ArrayList<>();
            for (Node eve : list) {
                if (lastNode.getClose() < eve.getHigh()) {
                    buy.add(false);
                }
                if (lastNode.getClose() > eve.getLow()) {
                    sell.add(false);
                }
            }
            if (lastNode.getHigh() - lastNode.getClose() > lastNode.getClose() - lastNode.getOpen()) {
                buy.add(false);
            }
            if (lastNode.getClose() - lastNode.getLow() > lastNode.getOpen() - lastNode.getClose()) {
                sell.add(false);
            }
            if (list.size() != 6) {
                log.error("list 数据错误：{}", list);
                log.error("arr 数据错误：{}", arr);
            }
            if (buy.size() == 0) {
                log.info("buy---: list:{}  lastNode:{}", list, lastNode);
                return 1;
            }
            if (sell.size() == 0) {
                log.info("sell---: list:{}  lastNode:{}", list, lastNode);
                return -1;
            }
        }
        return 0;
    }

    @AllArgsConstructor
    @Data
    static class Node {
        double open;
        double close;
        double high;
        double low;
        long vol;
    }


    private void open(String bos, String volume) throws IOException, HttpException {
        if (bos.equals("buy")) {
            if (checkPrice(prices1) <= 0) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                open(bos, volume);
                return;
            }
        } else {
            if (checkPrice(prices1) >= 0) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                open(bos, volume);
                return;
            }
        }
        String contractInfo = futureGetV1.futureContractInfo("BTC", "quarter", "");
        String contractCode = JSON.parseObject(contractInfo).getJSONArray("data").getJSONObject(0).getString("contract_code");
        doss(bos, "open", contractCode, volume);
    }

    private void close(String bos, String volume) throws IOException, HttpException {
        String contractInfo = futureGetV1.futureContractInfo("BTC", "quarter", "");
        String contractCode = JSON.parseObject(contractInfo).getJSONArray("data").getJSONObject(0).getString("contract_code");
        String contractOrder = doss(bos, "close", contractCode, volume.substring(0, volume.indexOf(".")));
        String status = JSON.parseObject(contractOrder).getString("status");
        if ("ok".equalsIgnoreCase(status)) {
            buyList.clear();
        }
    }

    private String doss(String buyOrSell, String openOrClose, String contractCode, String volume) throws IOException, HttpException {
        return futurePostV1.futureContractOrder("BTC", "quarter", contractCode, "", "", volume,
                buyOrSell, openOrClose, "50", "opponent");
    }

}