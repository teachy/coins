package com.teachy.coins.utils.klineutils.chart_data_utils.entity;

import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.Entry;

import java.util.ArrayList;

/**
 * @author Hugh.HYS
 * @date 2018/11/12
 */
public class RealTimeEntity implements ChartEntity {
    public ArrayList<Entry> price;
    public ArrayList<Entry> priceMa;

    public RealTimeEntity() {
        this.price = new ArrayList<>();
        this.priceMa = new ArrayList<>();
    }

    @Override
    public void clearValues() {
        if (price != null) {
            price.clear();
        }
        if (priceMa != null) {
            priceMa.clear();
        }
    }
}
