/**
 * @Title: GateK.java
 * @Package com.tu.scheduletasks
 * @Description:
 * @author gang.tu
 * @date 2018年5月12日 上午9:38:21
 */
package com.teachy.coins.macdandkdj;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.huobi.common.api.HbdmRestApiV1;
import com.teachy.coins.huobi.common.api.IHbdmRestApi;
import com.teachy.coins.utils.IndicatrixUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.selector.Html;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName: GateK
 * @Description: gatek线指标采集计算
 * @date 2018年5月12日 上午9:38:21
 */
@Component
public class GateK {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CloseableHttpClient httpClient = HttpPoolUtil.getClient(HttpClientConstant.GATEK);
    IHbdmRestApi futureGetV1 = new HbdmRestApiV1("https://api.btcgateway.pro/");

    /**
     * @Title: checkGate
     * @Description: gateio获取k线数据
     */
    public int checkGate(int mins) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.info("获取gate：" + mins / 2 + "小时K线数据……");
        int group_sec = mins * 1800;
        int range_hour = (120 * mins) / 2;
        HttpGet httpGet = new HttpGet("http://data.gateio.io/api2/1/candlestick2/btc_usdt?group_sec=" + group_sec + "&range_hour=" + range_hour);
        Html html = ClientMethodUtils.getHtml(ClientMethodUtils.getContent(httpClient, httpGet), httpGet.getURI().toString());
        JSONObject obj = JSONObject.parseObject(html.xpath("//body//text()").get());
        JSONArray arr = obj.getJSONArray("data");
        double[] maxPrice = new double[arr.size()];
        double[] minPrice = new double[arr.size()];
        double[] closePrice = new double[arr.size()];
        for (int i = 0; i <= arr.size() - 1; i++) {
            List list = (List) arr.get(i);
            maxPrice[i] = Double.parseDouble(list.get(3).toString());
            minPrice[i] = Double.parseDouble(list.get(4).toString());
            closePrice[i] = Double.parseDouble(list.get(2).toString());
        }
//        boolean kdj = checkKDJ(maxPrice, minPrice, closePrice);
//        boolean macd = checkMACD(closePrice);
//        getBooleans(kdj, macd, mins);
        return 5;
    }

    /**
     * @return int 倍数
     * @throws
     * @Title: checkBig
     * @Description: gate服务器不稳定 冲大B网获取k线数据
     */
    public int checkBig() throws Exception {
        logger.info("获取bittrex的K线数据……");
        HttpGet httpGet = new HttpGet("https://www.bittrex.com/Api/v2.0/pub/market/GetTicks?marketName=USDT-BTC&tickInterval=oneMin");
        Html html = ClientMethodUtils.getHtml(ClientMethodUtils.getContent(httpClient, httpGet), httpGet.getURI().toString());
        JSONObject obj = JSONObject.parseObject(html.xpath("//body//text()").get());
        JSONArray arr = obj.getJSONArray("result");
        double[] maxPrice = new double[arr.size()];
        double[] minPrice = new double[arr.size()];
        double[] closePrice = new double[arr.size()];
        for (int i = 0; i <= arr.size() - 1; i++) {
            JSONObject json = arr.getJSONObject(i);
            maxPrice[i] = json.getDouble("H");
            minPrice[i] = json.getDouble("L");
            closePrice[i] = json.getDouble("C");
        }
        Boolean kdj = null;
        Boolean macd = null;

        Map<String, Double> kdjMap = checkKDJ(maxPrice, minPrice, closePrice);
        double k = kdjMap.get("K");
        double d = kdjMap.get("D");
        double j = kdjMap.get("J");
        //值之间距离
        if (((Math.abs(k - 50) > 10 || Math.abs(j - 50) > 10))) {
            if ((d < k && d < j) && (d < 35)) {
                kdj = true;
            }
            if ((d > k && d > j) && (d > 65)) {
                kdj = false;
            }
        }

        Map<String, Double> macdMap = IndicatrixUtils.getMACD(Collections.EMPTY_LIST,1,2,3);
        double diff = macdMap.get("DIFF");
        double dea = macdMap.get("DEA");

        if (diff > dea) {
            macd = true;
        } else {
            macd = false;
        }

        if (kdj == null || macd == null) {
            return 0;
        }
        if (kdj == true && macd == true) {
            logger.info("满足kdj(true)条件，K：" + k + "  D:" + d + " J:" + j);
            logger.info("满足MACD(true)DEA:" + dea + " DIFF:" + diff);
            return 1;
        } else if (kdj == false && macd == false) {
            logger.info("满足kdj(false)条件，K：" + k + "  D:" + d + " J:" + j);
            logger.info("满足MACD(false)DEA:" + dea + " DIFF:" + diff);
            return -1;
        } else {
            return 0;
        }
    }


    public int checkHuoBi() throws Exception {
        logger.info("获取checkHuoBi的K线数据……");
        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("https://www.bittrex.com/Api/v2.0/pub/market/GetTicks?marketName=USDT-BTC&tickInterval=oneMin");
//        Html html = ClientMethodUtils.getHtml(ClientMethodUtils.getContent(httpClient, httpGet), httpGet.getURI().toString());
//        JSONObject obj = JSONObject.parseObject(html.xpath("//body//text()").get());
        String res = futureGetV1.futureMarketHistoryKline("BTC_CW", "1min", "320");
        JSONObject obj = JSON.parseObject(res);
        JSONArray arr = obj.getJSONArray("data");
        double[] maxPrice = new double[arr.size()];
        double[] minPrice = new double[arr.size()];
        double[] closePrice = new double[arr.size()];
        for (int i = 0; i <= arr.size() - 1; i++) {
            JSONObject json = arr.getJSONObject(i);
            maxPrice[i] = json.getDouble("high");
            minPrice[i] = json.getDouble("low");
            closePrice[i] = json.getDouble("close");
        }
        Boolean kdj = null;
        Boolean macd = null;

        Map<String, Double> kdjMap = checkKDJ(maxPrice, minPrice, closePrice);
        double k = kdjMap.get("K");
        double d = kdjMap.get("D");
        double j = kdjMap.get("J");
        //值之间距离
        if (((Math.abs(k - 50) > 10 || Math.abs(j - 50) > 10))) {
            if ((d < k && d < j) && (j < 30)) {
                kdj = true;
            }
            if ((d > k && d > j) && (j > 60)) {
                kdj = false;
            }
        }

        Map<String, Double> macdMap = IndicatrixUtils.getMACD(Collections.EMPTY_LIST,1,2,3);
        double diff = macdMap.get("DIFF");
        double dea = macdMap.get("DEA");

        if (diff > dea) {
            macd = true;
        } else {
            macd = false;
        }
        if (kdj == null || macd == null) {
            return 0;
        }
        if (kdj == true && macd == true) {
            logger.info("满足kdj(true)条件，K：" + k + "  D:" + d + " J:" + j);
            logger.info("满足MACD(true)DEA:" + dea + " DIFF:" + diff);
            return 1;
        } else if (kdj == false && macd == false) {
            logger.info("满足kdj(false)条件，K：" + k + "  D:" + d + " J:" + j);
            logger.info("满足MACD(false)DEA:" + dea + " DIFF:" + diff);
            return -1;
        } else {
            return 0;
        }
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
