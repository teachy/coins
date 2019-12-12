package com.teachy.coins.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName KDJ
 * @Description
 * @Date 2019/12/3 10:37
 */
public class KDJ {
    public static Map<String, Double> getKDJ(int n, int m1, int m2, ChartDataBean mChartData) {
        double[] mK = new double[mChartData.close.length];  //K值
        double[] mD = new double[mChartData.close.length];  //D值
        double jValue;                                      //J值
        double highValue = mChartData.high[0];
        double lowValue = mChartData.low[0];
        int highPosition = 0;           //记录最高价的位置
        int lowPosition = 0;        //记录最低价位置
        double rSV = 0.0;
        double K = 0;
        double D = 0;
        double J = 0;
        for (int i = 0; i < mChartData.close.length - 1; i++) {
            if (i == 0) {
                mK[0] = 50.0f;
                mD[0] = 50.0f;
                jValue = 50.0f;
            } else {
                //对最高价和最低价赋值
                if (highValue <= mChartData.high[i]) {
                    highValue = mChartData.high[i];
                    highPosition = i;
                }
                if (lowValue >= mChartData.low[i]) {
                    lowValue = mChartData.low[i];
                    lowPosition = i;
                }
                if (i > (n - 1)) {
                    //判断存储的最高价是否高于当前最高价
                    if (highValue > mChartData.high[i]) {
                        //判断最高价是不是在最近n天内，若不在最近n天内，则从最近n天找出最高价并赋值
                        if (highPosition < (i - (n - 1))) {
                            highValue = mChartData.high[i - (n - 1)];
                            for (int j = (i - (n - 2)); j <= i; j++) {
                                if (highValue <= mChartData.high[j]) {
                                    highValue = mChartData.high[j];
                                    highPosition = j;
                                }
                            }
                        }
                    }
                    if ((lowValue < mChartData.low[i])) {
                        if (lowPosition < i - (n - 1)) {
                            lowValue = mChartData.low[i - (n - 1)];
                            for (int k = i - (n - 2); k <= i; k++) {
                                if (lowValue >= mChartData.low[k]) {
                                    lowValue = mChartData.low[k];
                                    lowPosition = k;
                                }
                            }
                        }
                    }
                }
                if (highValue != lowValue) {
                    rSV = (mChartData.close[i] - lowValue) / (highValue - lowValue) * 100;
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

}