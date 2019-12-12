package com.teachy.coins.tasks.huobi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.huobi.common.api.HbdmRestApiV1;
import com.teachy.coins.huobi.common.api.IHbdmRestApi;
import com.teachy.coins.utils.klineutils.KLineUtils;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName HuobiBase
 * @Description
 * @Date 2019/12/4 17:41
 */
@Component
public class HuobiBase {
    @Value("${huobi.api.key}")
    protected String apiKey;
    @Value("${huobi.secret.key}")
    protected String secretKey;
    @Value("${huobi.url.prex}")
    protected String urlPrex;
    @Value("${huobi.kline.size}")
    protected String klineSize;
    @Value("${huobi.lever.Rate}")
    protected String leverRate;
    @Value("${huobi.volume}")
    protected String volume;
    protected IHbdmRestApi futureGetV1;
    protected IHbdmRestApi futurePostV1;

    @PostConstruct
    void init() {
        futureGetV1 = new HbdmRestApiV1(urlPrex);
        futurePostV1 = new HbdmRestApiV1(urlPrex, apiKey, secretKey);
    }

    protected JSONArray getData(String period) throws IOException, HttpException {
        return getData(period, klineSize);
    }

    protected JSONArray getData(String period, String klineSize) throws IOException, HttpException {
        String res = futureGetV1.futureMarketHistoryKline("BTC_CQ", period, klineSize);
        JSONObject obj = JSON.parseObject(res);
        JSONArray arr = obj.getJSONArray("data");
        return arr;
    }

    protected Map<String, Double> getMacdMap(JSONArray arr) {
        double[] maxPrice = new double[arr.size()];
        double[] minPrice = new double[arr.size()];
        double[] closePrice = new double[arr.size()];
        List<Double> closeList = new ArrayList<>();
        for (int i = 0; i <= arr.size() - 1; i++) {
            maxPrice[i] = arr.getJSONObject(i).getDouble("high");
            minPrice[i] = arr.getJSONObject(i).getDouble("low");
            closePrice[i] = arr.getJSONObject(i).getDouble("close");
            closeList.add(arr.getJSONObject(i).getDouble("close"));
        }
        return KLineUtils.getMACD(closeList, 12, 26, 9);
    }

    protected Map<String, Double> getKdjMap(JSONArray arr) {
        double[] maxPrice = new double[arr.size()];
        double[] minPrice = new double[arr.size()];
        double[] closePrice = new double[arr.size()];
        for (int i = 0; i <= arr.size() - 1; i++) {
            maxPrice[i] = arr.getJSONObject(i).getDouble("high");
            minPrice[i] = arr.getJSONObject(i).getDouble("low");
            closePrice[i] = arr.getJSONObject(i).getDouble("close");
        }
        return KLineUtils.getKDJ(14, 1, 3, maxPrice, minPrice, closePrice);
    }

    protected String doss(String buyOrSell, String openOrClose, String contractCode, String price) throws IOException, HttpException {
        return futurePostV1.futureContractOrder("BTC", "quarter", contractCode, "", price, volume,
                buyOrSell, openOrClose, leverRate, "opponent");
    }

    protected String getPrice() throws IOException, HttpException {
        return JSON.parseObject(futureGetV1.futureContractIndex("BTC")).getJSONArray("data").getJSONObject(0).getString("index_price");
    }

    protected String getContractCode() throws IOException, HttpException {
        return JSON.parseObject(futureGetV1.futureContractInfo("BTC", "quarter", "")).getJSONArray("data").getJSONObject(0).getString("contract_code");
    }

    protected Double getLastPrice() throws IOException, HttpException {
        return JSON.parseObject(futurePostV1.futureMarketHistoryTrade("BTC_CQ", "1")).getJSONArray("data").getJSONObject(0).getJSONArray("data").getJSONObject(0).getDouble("price");
    }

}