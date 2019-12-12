package com.teachy.coins.utils.klineutils.chart_data_utils.entity;


import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.BarEntry;
import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hugh.HYS
 * @date 2018/11/13
 */
public class MACDEntity implements ChartEntity {
    public List<BarEntry> bar;
    public List<Entry> diff;
    public List<Entry> dea;
    public String indexDes;

    public MACDEntity() {
        this.bar = new ArrayList<BarEntry>();
        this.diff = new ArrayList<>();
        this.dea = new ArrayList<>();
    }

    @Override
    public void clearValues() {
        if (bar != null) {
            bar.clear();
        }
        if (diff != null) {
            diff.clear();
        }
        if (dea != null) {
            dea.clear();
        }
    }
}
