package com.teachy.coins.tasks;import cn.hutool.core.convert.Convert;import cn.hutool.crypto.SecureUtil;import com.alibaba.fastjson.JSONArray;import com.alibaba.fastjson.JSONObject;import com.teachy.coins.zb.HttpUtilManager;import lombok.extern.slf4j.Slf4j;import org.apache.commons.lang3.StringUtils;import org.springframework.scheduling.annotation.Scheduled;import org.springframework.stereotype.Component;import java.io.UnsupportedEncodingException;import java.net.URLEncoder;import java.text.DecimalFormat;import java.util.ArrayList;import java.util.Collections;import java.util.HashMap;import java.util.List;import java.util.Map;/** * @ClassName ZBtest01 * @Description Biki * @Author gang.tu * @Date 2020/10/19 15:48 */@Component@Slf4jpublic class BKtest01 {    private static final String API_KEY = "";    private static final String SECRET_KEY = "";    List<String> list = Collections.synchronizedList(new ArrayList<>());    private final String URL_TICKER = "/open/api/get_ticker";    private final String TICKER_NAME = "fompusdt";    private final Integer MAX_PRICE = 80;    private static volatile double firstSell = 0;    private static volatile double firstBuy = 0;    private static double usdt = 0;    DecimalFormat df = new DecimalFormat("#.00");    @Scheduled(cron = "*/1 * * * * ?")    public void doTask1() {        try {            task();        } catch (Exception e) {            log.info("获取数据出错:{}", e.getMessage(), e);        }    }    public void task() {        new Thread(new FirstSell()).start();        new Thread(new AvailableUSDT()).start();        while (true) {            try {                if (firstSell == 0 || firstBuy == 0 || usdt == 0) {                    Thread.sleep(100);                    continue;                }                cancelTrade();                if (usdt < 20) {                    log.info("usdt<20.....");                    Thread.sleep(100);                    continue;                }                if (firstBuy > MAX_PRICE) {                    log.info("buy:{}  price is too high.....", firstBuy);                    Thread.sleep(100);                    continue;                }                buy();            } catch (Exception e) {            }        }    }    public void buy() throws Exception {        double price = firstBuy;//多线程问题        double u = usdt;        String amount = df.format((u - 2) / price);        String orderUrl = "https://openapi.biki.cc/open/api/create_order";        if (price > MAX_PRICE) {            return;        }        String time = Convert.toStr(System.currentTimeMillis()).substring(0, 9);        String signStr = "api_key" + API_KEY + "price" + price + "sideBUYsymbol" + TICKER_NAME + "time" + time + "type1volume" + amount + SECRET_KEY;        String sign = getSign(signStr);        Map<String, String> map = new HashMap<>();        map.put("api_key", API_KEY);        map.put("price", price + "");        map.put("side", "BUY");        map.put("symbol", TICKER_NAME);        map.put("volume", amount);        map.put("sign", sign);        map.put("time", time);        map.put("type", 1 + "");        System.out.println(HttpUtilManager.getInstance().requestHttpPost(orderUrl, map));    }    public void cancelTrade() throws Exception {        String time = Convert.toStr(System.currentTimeMillis()).substring(0, 9);        String orderUrl = "https://openapi.biki.cc/open/api/cancel_order_all";        String signStr = "api_key" + API_KEY + "symbol" + TICKER_NAME + "time" + time + SECRET_KEY;        String sign = getSign(signStr);        Map<String, String> map = new HashMap<>();        map.put("api_key", API_KEY);        map.put("symbol", TICKER_NAME);        map.put("sign", sign);        map.put("time", time);        System.out.println(HttpUtilManager.getInstance().requestHttpPost(orderUrl, map));    }    class FirstSell implements Runnable {        @Override        public void run() {            Map<String, String> params = new HashMap<>();            params.put("symbol", TICKER_NAME);            while (true) {                try {                    Thread.sleep(100);                    JSONObject jsonObject = JSONObject.parseObject(HttpUtilManager.getInstance().requestHttpGet("https://openapi.biki.cc" + URL_TICKER, params));                    firstSell = jsonObject.getJSONObject("data").getDouble("sell");                    firstBuy = Double.parseDouble(df.format(firstSell * (1 + 0.1)));                } catch (Exception e) {                }            }        }    }    class AvailableUSDT implements Runnable {        @Override        public void run() {            Map<String, String> params = new HashMap<>();            while (true) {                try {                    Thread.sleep(100);                    String userUrl = "https://openapi.biki.cc/open/api/user/account";                    String time = Convert.toStr(System.currentTimeMillis()).substring(0, 9);                    String url = userUrl + "?api_key=" + API_KEY + "&time="                            + time + "&sign=" + getSign("api_key" + API_KEY + "time" + time + SECRET_KEY);                    JSONObject jsonObject = JSONObject.parseObject(HttpUtilManager.getInstance().requestHttpGet(url, params));                    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("coin_list");                    for (int i = 0; i < jsonArray.size(); i++) {                        JSONObject object = jsonArray.getJSONObject(i);                        if ("usdt".equalsIgnoreCase(object.getString("coin"))) {                            usdt = Double.parseDouble(df.format(object.getDouble("normal")));                        }                    }                } catch (Exception e) {                }            }        }    }    public String getSign(String name) {        return SecureUtil.md5(name);    }}