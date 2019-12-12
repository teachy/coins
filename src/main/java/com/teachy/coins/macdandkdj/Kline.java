package com.teachy.coins.macdandkdj;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author 
 */
@Component
public class Kline implements Serializable {
    private Integer id;

    /**
     * 网站类型
     */
    private String type;

    /**
     * 15分钟k线
     */
    private String time15;

    /**
     * 15分钟k线校验结果
     */
    private String boolean15;

    /**
     * 30分钟k线
     */
    private String time30;

    /**
     * 30分钟k线校验结果
     */
    private String boolean30;

    /**
     * 60分钟k线
     */
    private String time60;

    /**
     * 60分钟k线校验结果
     */
    private String boolean60;

    /**
     * 120分钟k线
     */
    private String time120;

    /**
     * 120分钟k线校验结果
     */
    private String boolean120;

    /**
     * 240分钟k线
     */
    private String time240;

    /**
     * 240分钟k线校验结果
     */
    private String boolean240;

    /**
     * 480分钟k线
     */
    private String time480;

    /**
     * 480分钟k线校验结果
     */
    private String boolean480;

    /**
     * 选择某个时间K线为标准标记最终结果
     */
    private String booleanres;

    /**
     * 投注比例
     */
    private Double scale;

    /**
     * 创建时间
     */
    private String createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime15() {
        return time15;
    }

    public void setTime15(String time15) {
        this.time15 = time15;
    }

    public String getBoolean15() {
        return boolean15;
    }

    public void setBoolean15(String boolean15) {
        this.boolean15 = boolean15;
    }

    public String getTime30() {
        return time30;
    }

    public void setTime30(String time30) {
        this.time30 = time30;
    }

    public String getBoolean30() {
        return boolean30;
    }

    public void setBoolean30(String boolean30) {
        this.boolean30 = boolean30;
    }

    public String getTime60() {
        return time60;
    }

    public void setTime60(String time60) {
        this.time60 = time60;
    }

    public String getBoolean60() {
        return boolean60;
    }

    public void setBoolean60(String boolean60) {
        this.boolean60 = boolean60;
    }

    public String getTime120() {
        return time120;
    }

    public void setTime120(String time120) {
        this.time120 = time120;
    }

    public String getBoolean120() {
        return boolean120;
    }

    public void setBoolean120(String boolean120) {
        this.boolean120 = boolean120;
    }

    public String getTime240() {
        return time240;
    }

    public void setTime240(String time240) {
        this.time240 = time240;
    }

    public String getBoolean240() {
        return boolean240;
    }

    public void setBoolean240(String boolean240) {
        this.boolean240 = boolean240;
    }

    public String getTime480() {
        return time480;
    }

    public void setTime480(String time480) {
        this.time480 = time480;
    }

    public String getBoolean480() {
        return boolean480;
    }

    public void setBoolean480(String boolean480) {
        this.boolean480 = boolean480;
    }

    public String getBooleanres() {
        return booleanres;
    }

    public void setBooleanres(String booleanres) {
        this.booleanres = booleanres;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}