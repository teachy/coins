package com.teachy.coins.tasks;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.huobi.common.api.HbdmRestApiV1;
import com.teachy.coins.huobi.common.api.IHbdmRestApi;
import com.teachy.coins.infrastructure.persistence.CoinListDao;
import com.teachy.coins.model.bo.CoinListBo;
import com.teachy.coins.utils.ChartDataBean;
import com.teachy.coins.utils.IndicatrixUtils;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


//@Component
@Slf4j
public class HuobiTest23 {

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
    List<String> checkList = Arrays.asList("5min", "15min", "30min", "60min", "4hour");
    Set<Double> buyList = new HashSet<>();
    private static boolean isSell = false;
    private static int PRICES_SIZE = 10;
    private static int MAX_WIN = 50;
    private static double HASH_WIN = 0;
    private static String volume = "0";
    List<Double> prices = new ArrayList<>(PRICES_SIZE);
    List<Double> prices1 = new ArrayList<>(PRICES_SIZE);
    List<Double> listk = new ArrayList<>();
    List<Double> listd = new ArrayList<>();
    private static double last_sell_price = 0;
    double margin_static;
    @Autowired
    CoinListDao coinListDao;

    @Scheduled(cron = "*/1 * * * * ?")
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

    @Scheduled(cron = "*/15 * * * * ?")
    public void doTask2() {
        try {
            task2();
        } catch (Exception e) {
            log.info("采集错误2:{}", e.getMessage());
        }
    }

    private void task2() throws IOException, HttpException {
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
            coinListBo.setWinCount(margin_static - firstCoinListBo.getVolume());
            String winCountPercent = new DecimalFormat("0.00").format(coinListBo.getWinCount()*100 / firstCoinListBo.getVolume()) + "%";
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
        String allMoney = futurePostV1.futureContractAccountInfo("BTC");
        margin_static = JSON.parseObject(allMoney).getJSONArray("data").getJSONObject(0).getDouble("margin_static");
        String positionInfo1 = futurePostV1.futureMarketHistoryTrade("BTC_CQ", "1");
        jsonObject = JSON.parseObject(positionInfo1);
        last_price = jsonObject.getJSONArray("data").getJSONObject(0).getJSONArray("data").getJSONObject(0).getDouble("price");
        String positionInfo = futurePostV1.futureContractPositionInfo("BTC");
        jsonObject = JSON.parseObject(positionInfo);
        buySize = (int) (Math.floor(margin_static * last_price * 6.9 * 20 / 700) - 1);
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
            buyOrSell = 0;
            isSell = false;
            HASH_WIN = 0;
        }
        if (volume.equals("0") && Math.abs(last_price - last_sell_price) > 30) {
            int temp1 = checkForSell1();
            int res = checkForSell2();
            if (res == 1 && temp1 == checkList.size()) {
                log.info("open buy --size  res:{}  temp1:{}", res, temp1);
                open("buy", buySize + "");
            }
            if (res == -1 && temp1 == checkList.size() * -1) {
                log.info("open sell --size  res:{}  temp1:{}", res, temp1);
                open("sell", buySize + "");
            }
        }
        if (!volume.equals("0")) {
            if (buyOrSell == 1) {
                if (last_price - cost_open > HASH_WIN) {
                    HASH_WIN = last_price - cost_open;
                    return;
                }
                if (cost_open - last_price > 50) {
                    log.info("可能7--止损");
                    isSell = true;
                }
                if (last_price - cost_open >= MAX_WIN && (d > j || d > k || Math.abs(d - j) < 30)) {
                    if (checkFive(1)) {
                        log.info("可能5");
                        isSell = true;
                    }
                }
            }
            if (buyOrSell == -1) {
                if (cost_open - last_price > HASH_WIN) {
                    HASH_WIN = cost_open - last_price;
                    return;
                }
                if (last_price - cost_open > 50) {
                    log.info("可能8--止损");
                    isSell = true;
                }
                if (cost_open - last_price >= MAX_WIN && (d < j || d < k || Math.abs(d - j) < 30)) {
                    if (checkFive(-1)) {
                        log.info("可能6");
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
        if (stream.getSum() - stream1.getSum() > 250) {
            return 1;
        }
        if (stream.getSum() - stream1.getSum() < -250) {
            return -1;
        }
        return 0;
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
            if (period.equals("4hour")) {
                if (d < 30) {
                    tem++;
                }
                if (d > 70) {
                    tem1--;
                }
            } else if (period.equals("60min")) {
                if (d < 35) {
                    tem++;
                }
                if (d > 65) {
                    tem1--;
                }
            } else if (period.equals("30min")) {
                if (d < 60) {
                    tem++;
                }
                if (d > 40) {
                    tem1--;
                }
            } else if (period.equals("15min")) {
                if (d < 65) {
                    tem++;
                }
                if (d > 35) {
                    tem1--;
                }
            } else if (period.equals("5min")) {
                if (d < 70) {
                    tem++;
                }
                if (d > 30) {
                    tem1--;
                }
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
            if (d > k || Math.abs(d - k) < 15 || Math.abs(d - j) < 30 || d > j) {
                return true;
            }
            return false;
        }
        if (biaoshi == -1) {
            if (d < k || Math.abs(d - k) < 15 || Math.abs(d - j) < 30 || d < j) {
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

    private CoinListBo firstCoinListBo;
}