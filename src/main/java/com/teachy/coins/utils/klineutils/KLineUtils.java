package com.teachy.coins.utils.klineutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName KLineUtils
 * @Description
 * @Date 2019/12/5 15:17
 */
public class KLineUtils {


    public static Map<String, Double> getKDJ(int n, int m1, int m2, double[] maxPrice, double[] minPrice, double[] closePrice) {
        double[] mK = new double[maxPrice.length];  //K值
        double[] mD = new double[maxPrice.length];  //D值
        double jValue;                                      //J值
        double highValue = maxPrice[0];
        double lowValue = minPrice[0];
        int highPosition = 0;           //记录最高价的位置
        int lowPosition = 0;        //记录最低价位置
        double rSV = 0.0;
        double K = 0;
        double D = 0;
        double J = 0;
        for (int i = 0; i < maxPrice.length; i++) {
            if (i == 0) {
                mK[0] = 50.0f;
                mD[0] = 50.0f;
                jValue = 50.0f;
            } else {
                //对最高价和最低价赋值
                if (highValue <= maxPrice[i]) {
                    highValue = maxPrice[i];
                    highPosition = i;
                }
                if (lowValue >= minPrice[i]) {
                    lowValue = minPrice[i];
                    lowPosition = i;
                }
                if (i > (n - 1)) {
                    //判断存储的最高价是否高于当前最高价
                    if (highValue > maxPrice[i]) {
                        //判断最高价是不是在最近n天内，若不在最近n天内，则从最近n天找出最高价并赋值
                        if (highPosition < (i - (n - 1))) {
                            highValue = maxPrice[i - (n - 1)];
                            for (int j = (i - (n - 2)); j <= i; j++) {
                                if (highValue <= maxPrice[j]) {
                                    highValue = maxPrice[j];
                                    highPosition = j;
                                }
                            }
                        }
                    }
                    if ((lowValue < minPrice[i])) {
                        if (lowPosition < i - (n - 1)) {
                            lowValue = minPrice[i - (n - 1)];
                            for (int k = i - (n - 2); k <= i; k++) {
                                if (lowValue >= minPrice[k]) {
                                    lowValue = minPrice[k];
                                    lowPosition = k;
                                }
                            }
                        }
                    }
                }
                if (highValue != lowValue) {
                    rSV = (closePrice[i] - lowValue) / (highValue - lowValue) * 100;
                }
                mK[i] = (mK[i - 1] * (m1 - 1) + rSV) / m1;
                mD[i] = (mD[i - 1] * (m2 - 1) + mK[i]) / m2;
                jValue = 3 * mK[i] - 2 * mD[i];
            }
            K = mK[i];
            D = mD[i];
            J = jValue;
        }
        Map<String, Double> map = new HashMap<>();
        map.put("K", K);
        map.put("D", D);
        map.put("J", J);
        return map;
    }

    public static HashMap<String, Double> getMACD(final List<Double> list, final int shortPeriod, final int longPeriod, int midPeriod) {
        HashMap<String, Double> macdData = new HashMap<String, Double>();
        List<Double> diffList = new ArrayList<Double>();
        Double shortEMA = 0.0;
        Double longEMA = 0.0;
        Double dif = 0.0;
        Double dea = 0.0;

        for (int i = list.size() - 1; i > 0; i--) {
            List<Double> sublist = list.subList(0, list.size() - i);
            shortEMA = getEXPMA(sublist, shortPeriod);
            longEMA = getEXPMA(sublist, longPeriod);
            dif = shortEMA - longEMA;
            diffList.add(dif);
        }
        dea = getEXPMA(diffList, midPeriod);
        macdData.put("DIFF", dif);
        macdData.put("DEA", dea);
        macdData.put("MACD", dif - dea);
        return macdData;
    }

    public static final Double getEXPMA(final List<Double> list, final int number) {
        // 开始计算EMA值，
        Double k = 2.0 / (number + 1.0);// 计算出序数
        Double ema = list.get(0);// 第一天ema等于当天收盘价
        for (int i = 1; i < list.size(); i++) {
            // 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
            ema = list.get(i) * k + ema * (1 - k);
        }
        return ema;
    }

}