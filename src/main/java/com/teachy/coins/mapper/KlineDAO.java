package com.teachy.coins.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.teachy.coins.model.Kbase;

@Mapper
public interface KlineDAO {

	int insert(Kbase record);

}