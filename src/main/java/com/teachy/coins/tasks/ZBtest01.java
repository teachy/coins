package com.teachy.coins.tasks;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.zb.EncryDigestUtil;
import com.teachy.coins.zb.HttpUtilManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.teachy.coins.zb.MapSort.sortMapByKey;
import static com.teachy.coins.zb.MapSort.toStringMap;


/**
 * @ClassName ZBtest01
 * @Description TODO
 * @Author gang.tu
 * @Date 2020/10/19 15:48
 */
@Component
@Slf4j
public class ZBtest01 {

    private final String URL_TICKER = "/ticker";
    private final String TICKER_NAME = "m_usdt";
    private final Integer MAX_PRICE = 20;

    private static double firstSell = 0;
    private static double firstBuy = 0;
    private static double usdt = 0;
    DecimalFormat df = new DecimalFormat("#.00");

    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask1() {
        try {
            task();
        } catch (Exception e) {
            log.info("获取数据出错:{}", e.getMessage(), e);
        }
    }

    public void task() {
        new Thread(new FirstSell()).start();
        new Thread(new AvailableUSDT()).start();
        while (true) {
            try {
                if (firstSell == 0 || firstBuy == 0 || usdt == 0) {
                    Thread.sleep(200);
                    continue;
                }
                if (usdt < 10) {
                    Thread.sleep(20000000);
                }
                if (firstBuy > MAX_PRICE) {
                    log.info("buy:{}  price is too high.....", firstBuy);
                    Thread.sleep(200);
                    continue;
                }
                buy();
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
    }

    public void buy() throws Exception {
        log.info("first sell is:{}", firstSell);
        log.info("first buy is:{}", firstBuy);
        log.info("available usdt:{}", usdt);
        log.info("max buy:{}", df.format((usdt - 2) / firstBuy));
        Map<String, String> params = new HashMap<>();
        String orderUrl = "https://trade.zb.live/api/order";
        params.put("method", "order");
        params.put("accesskey", "");
        params.put("acctType", "0");
        params.put("amount", df.format((usdt - 2) / firstBuy));
        params.put("currency", TICKER_NAME);
        params.put("orderType", "2");
        params.put("price", firstBuy + "");
        params.put("tradeType", "1");
        params.put("sign", getSign(params));
        params.put("reqTime", Convert.toStr(System.currentTimeMillis()));
        orderUrl = orderUrl + "?" + buildMap(sortMapByKey(params));
        System.out.println(HttpUtilManager.getInstance().requestHttpGet(orderUrl, Collections.EMPTY_MAP));
    }

    class FirstSell implements Runnable {
        @Override
        public void run() {
            Map<String, String> params = new HashMap<>();
            params.put("market", TICKER_NAME);
            while (true) {
                try {
                    Thread.sleep(200);
                    JSONObject jsonObject = JSONObject.parseObject(HttpUtilManager.getInstance().requestHttpGet("http://api.zb.live/data/v1" + URL_TICKER, params));
                    firstSell = jsonObject.getJSONObject("ticker").getDouble("sell");
                    firstBuy = Double.parseDouble(df.format(firstSell * (1 + 0.01)));
                } catch (Exception e) {
                }
            }
        }
    }

    class AvailableUSDT implements Runnable {
        @Override
        public void run() {
            Map<String, String> params = new HashMap<>();
            while (true) {
                try {
                    Thread.sleep(200);
                    params.clear();
                    String userUrl = "https://trade.zb.live/api/getAccountInfo";
                    params.put("method", "getAccountInfo");
                    params.put("accesskey", "");
                    params.put("sign", getSign("getAccountInfo"));
                    params.put("reqTime", Convert.toStr(System.currentTimeMillis()));
                    userUrl = userUrl + "?" + buildMap(params);
                    JSONObject jsonObject = JSONObject.parseObject(HttpUtilManager.getInstance().requestHttpGet(userUrl, Collections.EMPTY_MAP));
                    JSONArray jsonArray = jsonObject.getJSONObject("result").getJSONArray("coins");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        if ("USDT".equals(object.getString("enName"))) {
                            usdt = Double.parseDouble(df.format(object.getDouble("available")));
                        }
                    }
                } catch (Exception e) {

                }
            }

        }
    }

    public String getSign(String name) {
        Map<String, String> params = new HashMap<>();
        params.put("method", name);
        params.put("accesskey", "");
        return EncryDigestUtil.hmacSign(toStringMap(params), EncryDigestUtil.digest(""));
    }

    public String getSign(Map<String, String> params) {
        return EncryDigestUtil.hmacSign(toStringMap(params), EncryDigestUtil.digest(""));
    }

    public String buildMap(Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        if (map.size() > 0) {
            for (String key : map.keySet()) {
                sb.append(key + "=");
                if (StringUtils.isEmpty(map.get(key))) {
                    sb.append("&");
                } else {
                    String value = map.get(key);
                    try {
                        value = URLEncoder.encode(value, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    sb.append(value + "&");
                }
            }
        }
        return sb.toString();
    }
}
