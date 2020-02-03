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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


//@Component
@Slf4j
public class HuobiTest16 {

    private static final String API_KEY = "12345678";
    private static final String SECRET_KEY = "123456789";
    private static final String URL_PREX = "https://api.btcgateway.pro";
    private static IHbdmRestApi futureGetV1 = new HbdmRestApiV1(URL_PREX);
    private static IHbdmRestApi futurePostV1 = new HbdmRestApiV1(URL_PREX, API_KEY, SECRET_KEY);
    Map<String, Double> kdjMap = new HashMap<>();
    Map<String, Double> macdMap = new HashMap<>();
    private static int buyOrSell = 0;
    private static double macd1 = 0;
    @Value("${huobi.volume}")
    int buySize;
    private static long begin = 0L;
    List<String> checkList = Arrays.asList("5min", "15min", "30min", "60min");
    Set<Double> buyList = new HashSet<>();
    private static boolean isSell = false;
    private static int PRICES_SIZE = 10;
    private static int MAX_WIN = 20;
    private static String volume = "0";
    List<Double> prices = new ArrayList<>(PRICES_SIZE);
    List<Double> prices1 = new ArrayList<>(PRICES_SIZE);
    List<Double> listk = new ArrayList<>();
    List<Double> listd = new ArrayList<>();

