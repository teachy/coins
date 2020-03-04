package com.teachy.coins.model.bo;

import lombok.Data;

@Data
public class CoinListBo {
    private String id;
    private String idTrade;
    private String type;
    private String action;
    private java.sql.Timestamp createTime;
    private String num;
    private String numDone;
    private double price;
    private double volume;
    private double volumeInit;
    private double fee;
    private double win;
    private String winPercent;
    private double winCount;
    private String winCountPercent;
    private String mark;
}
