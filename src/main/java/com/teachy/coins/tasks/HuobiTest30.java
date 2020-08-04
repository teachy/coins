package com.teachy.coins.tasks;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.huobi.common.api.HbdmRestApiV1;
import com.teachy.coins.huobi.common.api.IHbdmRestApi;
import com.teachy.coins.infrastructure.persistence.CoinListDao;
import com.teachy.coins.model.bo.CoinListBo;
import com.teachy.coins.utils.ChartDataBean;
import com.teachy.coins.utils.KDJ;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


@Component
@Slf4j
public class HuobiTest30 {

    private static final String API_KEY = "734e43f7-e025c7ad-ht4tgq1e4t-689eb";
    private static final String SECRET_KEY = "8d2f3ee4-12bf0a99-31b9f784-955d4";
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
    private static int MAX_WIN = 80;
    private static String volume = "0";
    List<Double> prices = new ArrayList<>(PRICES_SIZE);
    List<Double> prices1 = new ArrayList<>(PRICES_SIZE);
    List<Double> listk = new ArrayList<>();
    List<Double> listd = new ArrayList<>();
    private static double last_sell_price = 0;
    private static double HASH_WIN = 0;

    private static int B_1 = 0;
    private static int B_2 = 0;
    private static int C_1 = 0;
    private static int C_2 = 0;
    @Autowired
    CoinListDao coinListDao;

    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask() {
        try {
            task();
        } catch (Exception e) {
            log.info("数据采集错误:{}", e.getMessage());
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask1() {
        try {
            task1();
        } catch (Exception e) {
            log.info("平仓跟踪错误:{}", e.getMessage());
        }
    }

    @Scheduled(cron = "*/30 * * * * ?")
    public void doTask2() {
        try {
            insertDb();
        } catch (Exception e) {
            log.info("数据入库信息错误:{}", e.getMessage());
        }
    }

    private void insertDb() throws IOException, HttpException {
        String allMoney = futurePostV1.futureContractAccountInfo("BTC");
        double nowMoney = JSON.parseObject(allMoney).getJSONArray("data").getJSONObject(0).getDouble("margin_static");
        if (nowMoney < 0.001) {
            return;
        }
        firstCoinListBo = coinListDao.queryOneById("0");
        String list = futurePostV1.futureContractHisorders("BTC", "0", "1", "0", "7", "", "10");
        JSONObject jsonObject = JSON.parseObject(list);
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("orders");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            CoinListBo coinListBo = new CoinListBo();
            String id = object.getString("order_id");
            coinListBo.setId(id);
            coinListBo.setVolume(nowMoney);
            coinListBo.setVolumeInit(firstCoinListBo.getVolume());
            coinListBo.setType(object.getString("contract_code"));
            coinListBo.setAction(getAction(object));
            coinListBo.setCreateTime(new Timestamp(Long.valueOf(object.getString("create_date"))));
            coinListBo.setIdTrade(object.getString("contract_code"));
            coinListBo.setNum(object.getString("volume"));
            coinListBo.setNumDone(object.getString("trade_volume"));
            coinListBo.setPrice(object.getLong("price"));
            double fee = Double.parseDouble(new DecimalFormat("0.00000").format(object.getDouble("fee")));
            coinListBo.setFee(fee);
            double win = Double.parseDouble(new DecimalFormat("0.00000").format(object.getDouble("profit")));
            coinListBo.setWin(win);
            String winPercent = new DecimalFormat("0.00").format((object.getDouble("profit") * 100 / firstCoinListBo.getVolume())) + "%";
            coinListBo.setWinPercent(winPercent);
            coinListBo.setWinCount(nowMoney - firstCoinListBo.getVolume());
            String winCountPercent = new DecimalFormat("0.00").format(coinListBo.getWinCount() * 100 / firstCoinListBo.getVolume()) + "%";
            coinListBo.setWinCountPercent(winCountPercent);
            try {
                coinListDao.insert(coinListBo);
            } catch (Exception e) {
                if (e.getMessage().contains("PRIMARY")) {
                    break;
                }
            }
        }
    }

    private String getAction(JSONObject object) {
        String b = object.getString("offset").equals("close") ? "平" : "开";
        String e = object.getString("direction").equals("sell") ? "空" : "多";
        return b + e;
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
            B_1 = 0;
            B_2 = 0;
            C_1 = 0;
            C_2 = 0;
        } else {
            HASH_WIN = 0;
            volume = "0";
            buyOrSell = 0;
            isSell = false;
        }
        if (volume.equals("0")) {
            getAllKDJ();
            double res = getRes();
            //>300--150
            checkB(res);
            //<100--200
            checkC(res);
            if (B_2 == 1 || C_2 == 1) {
                log.info("open B_1:{}   B_2:{}   C_1:{}   C_2:{} ", B_1, B_2, C_1, C_2);
                open("buy", buySize + "");
            }
            if (B_2 == -1 || C_2 == -1) {
                log.info("open B_1:{}   B_2:{}   C_1:{}   C_2:{} ", B_1, B_2, C_1, C_2);
                open("sell", buySize + "");
            }
            if (res > -90 && res < 90) {
                B_1 = 0;
                C_1 = 0;
            }
        } else {
            String positionInfo1 = futurePostV1.futureMarketHistoryTrade("BTC_CQ", "1");
            jsonObject = JSON.parseObject(positionInfo1);
            last_price = jsonObject.getJSONArray("data").getJSONObject(0).getJSONArray("data").getJSONObject(0).getDouble("price");
            double temp;
            if (buyOrSell == 1) {
                temp = last_price - cost_open;
            } else {
                temp = cost_open - last_price;
            }
            if (temp < HASH_WIN - 60) {
                log.info("止损策略");
                isSell = true;
            }
            if (temp > HASH_WIN) {
                HASH_WIN = temp;
            } else {
                if (temp < HASH_WIN - 5 && temp > 10) {
                    log.info("可能1");
                    isSell = true;
                }
            }
        }


    }

