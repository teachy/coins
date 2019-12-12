package com.teachy.coins.utils.klineutils.chart_data_utils;


import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.BarEntry;
import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.Candle;
import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.Entry;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.BollEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.CCIEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.DMIEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.EMAEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.EntryType;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.ICandle;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.KDJEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.MACDEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.OBVEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.RSIEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.VolEntity;
import com.teachy.coins.utils.klineutils.chart_data_utils.entity.WREntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex on 2018/11/12.
 * 只负责计算指标 可选周期
 */
public class ChartDataCalculateUtils {


    private List<Candle> originData;

    public ChartDataCalculateUtils(List<Candle> originData) {
        this.originData = originData;
    }


    public List<Entry> getSARLineDatas(float step, float maxStep, int period, int index) {

        List<ICandle> iCandles = changeCandleToICandle(originData);
        NewSarUtils.prepareDataForSARFromIndex(step, maxStep, period, index, iCandles);


        List<Entry> sars = new ArrayList<>();
        for (int i = 0; i < iCandles.size(); i++) {
            float sar = iCandles.get(i).sar;
            sars.add(new Entry(i, sar, originData.get(i)));
        }

        return sars;

    }


    /**
     * @param T boll T 一般默认为20
     * @param K boll K 一般默认为2
     * @return
     */
    public BollEntity getBollData(int T, int K) {

        if (originData == null || originData.size() == 0) {
            return null;
        }

        if (T < 1 || K < 1) {
            return null;
        }
        if (originData == null || originData.isEmpty()) {
            return null;
        }
        if (T > originData.size()) {
            return null;
        }
        //存储上轨数据
        ArrayList<Entry> zhongList = new ArrayList();
        //存储中轨数据
        ArrayList<Entry> shangList = new ArrayList();
        //存储下轨数据
        ArrayList<Entry> xiaList = new ArrayList();

        //上轨
        Entry shangEntity;
        //中轨
        Entry zhongEntity;
        //下轨
        Entry xiaEntity;

        double standtard = 0;
        double squarSum = 0;

        int cycle = T;

        List<Double> sma = countMA(T);
        if (sma == null || sma.size() == 0) {
            return null;
        }
        for (int i = cycle - 1; i < originData.size(); i++) {
            Candle candle = originData.get(i);
            double smaValue = sma.get(i - T + 1).doubleValue();

            standtard = 0;

            for (int j = i - T + 1; j <= i; j++) {
                standtard += (originData.get(j).Close - smaValue)
                        * (originData.get(j).Close - smaValue);
            }
            squarSum = Math.sqrt(standtard / T);

            zhongEntity = new Entry();
            zhongEntity.setX(i);
            zhongEntity.setY((float) smaValue);
            zhongEntity.setData(candle);

            shangEntity = new Entry();
            shangEntity.setX(i);
            shangEntity.setY((float) (smaValue + squarSum * K));
            shangEntity.setData(candle);

            xiaEntity = new Entry();
            xiaEntity.setX(i);
            xiaEntity.setY((float) (smaValue - squarSum * K));
            xiaEntity.setData(candle);

            zhongList.add(zhongEntity);
            xiaList.add(xiaEntity);
            shangList.add(shangEntity);
        }

        return new BollEntity(shangList, zhongList, xiaList);

    }


    /**
     * 抽取原始double 其他指数也需要用
     *
     * @param days 周期
     * @return 集合数据  MA=N日内的收盘价之和÷N
     */
    public List<Double> countMA(int days) {
        if (days < 1) {
            return null;
        }
        if (originData == null || originData.size() == 0) {
            return null;
        }
        int cycle = days;

        if (cycle > originData.size()) {
            //设置的指标参数大于数据集合 不用计算
            return null;
        }

        double sum = 0;

        List<Double> ma5Values = new ArrayList();

        for (int i = cycle - 1; i < originData.size(); i++) {
            if (i == cycle - 1) {
                for (int j = i - days + 1; j <= i; j++) {
                    sum += originData.get(j).Close;
                }
            } else {
                sum = sum + originData.get(i).Close - originData.get(i - days).Close;
            }
            ma5Values.add(sum / days);
        }
        return ma5Values;
    }


