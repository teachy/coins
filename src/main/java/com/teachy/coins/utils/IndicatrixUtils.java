
package com.teachy.coins.utils;
/**
 * @Title: E.java
 * @Package com.tu.utils
 * @Description:
 * @author gang.tu
 * @date 2018年5月12日 上午9:10:54
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gang.tu
 * @ClassName: E
 * @Description:
 * @date 2018年5月12日 上午9:10:54
 */
public class IndicatrixUtils {

    /**
     * 计算KDJ指标数据
     *
     * @param maxPrice--最高价要从第一天开始
     * @param minPrice--最低价要从第一天开始
     * @param closePrice--收盘价要从第一天开始
     * @param fastK_Period--标准值：9
     * @param slowK_Period--标准值：3
     * @param slowD_Period--标准值：3
     * @param K--顺序记录K指标             new double[]
     * @param D--顺序记录D指标             new double[]
     * @param J--顺序记录J指标             new double[]
     */
    public static void KDJ(double[] maxPrice, double[] minPrice, double[] closePrice, int fastK, int slowK, int slowD,
                           double[] K_R, double[] D_R, double[] J_R) {
        List<Double> highestPriceList = new ArrayList<>();
        List<Double> lowestPriceList = new ArrayList<>();

        List<Double> highestPriceList_temp = new ArrayList<>();
        List<Double> lowestPriceList_temp = new ArrayList<>();

        double RSV = 0;

        double fastK_Period = fastK;// 标准值为9
        double slowK_Period = Double.valueOf(new Integer(slowK));// 标准值为3
        double slowD_Period = Double.valueOf(new Integer(slowD));// 标准值为3

        double preK = 0;
        double preD = 0;

        double K = 0;
        double D = 0;
        double J = 0;
        for (int i = 0; i < closePrice.length; i++) {
            if (highestPriceList.size() == fastK_Period) {
                highestPriceList.remove(0);
                lowestPriceList.remove(0);
            } else if (highestPriceList.size() == 0) {
                highestPriceList.add(maxPrice[i]);
                lowestPriceList.add(minPrice[i]);
            }
            highestPriceList.add(maxPrice[i]);
            lowestPriceList.add(minPrice[i]);

            highestPriceList_temp = new ArrayList<>();
            lowestPriceList_temp = new ArrayList<>();

            highestPriceList_temp.addAll(highestPriceList);
            lowestPriceList_temp.addAll(lowestPriceList);

            highestPriceList_temp = MathCaclateUtil.sortList(highestPriceList_temp);
            lowestPriceList_temp = MathCaclateUtil.sortList(lowestPriceList_temp);

            RSV = (double) MathCaclateUtil.multiply(MathCaclateUtil.divide(
                    MathCaclateUtil.subtract(closePrice[i], lowestPriceList_temp.get(0), BigDecimal.ROUND_HALF_UP),
                    MathCaclateUtil.subtract(highestPriceList_temp.get(highestPriceList_temp.size() - 1),
                            lowestPriceList_temp.get(0), BigDecimal.ROUND_HALF_UP),
                    BigDecimal.ROUND_UNNECESSARY), 100D, BigDecimal.ROUND_HALF_UP);// （今日收盘价－9日内最低价）÷（9日内最高价－9日内最低价）×100

            // 如果无前一日的K、D值
            K = (double) MathCaclateUtil.divide(MathCaclateUtil.add(RSV,
                    MathCaclateUtil.multiply(2D, preK, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_HALF_UP),
                    slowK_Period, BigDecimal.ROUND_UNNECESSARY);// （当日RSV值+2×前一日K值）÷3

            D = (double) MathCaclateUtil.divide(MathCaclateUtil.add(K,
                    MathCaclateUtil.multiply(2D, preD, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_HALF_UP),
                    slowD_Period, BigDecimal.ROUND_UNNECESSARY);// （当日K值+2×前一日D值）÷3

            J = MathCaclateUtil.subtract(MathCaclateUtil.multiply(3D, K, BigDecimal.ROUND_HALF_UP),
                    MathCaclateUtil.multiply(2D, D, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_HALF_UP);// 3K－2D

            preK = K;
            preD = D;

            K_R[i] = K;
            D_R[i] = D;
            J_R[i] = J;
        }
    }

    /**
     * @return void  返回类型
     * @throws
     * @Title: KDJ
     * @Description: KDJ只获取最后的值
     */
    public static Map<String, Double> KDJ(double[] maxPrice, double[] minPrice, double[] closePrice) {
        List<Double> highestPriceList = new ArrayList<>();
        List<Double> lowestPriceList = new ArrayList<>();

        List<Double> highestPriceList_temp = new ArrayList<>();
        List<Double> lowestPriceList_temp = new ArrayList<>();

        double RSV = 0;

        double fastK_Period = 9;// 标准值为9
        double slowK_Period = Double.valueOf(new Integer(3));// 标准值为3
        double slowD_Period = Double.valueOf(new Integer(3));// 标准值为3

        double preK = 0;
        double preD = 0;

        double K = 0;
        double D = 0;
        double J = 0;
        for (int i = 0; i < closePrice.length - 1; i++) {
            if (highestPriceList.size() == fastK_Period) {
                highestPriceList.remove(0);
                lowestPriceList.remove(0);
            } else if (highestPriceList.size() == 0) {
                highestPriceList.add(maxPrice[i]);
                lowestPriceList.add(minPrice[i]);
            }
            highestPriceList.add(maxPrice[i]);
            lowestPriceList.add(minPrice[i]);

            highestPriceList_temp = new ArrayList<>();
            lowestPriceList_temp = new ArrayList<>();

            highestPriceList_temp.addAll(highestPriceList);
            lowestPriceList_temp.addAll(lowestPriceList);

            highestPriceList_temp = MathCaclateUtil.sortList(highestPriceList_temp);
            lowestPriceList_temp = MathCaclateUtil.sortList(lowestPriceList_temp);

            RSV = (double) MathCaclateUtil.multiply(MathCaclateUtil.divide(
                    MathCaclateUtil.subtract(closePrice[i], lowestPriceList_temp.get(0), BigDecimal.ROUND_HALF_UP),
                    MathCaclateUtil.subtract(highestPriceList_temp.get(highestPriceList_temp.size() - 1),
                            lowestPriceList_temp.get(0), BigDecimal.ROUND_HALF_UP),
                    BigDecimal.ROUND_UNNECESSARY), 100D, BigDecimal.ROUND_HALF_UP);// （今日收盘价－9日内最低价）÷（9日内最高价－9日内最低价）×100

            // 如果无前一日的K、D值
            K = (double) MathCaclateUtil.divide(MathCaclateUtil.add(RSV,
                    MathCaclateUtil.multiply(2D, preK, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_HALF_UP),
                    slowK_Period, BigDecimal.ROUND_UNNECESSARY);// （当日RSV值+2×前一日K值）÷3

            D = (double) MathCaclateUtil.divide(MathCaclateUtil.add(K,
                    MathCaclateUtil.multiply(2D, preD, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_HALF_UP),
                    slowD_Period, BigDecimal.ROUND_UNNECESSARY);// （当日K值+2×前一日D值）÷3

            J = MathCaclateUtil.subtract(MathCaclateUtil.multiply(3D, K, BigDecimal.ROUND_HALF_UP),
                    MathCaclateUtil.multiply(2D, D, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_HALF_UP);// 3K－2D
            preK = K;
            preD = D;
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

    /**
     * 计算RSI指标数据
     *
     * @param closePrice--收盘价要从第一天开始
     * @param rsi1_n--计算rsi1指标，标准为：6
     * @param rsi2_n--计算rsi2指标，标准为：12
     * @param rsi3_n--计算rsi3指标，标准为：24
     * @param rsi1--顺序记录rsi1指标        new double[]
     * @param rsi2--顺序记录rsi2指标        new double[]
     * @param rsi3--顺序记录rsi3指标        new double[]
     */
    public static void RSI(double[] closePrice, int rsi1_n, int rsi2_n, int rsi3_n, double[] rsi1, double[] rsi2,
                           double[] rsi3) {
        double pp_6;// 用于计算rsi数据
        double np_6;
        double pp_12;
        double np_12;
        double pp_24;
        double np_24;
        double prepp_6 = 0;// 用于计算rsi数据
        double prenp_6 = 0;
        double prepp_12 = 0;
        double prenp_12 = 0;
        double prepp_24 = 0;
        double prenp_24 = 0;

        double upsanddowns;
        double n1 = Double.valueOf(new Integer(rsi1_n));// 标准值为6
        double n2 = Double.valueOf(new Integer(rsi2_n));// 标准值为12
        double n3 = Double.valueOf(new Integer(rsi3_n));// 标准值为24
        double num_100 = 100D;

        double RSI1 = 0;
        double RSI2 = 0;
        double RSI3 = 0;
        for (int i = 0; i < closePrice.length; i++) {
            if (i == 0) {
                continue;
            }
            upsanddowns = closePrice[i] - closePrice[i - 1];

            pp_6 = MathCaclateUtil.add(
                    MathCaclateUtil.divide(MathCaclateUtil.multiply(prepp_6, n1 - 1, BigDecimal.ROUND_HALF_UP), n1,
                            BigDecimal.ROUND_UNNECESSARY),
                    MathCaclateUtil.divide(upsanddowns >= 0 ? upsanddowns : 0, n1, BigDecimal.ROUND_UNNECESSARY),
                    BigDecimal.ROUND_HALF_UP);// prepp_6*(6-1)/6+(upsanddowns>=0?upsanddowns:0)/6
            np_6 = MathCaclateUtil.add(
                    MathCaclateUtil.divide(MathCaclateUtil.multiply(prenp_6, n1 - 1, BigDecimal.ROUND_HALF_UP), n1,
                            BigDecimal.ROUND_UNNECESSARY),
                    MathCaclateUtil.divide(upsanddowns >= 0 ? 0 : upsanddowns, n1, BigDecimal.ROUND_UNNECESSARY),
                    BigDecimal.ROUND_HALF_UP);// prenp_6*(6-1)/6+(upsanddowns>=0?0:upsanddowns)/6
            RSI1 = (double) MathCaclateUtil.divide(MathCaclateUtil.multiply(num_100, pp_6, BigDecimal.ROUND_HALF_UP),
                    MathCaclateUtil.add(pp_6, -np_6, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_UNNECESSARY);// 100*pp_6/(pp_6-np_6)

            rsi1[i] = RSI1;
            prepp_6 = pp_6;
            prenp_6 = np_6;

            pp_12 = MathCaclateUtil.add(
                    MathCaclateUtil.divide(MathCaclateUtil.multiply(prepp_12, n2 - 1, BigDecimal.ROUND_HALF_UP), n2,
                            BigDecimal.ROUND_UNNECESSARY),
                    MathCaclateUtil.divide(upsanddowns >= 0 ? upsanddowns : 0, n2, BigDecimal.ROUND_UNNECESSARY),
                    BigDecimal.ROUND_HALF_UP);// prepp_12*(12-1)/12+(upsanddowns>=0?upsanddowns:0)/12;
            np_12 = MathCaclateUtil.add(
                    MathCaclateUtil.divide(MathCaclateUtil.multiply(prenp_12, n2 - 1, BigDecimal.ROUND_HALF_UP), n2,
                            BigDecimal.ROUND_UNNECESSARY),
                    MathCaclateUtil.divide(upsanddowns >= 0 ? 0 : upsanddowns, n2, BigDecimal.ROUND_UNNECESSARY),
                    BigDecimal.ROUND_HALF_UP);// prenp_12*(12-1)/12+(upsanddowns>=0?0:upsanddowns)/12;
            RSI2 = (double) MathCaclateUtil.divide(MathCaclateUtil.multiply(num_100, pp_12, BigDecimal.ROUND_HALF_UP),
                    MathCaclateUtil.add(pp_12, -np_12, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_UNNECESSARY);// 100*pp_12/(pp_12-np_12);

            rsi2[i] = RSI2;
            prepp_12 = pp_12;
            prenp_12 = np_12;

            pp_24 = MathCaclateUtil.add(
                    MathCaclateUtil.divide(MathCaclateUtil.multiply(prepp_24, n3 - 1, BigDecimal.ROUND_HALF_UP), n3,
                            BigDecimal.ROUND_UNNECESSARY),
                    MathCaclateUtil.divide(upsanddowns >= 0 ? upsanddowns : 0, n3, BigDecimal.ROUND_UNNECESSARY),
                    BigDecimal.ROUND_HALF_UP);// prepp_24*(24-1)/24+(upsanddowns>=0?upsanddowns:0)/24;
            np_24 = MathCaclateUtil.add(
                    MathCaclateUtil.divide(MathCaclateUtil.multiply(prenp_24, n3 - 1, BigDecimal.ROUND_HALF_UP), n3,
                            BigDecimal.ROUND_UNNECESSARY),
                    MathCaclateUtil.divide(upsanddowns >= 0 ? 0 : upsanddowns, n3, BigDecimal.ROUND_UNNECESSARY),
                    BigDecimal.ROUND_HALF_UP);// prenp_24*(24-1)/24+(upsanddowns>=0?0:upsanddowns)/24;
            RSI3 = (double) MathCaclateUtil.divide(MathCaclateUtil.multiply(num_100, pp_24, BigDecimal.ROUND_HALF_UP),
                    MathCaclateUtil.add(pp_24, -np_24, BigDecimal.ROUND_HALF_UP), BigDecimal.ROUND_UNNECESSARY);// 100*pp_24/(pp_24-np_24);

            rsi3[i] = RSI3;
            prepp_24 = pp_24;
            prenp_24 = np_24;
        }
    }
}