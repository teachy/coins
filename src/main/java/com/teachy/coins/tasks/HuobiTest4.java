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

;


@Component
@Slf4j
public class HuobiTest4 {

    private static final String API_KEY = "12345678";
    private static final String SECRET_KEY = "123456789";
    private static final String URL_PREX = "https://api.btcgateway.pro";
    private static IHbdmRestApi futureGetV1 = new HbdmRestApiV1(URL_PREX);
    private static IHbdmRestApi futurePostV1 = new HbdmRestApiV1(URL_PREX, API_KEY, SECRET_KEY);

    Map<String, Double> kdjMap = new HashMap<>();
    Map<String, Double> macdMap = new HashMap<>();
    private static int buyOrSell = 0;

    private static double j1 = 0;
    private static double d1 = 0;
    private static double k1 = 0;
    private static double macd1 = 0;
    List<String> checkList = Arrays.asList("5min", "15min", "30min", "60min");
    Set<Double> buyList = new HashSet<>();

    @Scheduled(cron = "*/3 * * * * ?")
    public void doTask() {
        try {
            task();
        } catch (Exception e) {
            log.info("采集错误:{}", e.getMessage());
        }
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

//        String allMoney = futurePostV1.futureContractAccountInfo("BTC");
//        double margin_static = JSON.parseObject(allMoney).getJSONArray("data").getJSONObject(0).getDouble("margin_static");

        String positionInfo = futurePostV1.futureContractPositionInfo("BTC");
        jsonObject = JSON.parseObject(positionInfo);
        if (jsonObject.getJSONArray("data").size() > 0) {
            cost_open = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("cost_open");
            last_price = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("last_price");
            String direction = jsonObject.getJSONArray("data").getJSONObject(0).getString("direction");
            String type = direction.equalsIgnoreCase("buy") ? "做多" : "做空";
            volume = jsonObject.getJSONArray("data").getJSONObject(0).getString("volume");
            buyOrSell = direction.equalsIgnoreCase("buy") ? 1 : -1;
            buyList.add(cost_open);
            if (Math.abs(cost_open - last_price) < 12) {
                return;
            }
//            log.info("BTC季度合约-->{}-->开仓价格：{}-->数量：{}-->当前btc数量：{}-->当前价格：{}", type, cost_open, volume, margin_static, last_price);
        }
        if (volume.equals("0")) {
            buyList.clear();
            buyOrSell = 0;
        }

        if (buyOrSell != -1) {
            if (d < k && d < j && d < 30) {
                if (checkFiveMin() == checkList.size()) {
                    if (buyList.isEmpty() || checkList(last_price)) {
                        log.info("open buy --size");
                        open("buy", "10");
                    }
                } else if (checkFiveMin() >= 1) {
                    if (check1Min(last_price) == 1) {
                        if (buyList.isEmpty() || checkList(last_price)) {
                            log.info("open buy");
                            open("buy", "10");
                        }
                    }
                }
            }
        }
        if (buyOrSell != 1) {
            if (d > k && d > j && d > 70) {
                if (checkFiveMin() == checkList.size() * -1) {
                    log.info("open sell --size");
                    open("sell", "10");
                } else if (checkFiveMin() <= -1) {
                    if (check1Min(last_price) == -1) {
                        if (buyList.isEmpty() || checkList(last_price)) {
                            log.info("open sell");
                            open("sell", "10");
                        }
                    }
                }
            }
        }

        if (!volume.equals("0")) {
            if (buyOrSell == 1) {
                boolean tem = (d < d1 && j < j1) || (k < k1 && j < j1) || (d < d1 && k < k1) && (d > j || d > k);
                if (tem && checkFive(1)) {
                    if (macd < macd1 && Math.abs(macd - macd1) > 0.05 && last_price > cost_open) {
                        log.info("close sell");
                        close("sell", volume);
                    }
                }
            }
            if (buyOrSell == -1) {
                boolean tem = (d > d1 && j > j1) || (k > k1 && j > j1) || (d > d1 && k > k1) && (d < j || d < k);
                if (tem && checkFive(-1)) {
                    if (macd > macd1 && Math.abs(macd - macd1) > 0.05 && last_price < cost_open) {
                        log.info("close buy");
                        close("buy", volume);
                    }
                }
            }
        }
        j1 = j;
        d1 = d;
        k1 = k;
        macd1 = macd;
    }

    private void open(String bos, String volume) throws IOException, HttpException {
        String contractInfo = futureGetV1.futureContractInfo("BTC", "quarter", "");
        String contractCode = JSON.parseObject(contractInfo).getJSONArray("data").getJSONObject(0).getString("contract_code");
        String contractOrder = doss(bos, "open", contractCode, volume);
        String status = JSON.parseObject(contractOrder).getString("status");
        if ("ok".equalsIgnoreCase(status)) {
//            buyList.add(last_price);
        }
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

    private boolean checkList(double lastPrice) {
        for (double d : buyList) {
            if (Math.abs(lastPrice - d) < 30) {
                return false;
            }
        }
        return true;
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
        if (nowprice > avg + 7) {
            return -1;
        }
        if (nowprice < avg - 7) {
            return 1;
        }
        return 0;

    }

    private boolean checkFive(int biaoshi) throws IOException, HttpException {
        String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", "5min", "240");
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
        if (biaoshi == 1) {
            if (d > k || d > j) {
                return true;
            }
            return false;
        }
        if (biaoshi == -1) {
            if (d < k || d < j) {
                return true;
            }
            return false;
        }
        return false;
    }


    private int checkFiveMin() throws IOException, HttpException {
        int tem = 0;
        int tem1 = 0;
        for (String period : checkList) {
            String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", period, "240");
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


    private String doss(String buyOrSell, String openOrClose, String contractCode, String volume) throws IOException, HttpException {
        return futurePostV1.futureContractOrder("BTC", "quarter", contractCode, "", "", volume,
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

}