package com.teachy.coins.tasks;import com.alibaba.fastjson.JSONArray;import com.alibaba.fastjson.JSONObject;import com.teachy.coins.bibixcom.BiBoxClient;import com.teachy.coins.bibixcom.BiBoxHttpClient;import com.teachy.coins.bibixcom.BiBoxHttpClientConfig;import com.teachy.coins.bibixcom.enums.OrderSideEnum;import lombok.extern.slf4j.Slf4j;import org.springframework.scheduling.annotation.Scheduled;import org.springframework.stereotype.Component;import java.text.DecimalFormat;import java.util.ArrayList;import java.util.Collections;import java.util.Iterator;import java.util.List;/** * @ClassName ZBtest01 * @Description TODO * @Author gang.tu * @Date 2020/10/19 15:48 *///@Component@Slf4jpublic class BBXtest01 {    private static final String API_KEY = "";    private static final String SECRET_KEY = "";    List<String> list = Collections.synchronizedList(new ArrayList<>());    BiBoxHttpClientConfig config = BiBoxHttpClientConfig            .custom().host("https://api.bibox.live")            .apiKey(API_KEY)            .secret(SECRET_KEY)            .build();    BiBoxHttpClient client = BiBoxClient.of(config);    private final String TICKER_NAME = "UNW_USDT";    private double MAX_PRICE = 0.04;    private static volatile double firstSell = 0;    private static volatile double firstBuy = 0;    private static double usdt = 0;    DecimalFormat df = new DecimalFormat("#.000");    @Scheduled(cron = "*/1 * * * * ?")    public void doTask1() {        try {            task();        } catch (Exception e) {            log.info("获取数据出错:{}", e.getMessage(), e);        }    }    public void task() {        new Thread(new FirstSell()).start();        new Thread(new AvailableUSDT()).start();        new Thread(new AvailableUSDT1()).start();        while (true) {            try {                cancelTrade();                if (firstSell == 0 || firstBuy == 0 || usdt == 0) {                    Thread.sleep(100);                    continue;                }                if (usdt < 10) {                    log.info("usdt<20.....");                    continue;                }                if (firstBuy > MAX_PRICE) {                    log.info("buy:{}  price is too high.....", firstBuy);                    firstBuy = MAX_PRICE;                }                buy();                Thread.sleep(200);            } catch (Exception e) {            }        }    }    public void buy() throws Exception {        double price = firstBuy;        double u = usdt;        String amount = df.format((u - 2) / price);        if (price > MAX_PRICE) {            return;        }        JSONObject jsonObject = JSONObject.parseObject(client.orderPendingTrade("123333", TICKER_NAME, OrderSideEnum.BID, price, Double.valueOf(amount)));        String aLong = jsonObject.getJSONArray("result").getJSONObject(0).getString("result");        list.add(aLong);    }    public void cancelTrade() throws Exception {        Iterator<String> iterator = list.iterator();        while (iterator.hasNext()) {            String s = iterator.next();            JSONObject jsonObject = JSONObject.parseObject(client.orderPendingCancelTrade("123333", s));            String aLong = jsonObject.getJSONArray("result").getJSONObject(0).getString("result");            if ("OK".equals(aLong)) {                list.remove(s);            }        }    }    class FirstSell implements Runnable {        @Override        public void run() {            while (true) {                try {                    Thread.sleep(100);                    JSONObject jsonObject = JSONObject.parseObject(client.ticker(TICKER_NAME));                    firstSell = jsonObject.getJSONArray("result").getJSONObject(0).getJSONObject("result").getDoubleValue("sell");                    firstBuy = Double.parseDouble(df.format(firstSell * (1 + 0.1)));                } catch (Exception e) {                }            }        }    }    class AvailableUSDT1 implements Runnable {        @Override        public void run() {            while (true) {                try {                    Thread.sleep(100);                    JSONObject jsonObject = JSONObject.parseObject(client.transferMainAssets(1));                    JSONArray jsonArray = jsonObject.getJSONArray("result").getJSONObject(0).getJSONObject("result").getJSONArray("assets_list");                    for (int i = 0; i < jsonArray.size(); i++) {                        JSONObject object = jsonArray.getJSONObject(i);                        if ("USDT".equals(object.getString("coin_symbol"))) {                            usdt = Double.parseDouble(df.format(object.getDouble("balance")));                        }                    }                } catch (Exception e) {                }            }        }    }    class AvailableUSDT implements Runnable {        @Override        public void run() {            while (true) {                try {                    Thread.sleep(100);                    JSONObject jsonObject = JSONObject.parseObject(client.transferAssets(1));                    JSONArray jsonArray = jsonObject.getJSONArray("result").getJSONObject(0).getJSONObject("result").getJSONArray("assets_list");                    for (int i = 0; i < jsonArray.size(); i++) {                        JSONObject object = jsonArray.getJSONObject(i);                        if ("USDT".equals(object.getString("coin_symbol"))) {                            usdt = Double.parseDouble(df.format(object.getDouble("balance")));                        }                    }                } catch (Exception e) {                }            }        }    }}