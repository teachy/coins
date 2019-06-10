package com.teachy.coins.model;

import com.teachy.coins.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseCoins {
    private int id;
    private String name;
    private String website;
    private int enable;
    private String updateTime;
    private int emailTime;

    public BaseCoins(String name, String website, int enable, int emailTime) {
        this.name = name;
        this.website = website;
        this.enable = enable;
        this.updateTime = DateUtils.convertTimeToString(System.currentTimeMillis());
        this.emailTime = emailTime;
    }
}
