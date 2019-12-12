package com.teachy.coins.utils;

import lombok.Data;

/**
 * @author gang.tu
 * @ClassName ChartDataBean
 * @Description
 * @Date 2019/12/3 10:46
 */
@Data
public class ChartDataBean {
    public double[] high;    //最高价
    public double[] low;    //最低价
    public double[] close;   //收盘价
}