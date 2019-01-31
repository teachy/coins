package com.teachy.coins.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teachy.coins.model.Warning;

/**
 * WarningDAO继承基类
 */
@Mapper
public interface WarningDAO {
	int insert(Warning warning);

	Warning selectWarning(Warning warning);

	void updateById(Warning warning);

	List<Warning> getWarningList();
}