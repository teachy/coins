package com.teachy.coins.utils.klineutils.chart_data_utils;


import com.teachy.coins.utils.klineutils.chart_data_utils.entity.ICandle;

import java.util.List;

/**
 * ICandleCreated by Rex on 2018/12/12.
 */
public class NewSarUtils {

    public static void prepareDataForSARFromIndex(float accFactor, float maxAccFactor, int period, int index, List<ICandle> ICandleArray) {
        if (ICandleArray == null || ICandleArray.size() == 0) {
            return;
        }

        if (period < 2 || ICandleArray.size() < period) {
            return;
        }

        if (index >= (ICandleArray.size() - 1)) {
            index = ICandleArray.size() - 1;
        }

        if (ICandleArray.size() >= 1) {
            for (int a = index; a < ICandleArray.size(); a++) {
                p_SARValueAtIndex(a, period, accFactor, maxAccFactor, ICandleArray);

            }
        }
    }

    private static void p_SARValueAtIndex(int atIndex, int period, float accFactor, float maxAccFactor, List<ICandle> dataCenter) {
        int num = period;
        float minAf = accFactor;
        float maxAf = maxAccFactor;
        ICandle tempModel = dataCenter.get(atIndex);
        if (atIndex == 0) {
            float af = minAf;
            ICandle firstModel = dataCenter.get(0);
            ICandle secondModel = dataCenter.get(1);
            if (secondModel.Close > firstModel.Close) {
                tempModel.sar = firstModel.Low;
                tempModel.ep = firstModel.High;
                tempModel.isUp = true;

            } else {
                tempModel.sar = firstModel.High;
                tempModel.ep = firstModel.Low;
                tempModel.isUp = false;

            }
            tempModel.af = af;
        } else if (tempModel.sar == 0) {
            ICandle lastModel = dataCenter.get(atIndex - 1);
            if (!(lastModel.sar != 0 && lastModel.af != 0)) {
                p_SARValueAtIndex(atIndex - 1, period, accFactor, maxAccFactor, dataCenter);
            }
            boolean statusConvert = false;
            //赋值流程：
            float sar = lastModel.sar + lastModel.af * (lastModel.ep - lastModel.sar);
            CGPoint finalSar = getFinalSarWithNum(num, sar, atIndex, lastModel.isUp, dataCenter);

            tempModel.af = lastModel.af;
            tempModel.ep = lastModel.ep;
            tempModel.isUp = lastModel.isUp;

            if (lastModel.isUp != finalSar.isUp) {
                tempModel.af = minAf;
                statusConvert = true;
            }
            tempModel.sar = finalSar.x;
            tempModel.isUp = finalSar.isUp;

            if (statusConvert) {
                if (tempModel.isUp) {
                    float high = 0;
                    int start = atIndex;
                    do {
                        ICandle tmpModel2 = dataCenter.get(start);
                        high = Math.max(tmpModel2.High, high);
                        start -= 1;

                    }
                    while (start >= Math.max(atIndex - num + 1, 0));
                    tempModel.ep = high;//preModel.high;
                } else {

                    float low = Float.POSITIVE_INFINITY;
                    int start = atIndex;
                    do {
                        ICandle tmpModel2 = dataCenter.get(start);
                        low = Math.min(tmpModel2.Low, low);
                        start -= 1;
                    }
                    while (start >= Math.max(atIndex - num + 1, 0));
                    tempModel.ep = low;//preModel.low;

                }

            }

        }

        if (atIndex >= 0) {
            //修正流程：
            if (tempModel.isUp) {
                if (tempModel.High > tempModel.ep) {
                    tempModel.af += minAf;
                }
            } else {

                if (tempModel.Low < tempModel.ep) {
                    tempModel.af += minAf;
                }

            }

            if (tempModel.isUp) {
                tempModel.ep = Math.max(tempModel.ep, tempModel.High);
            } else {
                tempModel.ep = Math.min(tempModel.ep, tempModel.Low);

            }

            if (tempModel.af > maxAf) {
                tempModel.af = maxAf;
            }
        }
    }


    private static CGPoint getFinalSarWithNum(int num, float sar, int index, boolean isUp, List<ICandle> dataCenter) {
        float finalSar = sar;
        boolean finalisUp = isUp;
        int start = index;
        ICandle tmpModel = dataCenter.get(index);

        if (isUp) {
            if (sar > tmpModel.Low) {
                do {
                    ICandle tmpModel2 = dataCenter.get(start);
                    finalSar = Math.max(tmpModel2.High, finalSar);
                    start -= 1;

                }
                while (start >= Math.max(index - num + 1, 0));
                finalisUp = false;
            }
        } else {
            if (sar < tmpModel.High) {
                do {
                    ICandle tmpModel2 = dataCenter.get(start);
                    finalSar = Math.min(tmpModel2.Low, finalSar);
                    start -= 1;

                }
                while (start >= Math.max(index - num + 1, 0));
                finalisUp = true;

            }

        }

        return CGPoint.Make(finalSar, finalisUp);
    }

    public static class CGPoint {
        public float x;
        public float y;
        public boolean isUp;

        public CGPoint(float x, boolean isUp) {
            this.isUp = isUp;
            this.x = x;
            this.y = isUp ? 1 : 0;
        }

        public static CGPoint Make(float finalSar, boolean finalisUp) {
            return new CGPoint(finalSar, finalisUp);
        }

    }


}
