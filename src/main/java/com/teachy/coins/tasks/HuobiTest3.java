package com.teachy.coins.tasks;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.huobi.common.api.HbdmRestApiV1;
import com.teachy.coins.huobi.common.api.IHbdmRestApi;
import com.teachy.coins.utils.ChartDataBean;
import com.teachy.coins.utils.IndicatrixUtils;
import com.teachy.coins.utils.KDJ;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Component
@Slf4j
public class HuobiTest3 {

    private static final String API_KEY = "12345678";
    private static final String SECRET_KEY = "123456789";
    private static final String URL_PREX = "https://api.btcgateway.pro";
    private static IHbdmRestApi futureGetV1 = new HbdmRestApiV1(URL_PREX);
    private static IHbdmRestApi futurePostV1 = new HbdmRestApiV1(URL_PREX, API_KEY, SECRET_KEY);

    Map<String, Double> kdjMap = new HashMap<>();
    Map<String, Double> macdMap = new HashMap<>();
    private static int kdj = 0;

    private static double j1 = 0;
    private static double d1 = 0;
    private static double k1 = 0;
    private static double macd1 = 0;
    private static int hasCheckPrice = 0;
    List<String> checkList = Arrays.asList("5min", "15min", "30min");
    private static int PRICES_SIZE = 10;
    List<Double> prices = new ArrayList<>(PRICES_SIZE);

    @Scheduled(cron = "*/3 * * * * ?")
    public void doTask() {
        try {
            task();
        } catch (Exception e) {
            log.info("采集错误:{}", e.getMessage());
        }
    }

    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask1() {
        try {
            task1();
        } catch (Exception e) {
            log.info("采集错误:{}", e.getMessage());
        }
    }

    private void task1() throws IOException, HttpException {
        JSONObject jsonObject;
        String positionInfo1 = futurePostV1.futureMarketHistoryTrade("BTC_CQ", "1");
        jsonObject = JSON.parseObject(positionInfo1);
        double last_price = jsonObject.getJSONArray("data").getJSONObject(0).getJSONArray("data").getJSONObject(0).getDouble("price");
        if (prices.size() < PRICES_SIZE) {
            prices.add(last_price);
        }
        if (prices.size() != PRICES_SIZE) {
            return;
        }
        if (hasCheckPrice != 0 && kdj == 0) {
//            if (hasCheckPrice == 1 && checkPrice1() == 1) {
//                String contractInfo = futureGetV1.futureContractInfo("BTC", "quarter", "");
//                jsonObject = JSON.parseObject(contractInfo);
//                String contractCode = jsonObject.getJSONArray("data").getJSONObject(0).getString("contract_code");
//                String contractindex = futureGetV1.futureContractIndex("BTC");
//                jsonObject = JSON.parseObject(contractindex);
//                String price = jsonObject.getJSONArray("data").getJSONObject(0).getString("index_price");
//                doss("buy", "open", contractCode, price);
//                kdj = 1;
//            }
//            if (hasCheckPrice == -1 && checkPrice1() == -1) {
//                String contractInfo = futureGetV1.futureContractInfo("BTC", "quarter", "");
//                jsonObject = JSON.parseObject(contractInfo);
//                String contractCode = jsonObject.getJSONArray("data").getJSONObject(0).getString("contract_code");
//                String contractindex = futureGetV1.futureContractIndex("BTC");
//                jsonObject = JSON.parseObject(contractindex);
//                String price = jsonObject.getJSONArray("data").getJSONObject(0).getString("index_price");
//                doss("sell", "open", contractCode, price);
//                kdj = -1;
//            }
        } else {
            int checkPriceRes = checkPrice();
            if (checkPriceRes != 0) {
                if (kdj != 0) {
                    String contractInfo = futureGetV1.futureContractInfo("BTC", "quarter", "");
                    jsonObject = JSON.parseObject(contractInfo);
                    String contractCode = jsonObject.getJSONArray("data").getJSONObject(0).getString("contract_code");
                    String contractindex = futureGetV1.futureContractIndex("BTC");
                    jsonObject = JSON.parseObject(contractindex);
                    String price = jsonObject.getJSONArray("data").getJSONObject(0).getString("index_price");
                    if (checkPriceRes == 1) {
                        hasCheckPrice = -1;
                        if (kdj == -1) {
                            doss("buy", "close", contractCode, price);
                            kdj = 0;
                        }
                    }
                    if (checkPriceRes == -1) {
                        hasCheckPrice = 1;
                        if (kdj == 1) {
                            doss("sell", "close", contractCode, price);
                            kdj = 0;
                        }
                    }
                } else {
                    if (checkPriceRes == 1) {
                        hasCheckPrice = -1;
                    }
                    if (checkPriceRes == -1) {
                        hasCheckPrice = 1;
                    }
                }

            }
        }
        prices.remove(0);
        List<Double> tempPrices = prices.stream().collect(Collectors.toList());
        prices.clear();
        prices.addAll(tempPrices);
    }

