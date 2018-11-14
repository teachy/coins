package com.teachy.coins.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.teachy.coins.model.BaseCoins;
import com.teachy.coins.model.Dd3799D;

@Mapper
public interface Dd3799DDAO {

	int insert(Dd3799D dd3799D);

	List<Integer> getList(String type);

	List<Integer> getListByDay(String type);

	List<Integer> getListByDays(Map<String, Object> map);

}