    /**
     * @param Tn default 6
     * @return
     */
    public List<Entry> getWR(int Tn, int index) {
        if (originData == null || originData.size() == 0) {
            return null;
        }

        List<Entry> wrList = new ArrayList<>();

        if (originData.size() > 0) {
            for (int j = index; j < originData.size(); j++) {

                List<ICandle> iCandles = changeCandleToICandle(originData);
                ICandle candle = iCandles.get(j);
                WREntity.CandleParseWR(iCandles, j, Tn);

                float wr = (candle.max6 - candle.Close) / (candle.max6 - candle.min6) * 100;
                wrList.add(new Entry(j, wr, originData.get(j)));

            }

        }


        return wrList;
    }

    /**
     * @param p1 default 14
     * @param p2 default 6
     * @return 此处的DMIData 继承了Candle
     * DMI存在4条线
     */
    public DMIEntity getDMI(int p1, int p2, int index) {
        if (originData == null || originData.size() == 0) {
            return null;
        }
        List<ICandle> dmiDatas = changeCandleToICandle(originData);


        if (index >= dmiDatas.size() - 1) {
            index = dmiDatas.size() - 1;
        }
        if (dmiDatas.size() >= 1) {
            for (int j = index; j < dmiDatas.size(); j++) {
                DMIEntity.ParseByP1(dmiDatas, j, p1);
                DMIEntity.ParseByP2(dmiDatas, j, p1, p2);
            }
        }

        //存储dm_minus数据
        List<Entry> pdiList = new ArrayList<>();
        //dm_plus
        List<Entry> mdiList = new ArrayList<>();
        //adx
        List<Entry> adxList = new ArrayList<>();
        //adxr
        List<Entry> adxrList = new ArrayList<>();
        for (int i = 0; i < dmiDatas.size(); i++) {
            ICandle dmi = dmiDatas.get(i);
            pdiList.add(new Entry(i, dmi.di_plus14, dmi));
            mdiList.add(new Entry(i, dmi.di_minus14, dmi));
            adxList.add(new Entry(i, dmi.adx, dmi));
            adxrList.add(new Entry(i, dmi.adxr, dmi));
        }

        DMIEntity dmiData = new DMIEntity(pdiList, mdiList, adxList, adxrList);
        return dmiData;
    }

    public CCIEntity getCCI(int index, int Tn) {

        if (originData == null || originData.size() == 0) {
            return null;
        }

        List<ICandle> iCandles = changeCandleToICandle(originData);

        List<Entry> cci = new ArrayList<>();
        List<Entry> tp = new ArrayList<>();
        List<Entry> mtp = new ArrayList<>();
        List<Entry> md = new ArrayList<>();

        if (index >= iCandles.size() - 1) {
            index = iCandles.size() - 1;
        }
        if (iCandles.size() > 0) {
            for (int j = index; j < iCandles.size(); j++) {
                CCIEntity.CandleParseCCI(iCandles, j, Tn);
            }
        }

        for (int i = 0; i < iCandles.size(); i++) {
            ICandle candle = iCandles.get(i);
            cci.add(new Entry(i, candle.cci, candle));
        }
        return new CCIEntity(cci, tp, mtp, md);
    }

    public OBVEntity getOBV(int index, int TnOBV) {

        if (originData == null || originData.size() == 0) {
            return null;
        }

        List<ICandle> iCandles = changeCandleToICandle(originData);

        List<Entry> obvList = new ArrayList<>();
        List<Entry> obv30List = new ArrayList<>();

        if (index >= iCandles.size() - 1) {
            index = iCandles.size() - 1;
        }
        if (iCandles.size() > 0) {
            for (int j = index; j < iCandles.size(); j++) {
                OBVEntity.CandleParseObV(iCandles, j, TnOBV);
            }
        }

//均线
        for (int i = 0; i < iCandles.size(); i++) {
            ICandle candle = iCandles.get(i);
            obvList.add(new Entry(i, candle.obv, candle));
            obv30List.add(new Entry(i, candle.obv30ma, candle));
        }

        OBVEntity obvData = new OBVEntity(obvList, obv30List);
        return obvData;
    }

