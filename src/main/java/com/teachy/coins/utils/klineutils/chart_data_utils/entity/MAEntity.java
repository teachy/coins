package com.teachy.coins.utils.klineutils.chart_data_utils.entity;



import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex on 2018/11/14.
 */
public class MAEntity implements ChartEntity {

    public List<Entry> ma;


    public MAEntity(List<Entry> ma) {
        this.ma = ma;
    }

    public MAEntity() {
        this.ma = new ArrayList<>();
    }
    @Override
    public void clearValues() {
        if (ma != null) {
            ma.clear();
        }
    }


}
