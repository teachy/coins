package com.teachy.coins.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teachy.coins.mapper.BaseCoinsDAO;
import com.teachy.coins.mapper.KlineDAO;

@Component
public class BaseTask1 {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	protected KlineDAO klineDAO;
	@Autowired
	protected BaseCoinsDAO baseCoinsDAO;

	@Scheduled(cron = "0/10 * * * * ?")
	public void getKline1m() {
		baseCoinsDAO.getEnableCoins().stream().forEach(System.out::println);
	}
}