    public EMAEntity getEMA(List<Integer> periods) {

        if (originData == null || originData.size() == 0) {
            return null;
        }

        //周期选择


        List<EntryType> emaDataList = new ArrayList<>();

        for (int i = 0; i < periods.size(); i++) {
            List<ICandle> iCandles = changeCandleToICandle(originData);
            if (iCandles.size() > 0) {
                int period = periods.get(i).intValue();

//                if (period == Companion.getDefaultNullValue()) {
//                    emaDataList.add(new EntryType(true));
//                    continue;
//                }

                for (int j = 0; j < iCandles.size(); j++) {
                    EMAEntity.CandleParseToEMA(iCandles, j, period);
                }

                ArrayList emaList = new ArrayList();
                for (int k = 0; k < iCandles.size(); k++) {
                    ICandle candle = iCandles.get(k);
                    emaList.add(new Entry(k, candle.common, candle));
                }

                emaDataList.add(new EntryType(emaList, period + ""));

            }

        }


        EMAEntity emaEntity = new EMAEntity(emaDataList);
        return emaEntity;
    }


    /**
     * 只允许一起拷贝 不可单独拷贝
     *
     * @param originData
     * @return
     */
    private List<ICandle> changeCandleToICandle(List<Candle> originData) {
        List<ICandle> iCandles = new ArrayList<>();
        if (originData != null) {
            for (int i = 0; i < originData.size(); i++) {
                ICandle iCandle = new ICandle(originData.get(i), true);
                iCandles.add(iCandle);
            }
        }
        return iCandles;
    }

    public VolEntity getVol() {
        if (originData == null || originData.size() == 0) {
            return null;
        }
        VolEntity volEntity = new VolEntity();
        int flagPosition = 0;

        for (int i = 0; i < originData.size(); i++) {
            Candle candle = originData.get(i);
            BarEntry barEntry = new BarEntry((float) (i + flagPosition), candle.Volume, candle);
            volEntity.bars.add(barEntry);
        }
        return volEntity;
    }

    public MACDEntity getMACD(int quickLineIndex, int slowLineIndex, int moveLineIndex) {
        if (originData == null || originData.size() == 0) {
            return null;
        }
        int flagPosition = 0;
        MACDEntity macdEntity = new MACDEntity();
        macdEntity.clearValues();

        if (quickLineIndex <= 0) {
            quickLineIndex = 12;
        }
        if (slowLineIndex <= 0) {
            slowLineIndex = 26;
        }

        if (moveLineIndex <= 0) {
            moveLineIndex = 9;
        }

        //12 26 9
        float ema12 = 0f;
        float ema26 = 0f;
        float dif;
        float dea = 0f;
        float macd = 0f;
        Entry entry;
        BarEntry barEntry;
        for (int i = 0; i < originData.size(); i++) {
            Candle candle = originData.get(i);
            if (i == 0) {
                ema12 = candle.Close;
                ema26 = candle.Close;
            } else {
                // EMA（12） = 前一日EMA（12） X 11/13 + 今日收盘价 X 2/13
                ema12 = ema12 * (quickLineIndex - 1) / (quickLineIndex + 1) + candle.Close * 2f / (quickLineIndex + 1);
                // EMA（26） = 前一日EMA（26） X 25/27 + 今日收盘价 X 2/27
                ema26 = ema26 * (slowLineIndex - 1) / (slowLineIndex + 1) + candle.Close * 2f / (slowLineIndex + 1);
            }
            // DIF = EMA（12） - EMA（26） 。
            // 今日DEA = （前一日DEA X 8/10 + 今日DIF X 2/10）
            // 用（DIF-DEA）*2即为MACD柱状图。
            dif = ema12 - ema26;
            dea = dea * (moveLineIndex - 1) / (moveLineIndex + 1) + dif * 2f / (moveLineIndex + 1);
            macd = (dif - dea) * 2f;


            entry = new Entry(i, dif, candle);
            macdEntity.diff.add(entry);
            entry = new Entry(i, dea, candle);
            macdEntity.dea.add(entry);


            barEntry = new BarEntry(i, macd, candle);
            macdEntity.bar.add(barEntry);
        }

        return macdEntity;

    }


