package com.teachy.coins.model;

import com.teachy.coins.utils.DateUtils;
import com.teachy.coins.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kbase implements Serializable {
    private static final long serialVersionUID = 1L;

    public Kbase(long timeLong, Double volume, Double close, Double high, Double low, Double open, String website,
                 String type, String name) {
        this.id = "'" + StringUtils.getUUid() + "'";
        this.timeLong = timeLong;
        this.volume = volume;
        this.close = close;
        this.high = high;
        this.low = low;
        this.open = open;
        this.timeStr = "'" + DateUtils.convertTimeToString(timeLong) + "'";
        this.website = "'" + website + "'";
        this.type = "'" + type + "'";
        this.name = "'" + name + "'";
    }

    public Kbase(String website,
                 String type, String name, String tableName) {
        this.website = "'" + website + "'";
        this.type = "'" + type + "'";
        this.name = "'" + name + "'";
        this.tableName = tableName;
    }

    private String id;

    /**
     * 网站，比如币安,火币等
     */
    private String website;

    /**
     * 交易类型,比如：usdt_eth
     */
    private String type;

    /**
     * name
     */
    private String name;

    /**
     * 时间
     */
    private long timeLong;

    /**
     * 量
     */
    private Double volume;

    /**
     * 闭盘价
     */
    private Double close;

    /**
     * 开盘价
     */
    private Double open;

    /**
     * 最高价
     */
    private Double high;

    /**
     * 最低阶
     */
    private Double low;

    /**
     * 时间 非时间戳
     */
    private String timeStr;
    /**
     * 属于哪个表
     */
    private String tableName;

}
