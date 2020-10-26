package com.teachy.coins.bibixcom.utils;

import com.teachy.coins.bibixcom.enums.TransferSpotTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class V2ParamsUtils
{
    public static Map<String, Object> createAssetsTransferSpotCmd(String symbol, double amount, TransferSpotTypeEnum type)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", symbol);
        params.put("amount", amount);
        params.put("type", type.getFlag());
        return params;
    }
}
