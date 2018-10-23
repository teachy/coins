package com.teachy.coins.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teachy.coins.model.BaseCoins;
import com.teachy.coins.model.Kbase;

@Mapper
public interface BaseCoinsDAO {

	int insert(BaseCoins raseCoins);

	List<BaseCoins> getEnableCoins();

	List<BaseCoins> getDisableCoins();
}