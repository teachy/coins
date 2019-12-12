package com.teachy.coins.utils.klineutils.chart_data_utils.chart_base_entity;

/**
 * Created by Rex on 2019/4/4.
 * 一般为你所使用的图标工具自带
 */
public class Entry {
    private float x;
    private float y;
    private Object obj;

    public Entry() {
    }

    public Entry(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Entry(float x, float y, Object obj) {
        this.x = x;
        this.y = y;
        this.obj = obj;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Object getData() {
        return obj;
    }

    public void setData(Object obj) {
        this.obj = obj;
    }
}
