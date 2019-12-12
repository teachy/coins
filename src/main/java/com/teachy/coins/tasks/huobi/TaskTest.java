package com.teachy.coins.tasks.huobi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName TaskTest
 * @Description
 * @Date 2019/12/5 11:10
 */
//@Component
@Slf4j
public class TaskTest extends HuobiBase {
    Map<String, Double> kdjMap = new HashMap<>();
    Map<String, Double> macdMap = new HashMap<>();
    private static int kdj = 0;
    private static double j1 = 0;
    private static double d1 = 0;
    private static double k1 = 0;
    private static double macd1 = 0;
    List<String> checkList = Arrays.asList("5min");

    @Scheduled(cron = "*/2 * * * * ?")
    public void doTask() {
        try {
            task();
        } catch (Exception e) {
            log.info("采集错误");
        }
    }


    private void task() throws Exception {
        get1Min();
        if (kdjMap.isEmpty() || macdMap.isEmpty()) {
            return;
        }
        double k = kdjMap.get("K");
        double d = kdjMap.get("D");
        double j = kdjMap.get("J");
        double macd = macdMap.get("MACD");
        String positionInfo = futurePostV1.futureContractPositionInfo("BTC");
        JSONObject jsonObject = JSON.parseObject(positionInfo);
        String volume = "0";
        double cost_open = 0;
        double last_price = 0;
        last_price = getLastPrice();
        if (jsonObject.getJSONArray("data").size() > 0) {
            cost_open = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("cost_open");
            last_price = jsonObject.getJSONArray("data").getJSONObject(0).getDouble("last_price");
            if (Math.abs(cost_open - last_price) < 10) {
                return;
            }
            volume = jsonObject.getJSONArray("data").getJSONObject(0).getString("volume");
        }

        System.out.println(volume);
        String contractCode = getContractCode();
        String price = getPrice();
        if (volume.equals("0")) {
            kdj = 0;
            if (d < 40) {
                if (d < k && d < j) {
                    if (checkFiveMin() == checkList.size()) {
                        if (check1Min(last_price) == 1) {
                            kdj = 1;
                            log.info("多确认--d:{}--j:{}--macd:{}", d, j, macd);
                        }
                    }
                }
            }
            if (d > 60) {
                if (d > k && d > j) {
                    if (checkFiveMin() == checkList.size() * -1) {
                        if (check1Min(last_price) == -1) {
                            kdj = -1;
                            log.info("空确认--d:{}--j:{}--macd:{}", d, j, macd);
                        }
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
                boolean tem = (d < d1 && j < j1) || (k < k1 && j < j1) || (d < d1 && k < k1);
                if (tem) {
                    if (macd < macd1 && Math.abs(macd - macd1) > 0.05) {
                        sell = true;
                    }
                }
            }
            if (kdj == -1) {
                boolean tem = (d > d1 && j > j1) || (k > k1 && j > j1) || (d > d1 && k > k1);
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
                            if (cost_open < last_price || cost_open - last_price > 20) {
                                contractOrder = doss("sell", "close", contractCode, price);
                            }
                        }
                        if (kdj == -1) {
                            if (cost_open > last_price || last_price - cost_open > 20) {
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


    private int check1Min(double nowPrice) throws IOException, HttpException {
        JSONArray arr = getData("1min", "60");
        int tem = 0;
        for (int i = 0; i <= arr.size() - 1; i++) {
            JSONObject json = arr.getJSONObject(i);
            if (nowPrice > json.getDouble("high")) {
                tem--;
            }
            if (nowPrice < json.getDouble("low")) {
                tem++;
            }
        }
        if (tem > 0) {
            return 1;
        } else {
            return -1;
        }


    }

    private int checkFiveMin() throws IOException, HttpException {
        int tem = 0;
        for (String period : checkList) {
            JSONArray arr = getData(period);
            Map<String, Double> kdj1 = getKdjMap(arr);
            double k = kdj1.get("K");
            double d = kdj1.get("D");
            double j = kdj1.get("J");
            if (d < 50) {
                if (d < k && d < j) {
                    tem++;
                }
            }
            if (d > 50) {
                if (d > k && d > j) {
                    tem--;
                }
            }
        }
        return tem;
    }

    private void get1Min() throws IOException, HttpException {
        kdjMap.clear();
        macdMap.clear();
        JSONArray jsonArray = getData("1min");
        kdjMap = getKdjMap(jsonArray);
        macdMap = getMacdMap(jsonArray);
    }
}