    public KDJEntity getKDJ(List<Integer> ps) {
        if (originData == null || originData.size() == 0) {
            return null;
        }
        KDJEntity kdjEntity = new KDJEntity();

        if (ps == null || ps.size() == 0) {
            return null;
        }
        int Tn = ps.get(0);
        int index = 0;


        for (int i = index; i < originData.size(); i++) {
            Candle candle = originData.get(i);
            if (index == 0) {
                candle.k = 50.0f;
                candle.d = 50.0f;

            } else {
                candle.rsv9 = p_rsv9WithEndIndex(index, Tn == 0 ? 9 : Tn);
                p_K_D_WithIndex(index);
            }
            candle.j = (float) ((3.0 * candle.k) - (2.0 * candle.d));

        }

        for (int i = 0; i < originData.size(); i++) {
            Candle candle = originData.get(i);

            kdjEntity.k.add(new Entry(i, originData.get(i).k, candle));
            kdjEntity.d.add(new Entry(i, originData.get(i).d, candle));
            kdjEntity.j.add(new Entry(i, originData.get(i).j, candle));
        }

        kdjEntity.indexDes = "KDJ($Tn,3,3)";
        return kdjEntity;
    }

    /**
     * 计算RSV
     *
     * @param endindex 结束的下标
     * @return 计算后的RSV9
     */
    Float p_rsv9WithEndIndex(int endindex, int Tn) {
        float result = 0.0f;
        float low9 = Float.POSITIVE_INFINITY;
        float high9 = -Float.POSITIVE_INFINITY;
        float close = 0.0f;
        float startIndex = endindex - (Tn - 1);
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = 100; i > startIndex; i--) {
            Candle tempModel = originData.get(i);

            if (tempModel.Low < low9) {
                low9 = tempModel.Low;
            }

            if (tempModel.High > high9) {
                high9 = tempModel.High;

            }

            if (i == endindex) {
                close = tempModel.Close;
            }
        }
        result = (float) ((close - low9) / (high9 - low9) * 100.0);
        if (Float.isNaN(result)) {
            return 0.0f;
        } else {
            return result;
        }

    }

    /**
     * 计算K值和D值
     */

    void p_K_D_WithIndex(int a) {
        Candle tempModel = originData.get(a);
        Candle lastModel = originData.get(a - 1);
        tempModel.k = (float) (((2.0 * lastModel.k) + tempModel.rsv9) / 3.0);
        tempModel.d = (float) (((2.0 * lastModel.d) + tempModel.k) / 3.0);
    }

    public Object getRSI(List<Integer> ps) {

        if (originData == null || originData.size() == 0 || ps == null || ps.size() == 0) {
            return null;
        }

        RSIEntity rsiEntity = new RSIEntity();


        for (int index = 0; index < ps.size(); index++) {
            int rsiIndex = ps.get(index);

//            if (rsiIndex == IndexSettingDetailActivity.defaultNullValue) {
//                rsiEntity.rsiDataList.add(EntryType(true))
//                continue
//            }

            int flagPosition = 0;
            float lastSMAMax6 = 0f;
            float lastSMAAbs6 = 0f;

            float lastPrice = 0f;
            float rsi = 0f;
            Entry rsiEntry;
            boolean first = true;

            ArrayList<Entry> rsiList = new ArrayList();

            for (int i = 0; i < originData.size(); i++) {
                Candle candle = originData.get(i);
                if (!first) {
                    float priceDiffer = candle.Close - lastPrice;
                    if (priceDiffer < 0) {
                        lastSMAMax6 = (rsiIndex - 1) * lastSMAMax6 / rsiIndex;
                        lastSMAAbs6 = (Math.abs(priceDiffer) + (rsiIndex - 1) * lastSMAAbs6) / rsiIndex;
                    } else {
                        lastSMAMax6 = (priceDiffer + (rsiIndex - 1) * lastSMAMax6) / rsiIndex;
                        lastSMAAbs6 = (priceDiffer + (rsiIndex - 1) * lastSMAAbs6) / rsiIndex;
                    }
                }
                if (first || lastSMAAbs6 == 0f) {
                    rsiEntry = new Entry(i, 0f, candle);
                } else {
                    rsi = lastSMAMax6 / lastSMAAbs6 * 100.0f;
                    rsiEntry = new Entry(i, rsi, candle);
                }

                rsiList.add(rsiEntry);


                lastPrice = candle.Close;
                first = false;
            }
            rsiEntity.rsiDataList.add(new EntryType(rsiList, String.valueOf(rsiIndex)));
        }


        return rsiEntity.rsiDataList;
    }
}
