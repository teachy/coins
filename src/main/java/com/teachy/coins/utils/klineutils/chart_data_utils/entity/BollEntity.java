package com.teachy.coins.utils.klineutils.chart_data_utils.entity;


import com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex on 2018/11/13.
 */
public class BollEntity implements ChartEntity {
    //存储上轨数据
    public List<Entry> upList;
    //存储中轨数据
    public List<Entry> midList;
    //存储下轨数据
    public List<Entry> downList;

    public String indexDes;

    public BollEntity(List<Entry> upList, List<Entry> midList, List<Entry> downList) {
        this.upList = upList;
        this.midList = midList;
        this.downList = downList;
    }

    public BollEntity() {
        this.upList = new ArrayList<>();
        this.midList = new ArrayList<>();
        this.downList = new ArrayList<>();
    }

    @Override
    public void clearValues() {
        if (upList != null) {
            upList.clear();
        }
        if (midList != null) {
            midList.clear();
        }
        if (downList != null) {
            downList.clear();
        }
    }
}