    private int checkPrice() {
        int temp = 0;
        DoubleSummaryStatistics stream = prices.stream().mapToDouble(e -> e).summaryStatistics();
        double avg = stream.getAverage();
        double max = stream.getMax();
        double min = stream.getMin();
        if (max - min > 9 && max - avg > 4 && avg - min > 4) {
            temp = checkPrice1();
            log.info("止损：{}  temp:{}", prices, temp);
        }
        return temp;
    }

    private int checkPrice1() {
        int temp = 0;
        DoubleSummaryStatistics stream = prices.stream().mapToDouble(e -> e).summaryStatistics();
        double avg = stream.getAverage();
        if (prices.get(0) > prices.get(1) && prices.get(0) > prices.get(PRICES_SIZE - 1) && prices.get(PRICES_SIZE - 2) > prices.get(PRICES_SIZE - 1) && prices.get(PRICES_SIZE - 1) < avg) {
            temp = -1;
        }
        if (prices.get(PRICES_SIZE - 1) > prices.get(PRICES_SIZE - 2) && prices.get(PRICES_SIZE - 1) > prices.get(0) && prices.get(1) > prices.get(0) && prices.get(PRICES_SIZE - 1) > avg) {
            temp = 1;
        }
        return temp;
    }

    private void task() throws Exception {
        checkHuoBi();
        if (kdjMap.isEmpty() || macdMap.isEmpty()) {
            return;
        }
        double k = kdjMap.get("K");
        double d = kdjMap.get("D");
        double j = kdjMap.get("J");
        double macd = macdMap.get("MACD");
        //  System.out.println("k:"+k+"d:"+d+"j:"+j+"macd:"+macd);
        if (d == d1 && j == j1) {
            return;
        }
        JSONObject jsonObject;
        String volume = "0";
        double cost_open = 0;
        double last_price = 0;
        String positionInfo1 = futurePostV1.futureMarketHistoryTrade("BTC_CQ", "1");
        jsonObject = JSON.parseObject(positionInfo1);
        last_price = jsonObject.getJSONArray("data").getJSONObject(0).getJSONArray("data").getJSONObject(0).getDouble("price");

        String allMoney = futurePostV1.futureContractAccountInfo("BTC");
        double margin_static = JSON.parseObject(allMoney).getJSONArray("data").getJSONObject(0).getDouble("margin_static");

        String positionInfo = futurePostV1.futureContractPositionInfo("BTC");
        jsonObject = JSON.parseObject(positionInfo);
        if (jsonObject.getJSONArray("data").size() > 0) {
            cost_open = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("cost_open");
            last_price = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("last_price");
            String direction = jsonObject.getJSONArray("data").getJSONObject(0).getString("direction");
            String type = direction.equalsIgnoreCase("buy") ? "做多" : "做空";
            volume = jsonObject.getJSONArray("data").getJSONObject(0).getString("volume");
            kdj = direction.equalsIgnoreCase("buy") ? 1 : -1;
            hasCheckPrice = 0;
            if (Math.abs(cost_open - last_price) < 10) {
                return;
            }
            log.info("BTC季度合约-->{}-->开仓价格：{}-->数量：{}-->当前btc数量：{}-->当前价格：{}", type, cost_open, volume, margin_static, last_price);
        }
        String contractInfo = futureGetV1.futureContractInfo("BTC", "quarter", "");
        jsonObject = JSON.parseObject(contractInfo);
        String contractCode = jsonObject.getJSONArray("data").getJSONObject(0).getString("contract_code");
        String contractindex = futureGetV1.futureContractIndex("BTC");
        jsonObject = JSON.parseObject(contractindex);
        String price = jsonObject.getJSONArray("data").getJSONObject(0).getString("index_price");
        if (volume.equals("0")) {
            kdj = 0;
            if (d < k && d < j && d < 30) {
                if (checkFiveMin() >= 1) {
                    if (check1Min(last_price) == 1) {
                        kdj = 1;
                        log.info("多确认--d:{}--j:{}--macd:{}", d, j, macd);
                    }
                }
            }
            if (d > k && d > j && d > 70) {
                if (checkFiveMin() <= -1) {
                    if (check1Min(last_price) == -1) {
                        kdj = -1;
                        log.info("空确认--d:{}--j:{}--macd:{}", d, j, macd);
                    }
                }
            }

            if (kdj != 0) {
                boolean hasSuccess = false;
                String contractOrder = "";
                long be = System.currentTimeMillis();
                while (!hasSuccess) {
                    long en = System.currentTimeMillis();
                    if (en - be > 5000) {
                        hasSuccess = true;
                    }
                    try {
                        if (kdj == 1) {
                            contractOrder = doss("buy", "open", contractCode, price);
                        }
                        if (kdj == -1) {
                            contractOrder = doss("sell", "open", contractCode, price);
                        }
                        System.out.println(contractOrder);
                        jsonObject = JSON.parseObject(contractOrder);
                        if (jsonObject == null) {
                            hasSuccess = true;
                        }
                        String status = jsonObject.getString("status");
                        if ("ok".equalsIgnoreCase(status)) {
                            hasSuccess = true;
                        }
                    } catch (Exception e) {

                    }
                }
            }
        } else {
            boolean sell = false;
            if (kdj == 1) {
                boolean tem = (d < d1 && j < j1) || (k < k1 && j < j1) || (d < d1 && k < k1) && (d > j || d > k);
                if (tem) {
                    if (macd < macd1 && Math.abs(macd - macd1) > 0.05) {
                        sell = true;
                    }
                }
            }
            if (kdj == -1) {
                boolean tem = (d > d1 && j > j1) || (k > k1 && j > j1) || (d > d1 && k > k1) && (d < j || d < k);
                if (tem) {
                    if (macd > macd1 && Math.abs(macd - macd1) > 0.05) {
                        sell = true;
                    }
                }
            }

            if (sell) {
                log.info("close确认d1->d:{}->{}  j1->j:{}->{}  macd1->macd:{}->{}", d1, d, j1, j, macd1, macd);
                boolean hasSuccess = false;
                String contractOrder = "";
                long be = System.currentTimeMillis();
                while (!hasSuccess) {
                    long en = System.currentTimeMillis();
                    if (en - be > 5000) {
                        hasSuccess = true;
                    }
                    try {
                        if (kdj == 1) {
                            if (cost_open < last_price) {
                                contractOrder = doss("sell", "close", contractCode, price);
                            }
                        }
                        if (kdj == -1) {
                            if (cost_open > last_price) {
                                contractOrder = doss("buy", "close", contractCode, price);
                            }
                        }
                        System.out.println(contractOrder);
                        jsonObject = JSON.parseObject(contractOrder);
                        if (jsonObject == null) {
                            hasSuccess = true;
                        }
                        String status = jsonObject.getString("status");
                        if ("ok".equalsIgnoreCase(status)) {
                            hasSuccess = true;
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }
        j1 = j;
        d1 = d;
        k1 = k;
        macd1 = macd;
    }

    private int check1Min(double nowprice) throws IOException, HttpException {
        String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", "1min", "60");
        JSONObject obj = JSON.parseObject(res);
        JSONArray arr = obj.getJSONArray("data");
        List<Double> list = new ArrayList<>();
        for (int i = 0; i <= arr.size() - 1; i++) {
            JSONObject json = arr.getJSONObject(i);
            list.add((json.getDouble("open") + json.getDouble("close")) / 2);
        }
        DoubleSummaryStatistics stream = list.stream().mapToDouble(e -> e).summaryStatistics();
        double avg = stream.getAverage();
        if (nowprice > avg + 6) {
            return -1;
        }
        if (nowprice < avg - 6) {
            return 1;
        }
        return 0;

    }


    private int checkFiveMin() throws IOException, HttpException {
        int tem = 0;
        int tem1 = 0;
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
            if (d < k && d < j) {
                tem++;
            }
            if (d > k && d > j) {
                tem1--;
            }
        }
        if (Math.abs(tem) > Math.abs(tem1)) {
            return tem;
        }
        if (Math.abs(tem) < Math.abs(tem1)) {
            return tem1;
        }
        return 0;
    }


    private String doss(String buyOrSell, String openOrClose, String contractCode, String price) throws IOException, HttpException {
        return futurePostV1.futureContractOrder("BTC", "quarter", contractCode, "", "", "4",
                buyOrSell, openOrClose, "20", "opponent");
    }


    private void checkHuoBi() throws Exception {
        kdjMap.clear();
        macdMap.clear();
        JSONArray arr = getData();
        double[] maxPrice = new double[arr.size()];
        double[] minPrice = new double[arr.size()];
        double[] closePrice = new double[arr.size()];
        List<Double> closelist = new ArrayList<>();
        ChartDataBean character = new ChartDataBean();
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
        macdMap = IndicatrixUtils.getMACD(closelist, 12, 26, 9);
        kdjMap = KDJ.getKDJ(14, 1, 3, character);
    }

    private JSONArray getData() throws IOException, HttpException {
        String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", "1min", "480");
        JSONObject obj = JSON.parseObject(res);
        JSONArray arr = obj.getJSONArray("data");
        return arr;
    }

    /**
     * @return boolean  返回类型
     * @throws
     * @Title: checkKDJ
     * @Description: 校验KDJ是否满足要求
     */

    public Map<String, Double> checkKDJ(double[] maxPrice, double[] minPrice, double[] closePrice) {
        return IndicatrixUtils.KDJ(maxPrice, minPrice, closePrice);
    }


}