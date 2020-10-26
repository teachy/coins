package com.teachy.coins.bibixcom.vo;

import com.teachy.coins.bibixcom.enums.BorrowOrderStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowOrderGetParams
{
    //交易币种
    private String coinSymbol;
    //交易对
    private String pair;
    //订单状态
    private List<BorrowOrderStatusEnum> status = new ArrayList<>();
    private Integer page;
    private Integer size;

    public String getCoinSymbol()
    {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol)
    {
        this.coinSymbol = coinSymbol;
    }

    public String getPair()
    {
        return pair;
    }

    public void setPair(String pair)
    {
        this.pair = pair;
    }

    public List<Integer> flags()
    {
        return status.stream().map(BorrowOrderStatusEnum::getFlag).collect(Collectors.toList());
    }

    public boolean addStatus(BorrowOrderStatusEnum s)
    {
        return status.add(s);
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }
}
