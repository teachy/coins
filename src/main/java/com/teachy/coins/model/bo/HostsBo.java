package com.teachy.coins.model.bo;

import lombok.Data;

/**
 * @author gang.tu
 * @ClassName HostsBo
 * @Description
 * @Date 2020/3/3 16:00
 */
@Data
public class HostsBo {
    private int id;
    private String ip;
    private String user="root";
    private String passwordMysql;
    private String passwordHost;
}