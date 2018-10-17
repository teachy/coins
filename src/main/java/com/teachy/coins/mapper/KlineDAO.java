package com.teachy.coins.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teachy.coins.model.Kbase;

@Mapper
public interface KlineDAO {

	int insert(Kbase record);

	List<Kbase> getList(Kbase record);
}