    @Scheduled(cron = "*/2 * * * * ?")
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
            log.info("采集错误1:{}", e.getMessage());
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
                    close("sell", volume);
                }
                if (buyOrSell == -1) {
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
            if (prices.get(0) > prices.get(1) && prices.get(0) > prices.get(prices.size() - 1) && prices.get(prices.size() - 2) > prices.get(prices.size() - 1) && prices.get(prices.size() - 1) < avg) {
                temp = -1;
            }
            if (prices.get(prices.size() - 1) > prices.get(prices.size() - 2) && prices.get(prices.size() - 1) > prices.get(0) && prices.get(1) > prices.get(0) && prices.get(prices.size() - 1) > avg) {
                temp = 1;
            }
            return temp;
        }
    }

    private void task() throws Exception {
        futurePostV1.futureContractCancelall("BTC");
        checkHuoBi();
        if (kdjMap.isEmpty() || macdMap.isEmpty()) {
            return;
        }
        double k = kdjMap.get("K");
        double d = kdjMap.get("D");
        double j = kdjMap.get("J");
        double macd = macdMap.get("MACD");
        JSONObject jsonObject;
        double cost_open = 0;
        double last_price = 0;
        String positionInfo1 = futurePostV1.futureMarketHistoryTrade("BTC_CQ", "1");
        jsonObject = JSON.parseObject(positionInfo1);
        last_price = jsonObject.getJSONArray("data").getJSONObject(0).getJSONArray("data").getJSONObject(0).getDouble("price");
        String positionInfo = futurePostV1.futureContractPositionInfo("BTC");
        jsonObject = JSON.parseObject(positionInfo);
        if (jsonObject.getJSONArray("data").size() > 0) {
            cost_open = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("cost_open");
            last_price = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("last_price");
            String direction = jsonObject.getJSONArray("data").getJSONObject(0).getString("direction");
            volume = jsonObject.getJSONArray("data").getJSONObject(0).getString("volume");
            buyOrSell = direction.equalsIgnoreCase("buy") ? 1 : -1;
            buyList.add(cost_open);
        } else {
            volume = "0";
            buyList.clear();
            begin = System.currentTimeMillis();
            buyOrSell = 0;
            isSell = false;
            MAX_WIN = 20;
        }

        int temp1 = checkForSell1();
        int res = checkForSell2();
        if (res == 1 || temp1 == checkList.size() || (d < k && d < j && d < 30 && macd > macd1 && j - d > 20 && checkFiveMin() >= checkList.size() - 1)) {
            log.info("open buy --size  res:{}  temp1:{}", res, temp1);
            if (buyOrSell != -1) {
                if (buyList.isEmpty()) {
                    open("buy", buySize + "");
                } else if (cost_open - last_price > last_price / 100 && checkList(last_price)) {
                    log.info("开始补仓，大于50---开仓价格:{}补仓价格:{}", cost_open, last_price);
                    open("buy", buySize + "");
                }
            } else {
                log.info("可能1");
                isSell = true;
            }
        }
        if (res == -1 || temp1 == checkList.size() * -1 || (d > k && d > j && d > 70 && macd < macd1 && d - j > 20 && checkFiveMin() <= (checkList.size() - 1) * -1)) {
            log.info("open sell --size  res:{}  temp1:{}", res, temp1);
            if (buyOrSell != 1) {
                if (buyList.isEmpty()) {
                    open("sell", buySize + "");
                } else if (last_price - cost_open > last_price / 100 && checkList(last_price)) {
                    log.info("开始补仓，大于50---开仓价格:{}补仓价格:{}", cost_open, last_price);
                    open("sell", buySize + "");
                }
            } else {
                log.info("可能2");
                isSell = true;
            }

        }
        if (!volume.equals("0")) {
            int temp = checkForSell();
            if (buyOrSell == 1) {
                if (cost_open - last_price > last_price / 120) {
                    MAX_WIN = PRICES_SIZE - 5;
                    log.info("修改盈利价格：{}", MAX_WIN);
                }
                if (cost_open - last_price > last_price / 50 && checkList(last_price)) {
                    log.info("开始补仓，大于100---开仓价格:{}补仓价格:{}", cost_open, last_price);
                    open("buy", buySize + "");
                }
                if (temp == checkList.size() * -1) {
                    log.info("止损策略：sell");
                    isSell = true;
                }
            }
            if (buyOrSell == -1) {
                if (last_price - cost_open > last_price / 120) {
                    MAX_WIN = PRICES_SIZE - 5;
                    log.info("修改盈利价格：{}", MAX_WIN);
                }
                if (last_price - cost_open > last_price / 50 && checkList(last_price)) {
                    log.info("开始补仓，大于100---开仓价格:{}补仓价格:{}", cost_open, last_price);
                    open("sell", buySize + "");
                }
                if (temp == checkList.size()) {
                    log.info("止损策略：buy");
                    isSell = true;
                }
            }
            if (begin < 1) {
                begin = System.currentTimeMillis();
            }
            boolean isMore = Integer.valueOf(volume.substring(0, volume.indexOf("."))) <= buySize;
            if (isMore && System.currentTimeMillis() - begin < 180 * 60 * 1000 && MAX_WIN == 20) {
                if (buyOrSell == 1) {
                    if (last_price - cost_open >= MAX_WIN && (d > j || d > k || Math.abs(d - j) < 10) && macd < macd1 && Math.abs(macd - macd1) > 0.05) {
                        if (checkFive(1) && res != 1) {
                            log.info("可能5");
                            isSell = true;
                        }
                    }
                }
                if (buyOrSell == -1) {
                    if (cost_open - last_price >= MAX_WIN && (d < j || d < k || Math.abs(d - j) < 10) && macd > macd1 && Math.abs(macd - macd1) > 0.05) {
                        if (checkFive(-1) && res != -1) {
                            log.info("可能6");
                            isSell = true;
                        }
                    }
                }
            } else {
                if (buyOrSell == 1) {
                    boolean tem = d > j || d > k || Math.abs(d - j) < 10;
                    if (last_price > cost_open + 10 && tem) {
                        log.info("可能7");
                        isSell = true;
                    }
                }
                if (buyOrSell == -1) {
                    boolean tem = d < j || d < k || Math.abs(d - j) < 10;
                    if (cost_open > last_price + 10 && tem) {
                        log.info("可能8");
                        isSell = true;
                    }
                }
            }
        }
        if (macd1 != macd) {
            macd1 = macd;
        }
    }


    private int checkForSell2() {
        DoubleSummaryStatistics stream = listk.stream().mapToDouble(e -> e).summaryStatistics();
        DoubleSummaryStatistics stream1 = listd.stream().mapToDouble(e -> e).summaryStatistics();
        System.out.println(stream.getSum() - stream1.getSum());
        if (stream.getSum() - stream1.getSum() > 200) {
            return 1;
        }
        if (stream.getSum() - stream1.getSum() < -200) {
            return -1;
        }
        return 0;
    }

    private void open(String bos, String volume) throws IOException, HttpException {
        if (bos.equals("buy")) {
            if (checkPrice(prices1) < 0) {
                log.info("buy 条件不满足：{}", prices1);
                return;
            }
        } else {
            if (checkPrice(prices1) > 0) {
                log.info("sell 条件不满足：{}", prices1);
                return;
            }
        }
        String contractInfo = futureGetV1.futureContractInfo("BTC", "quarter", "");
        String contractCode = JSON.parseObject(contractInfo).getJSONArray("data").getJSONObject(0).getString("contract_code");
        String contractOrder = doss(bos, "open", contractCode, volume);
//        String status = JSON.parseObject(contractOrder).getString("status");
//        if ("ok".equalsIgnoreCase(status)) {
//            buyList.add(last_price);
//        }
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
            if (Math.abs(lastPrice - d) < lastPrice / 100) {
                return false;
            }
        }
        return true;
    }

    private int check1Min(double nowprice) throws IOException, HttpException {
        String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", "1min", "30");
        JSONObject obj = JSON.parseObject(res);
        JSONArray arr = obj.getJSONArray("data");
        List<Double> list = new ArrayList<>();
        for (int i = 0; i <= arr.size() - 1; i++) {
            JSONObject json = arr.getJSONObject(i);
            list.add((json.getDouble("open") + json.getDouble("close")) / 2);
        }
        DoubleSummaryStatistics stream = list.stream().mapToDouble(e -> e).summaryStatistics();
        double avg = stream.getAverage();
        if (nowprice > avg + 15) {
            return -1;
        }
        if (nowprice < avg - 15) {
            return 1;
        }
        return 0;

    }

    private int checkForSell() throws IOException, HttpException {
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

    private int checkForSell1() throws IOException, HttpException {
        int tem = 0;
        int tem1 = 0;
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
            if (d < k && d < j && j - d > 30 && d < 60) {
                tem++;
            }
            if (d > k && d > j && d - j > 30 && d > 40) {
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
            if (d < k && d < j && d < 40) {
                tem++;
            }
            if (d > k && d > j && d > 60) {
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
            if (d > k || Math.abs(d - k) < 15 || Math.abs(d - j) < 15 || d > j) {
                return true;
            }
            return false;
        }
        if (biaoshi == -1) {
            if (d < k || Math.abs(d - k) < 15 || Math.abs(d - j) < 15 || d < j) {
                return true;
            }
            return false;
        }
        return false;
    }

    private String doss(String buyOrSell, String openOrClose, String contractCode, String volume) throws IOException, HttpException {
        return futurePostV1.futureContractOrder("BTC", "quarter", contractCode, "", "", volume,
                buyOrSell, openOrClose, "20", "opponent");
    }


    private void checkHuoBi() throws Exception {
        kdjMap.clear();
        macdMap.clear();
        JSONArray arr = getData();
        double[] maxPrice = new double[arr.size() + 1];
        double[] minPrice = new double[arr.size() + 1];
        double[] closePrice = new double[arr.size() + 1];
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