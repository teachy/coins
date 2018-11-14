package com.teachy.coins.dd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teachy.coins.utils.DateUtils;
@Component
@EnableAsync
public class TzTask2 {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static String yesterdayJS = "";
	private static String yesterdayFK = "";
	private static List<Integer> jgListforJS = new ArrayList<>();
	private static List<Integer> jgListforFK = new ArrayList<>();
	static HttpGet kfget = new HttpGet("http://www.game3799.com/Crazy28/index");
	static HttpGet jsget = new HttpGet("http://www.game3799.com/Speed28/index");
	static HttpPost postFK = new HttpPost("http://www.game3799.com/Crazy28/Bet");
	static HttpPost postJS = new HttpPost("http://www.game3799.com/Speed28/Bet");
	private int bsJS = 1;
	private int bsFK = 1;
	//FK 8:0.93
	//JS 13:0.91
	private int beeting = 18888;
	private double fkxs = 0.93;
	private double jsxs = 0.91;
	private int jsMax = 13;
	private int fkMax = 8;
	private long jsqh = 0;
	private long fkqh = 0;
	@Autowired
	private DDSprider dDSprider;
	@Autowired
	private SFTest sfTest;

	@Async
	@Scheduled(cron = "1 0/1 * * * ?")
	public void tzForFK() {
		try {
			if (!DDTasks.getIdAndGold().contains("null")) {
				fkff1();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Async
	@Scheduled(cron = "49 0/1 * * * ?")
	public void tzForJS() {
		try {
			if (!DDTasks.getIdAndGold().contains("null")) {
				jsff1();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Async
	@Scheduled(cron = "5 0/30 * * * ?")
	public void modifyCookie() {
		try {
			DDTasks.getIdAndGold();
		} catch (Exception e) {

		}
	}


	private void jsff1() throws IOException, InterruptedException {
		if (!yesterdayJS.equals(DateUtils.getYesterday()) || jgListforJS.size() < 2) {
			yesterdayJS = DateUtils.getYesterday();
			jgListforJS.clear();
			jgListforJS = dDSprider.getListbyDB("JS", jsxs);
			logger.info("tzForJS:" + yesterdayJS + ":" + jgListforJS);
		}

		DD dd = dDSprider.get28(jsget);
		if (dd.getTemQH() != jsqh) {
			jsqh = dd.getTemQH();
			Runnable runnable = () -> {
				sfTest.test(dd, "JS", jsxs, jsMax, jgListforJS);
			};
			Thread thread = new Thread(runnable);
			thread.start();
		}
		if (Integer.parseInt(dd.getJcTime()) > 10) {
			if (jgListforJS.size() > 2) {
				int sleepTime = (int)(Math.random() * Integer.parseInt(dd.getJcTime()));
				Thread.sleep(sleepTime * 1000);
				if (jgListforJS.contains(dd.jieguo)) {
					bsJS = 1;
				} else {
					if (bsJS < jsMax) {
						bsJS++;
					}
				}
				if (Times.getCheckTime()) {
					dDSprider.tz28(dd, beeting * bsJS, postJS, jgListforJS);
				}
				int sleep1 = (Integer.parseInt(dd.getKjTime()) - sleepTime);
				Thread.sleep(sleep1 * 1000);
			}
		}
	}

	private void fkff1() throws IOException, InterruptedException {
		if (!yesterdayFK.equals(DateUtils.getYesterday()) || jgListforFK.size() < 2) {
			yesterdayFK = DateUtils.getYesterday();
			jgListforFK.clear();
			jgListforFK = dDSprider.getListbyDB("FK", fkxs);
			logger.info("tzForFK:" + yesterdayFK + ":" + jgListforFK);
		}

		DD dd = dDSprider.get28(kfget);
		if (dd.getTemQH() != fkqh) {
			fkqh = dd.getTemQH();
			Runnable runnable = () -> {
				sfTest.test(dd, "FK", fkxs, fkMax, jgListforFK);
			};
			Thread thread = new Thread(runnable);
			thread.start();
		}
		if (Integer.parseInt(dd.getJcTime()) > 10) {
			if (jgListforFK.size() > 2) {
				int sleepTime = (int)(Math.random() * Integer.parseInt(dd.getJcTime()));
				Thread.sleep(sleepTime * 1000);
				if (jgListforFK.contains(dd.jieguo)) {
					bsFK = 1;
				} else {
					if (bsFK < fkMax) {
						bsFK++;
					}
				}
				if (Times.getCheckTime()) {
					dDSprider.tz28(dd, beeting * bsFK, postFK, jgListforFK);
				}
				int sleep1 = (Integer.parseInt(dd.getKjTime()) - sleepTime);
				Thread.sleep(sleep1 * 1000);
			}
		}
	}
}
