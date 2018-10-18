package com.teachy.coins.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teachy.coins.mapper.BaseCoinsDAO;
import com.teachy.coins.mapper.KlineDAO;
import com.teachy.coins.mapper.WarningDAO;

@Component
public class BaseTask {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	protected KlineDAO klineDAO;
	@Autowired
	protected BaseCoinsDAO baseCoinsDAO;
	@Autowired
	protected WarningDAO warningDAO;
}
