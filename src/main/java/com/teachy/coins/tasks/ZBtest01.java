package com.teachy.coins.tasks;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.zb.EncryDigestUtil;
import com.teachy.coins.zb.HttpUtilManager;
import com.teachy.coins.zb.MapSort;
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
    private final Integer MAX_PRICE = 20;

    @Scheduled(cron = "*/3 * * * * ?")
    public void doTask1() {
        try {
            task();
        } catch (Exception e) {
            log.info("获取数据出错:{}", e.getMessage(),e);
        }
    }

    public void task() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("market", "hc_usdt");
        JSONObject jsonObject = JSONObject.parseObject(HttpUtilManager.getInstance().requestHttpGet("http://api.zb.live/data/v1" + URL_TICKER, params));
        double firstSell = jsonObject.getJSONObject("ticker").getDouble("sell");
        log.info("first sell is:{}", firstSell);
        double firstBuy = firstSell * (1 + 0.02);
        DecimalFormat df = new DecimalFormat("#.00");
        firstBuy = Double.parseDouble(df.format(firstBuy));
        log.info("first buy is:{}", firstBuy);
        if (firstBuy > MAX_PRICE) {
            log.info("price is too high.....");
            return;
        }
        params.clear();
        params.put("method","getAccountInfo");
        params.put("accesskey","");
        String sign = EncryDigestUtil.hmacSign(MapSort.toStringMap(params), EncryDigestUtil.digest(""));
        params.clear();
        String userUrl = "https://trade.zb.live/api/getAccountInfo";
        params.put("method","getAccountInfo");
        params.put("accesskey","");
        params.put("sign",sign);
        params.put("reqTime", Convert.toStr(System.currentTimeMillis()));
        userUrl = userUrl+"?"+ buildMap(params);
        jsonObject = JSONObject.parseObject(HttpUtilManager.getInstance().requestHttpGet(userUrl,Collections.EMPTY_MAP));
        JSONArray jsonArray = jsonObject.getJSONObject("result").getJSONArray("coins");
        double usdt = 0;
        for(int i =0;i<jsonArray.size();i++){
            JSONObject object = jsonArray.getJSONObject(i);
            if("USDT".equals(object.getString("enName"))){
                usdt =Double.parseDouble(df.format(object.getDouble("available")));
            }
        }
        log.info("available usdt:{}",usdt);
        log.info("max buy:{}",df.format((usdt-2)/firstBuy));
        System.out.println();
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
