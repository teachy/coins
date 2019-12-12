package com.teachy.coins.utils.klineutils.chart_data_utils.entity;

import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.Entry;

import java.util.List;

/**
 * Created by Rex on 2018/12/10.
 */
public class EntryType {
    public List<Entry> entries;
    public String name;
    public boolean isNull;//无效参数 用于判断非必填周期为空的情况

    public EntryType(List<Entry> entries, String name) {
        this.entries = entries;
        this.name = name;
    }

    public EntryType(boolean isNull) {
        this.isNull = isNull;
    }
}