    private void checkB(double res) throws IOException, HttpException {
        if (B_1 == 0) {
            checkB_1(res);
            if (B_1 == 0) {
                return;
            } else {
                log.info("跟踪B_1:{}", B_1);
            }
        }
        if (B_2 == 0) {
            checkB_2(res);
            if (B_2 == 0) {
                return;
            } else {
                log.info("跟踪B_2:{}", B_2);
            }
        }

    }


    private void checkC(double res) throws IOException, HttpException {
        if (C_1 == 0) {
            checkC_1(res);
            if (C_1 == 0) {
                return;
            } else {
                log.info("跟踪C_1:{}", C_1);
            }
        }
        if (C_2 == 0) {
            checkC_2(res);
            if (C_2 == 0) {
                return;
            } else {
                log.info("跟踪C_2:{}", C_2);
            }
        }
    }

    private void checkC_1(double res) {
        if (res > 100 && res < 150) {
            C_1 = 1;
        }
        if (res < -100 && res > -150) {
            C_1 = -1;
        }
    }

    private void checkC_2(double res) {
        if (C_1 == 1) {
            if (res > 200) {
                C_2 = 1;
            }
        }
        if (C_1 == -1) {
            if (res < -200) {
                C_2 = -1;
            }
        }
    }

    private void checkB_1(double res) {
        if (res > 300) {
            B_1 = 1;
        }
        if (res < -300) {
            B_1 = -1;
        }
    }

    private void checkB_2(double res) {
        if (B_1 == 1) {
            if (res < 150) {
                B_2 = -1;
            }
        }
        if (B_1 == -1) {
            if (res > -150) {
                B_2 = 1;
            }
        }
    }

    private double getRes() {
        DoubleSummaryStatistics stream = listk.stream().mapToDouble(e -> e).summaryStatistics();
        DoubleSummaryStatistics stream1 = listd.stream().mapToDouble(e -> e).summaryStatistics();
        return stream.getSum() - stream1.getSum();

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


    private void getAllKDJ() throws IOException, HttpException {
        listk.clear();
        listd.clear();
        for (String period : checkList) {
            String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", period, "480");
            JSONObject obj = JSON.parseObject(res);
            JSONArray arr = obj.getJSONArray("data");
            double[] maxPrice = new double[arr.size() + 1];
            double[] minPrice = new double[arr.size() + 1];
            double[] closePrice = new double[arr.size() + 1];
            ChartDataBean character = new ChartDataBean();
            List<Double> closelist = new ArrayList<>();
            for (int i = 0; i <= arr.size() - 1; i++) {
                JSONObject json = arr.getJSONObject(i);
                maxPrice[i] = json.getDouble("high");
                minPrice[i] = json.getDouble("low");
                closePrice[i] = json.getDouble("close");
                closelist.add(json.getDouble("close"));
            }
            character.setClose(closePrice);
            character.setHigh(maxPrice);
            character.setLow(minPrice);
            Map<String, Double> kdj1 = KDJ.getKDJ(14, 1, 3, character);
            double k = kdj1.get("K");
            double d = kdj1.get("D");
            double j = kdj1.get("J");
            listk.add(k);
            listk.add(j);
            listd.add(d);
            listd.add(d);
        }
    }

    private String doss(String buyOrSell, String openOrClose, String contractCode, String volume) throws IOException, HttpException {
        return futurePostV1.futureContractOrder("BTC", "quarter", contractCode, "", "", volume,
                buyOrSell, openOrClose, "20", "opponent");
    }

    private CoinListBo firstCoinListBo;
}