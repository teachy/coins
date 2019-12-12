package com.teachy.coins.utils.klineutils.chart_data_utils.entity;

import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class VolEntity implements ChartEntity {

    public List<BarEntry> bars;

    public VolEntity() {
        this.bars = new ArrayList<>();
    }

    @Override
    public void clearValues() {
        if (bars != null) {
            bars.clear();
        }
    }
}
