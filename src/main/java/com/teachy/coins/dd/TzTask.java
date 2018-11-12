package com.teachy.coins.dd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.mapper.Dd3799DDAO;
import com.teachy.coins.utils.DateUtils;
import com.teachy.coins.utils.StringUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@EnableAsync
public class TzTask {
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
	private int beeting = 18888;
	@Autowired
	private DDSprider dDSprider;
	@Async
	@Scheduled(cron = "1 0/1 * * * ?")
	public void tzForFK() {
		try {
			if (!DDTasks.getIdAndGold().contains("null")) {
				if (!yesterdayFK.equals(DateUtils.getYesterday()) || jgListforFK.size() < 2) {
					yesterdayFK = DateUtils.getYesterday();
					jgListforFK.clear();
					String url = "https://www.yuce28.com/action/Handler.ashx?cmd=getdatac&t=29&c=100&d=" + yesterdayFK
						+ "&_=" + System.currentTimeMillis();
					jgListforFK = dDSprider.getList(url, 0.95);
					logger.info("tzForFK:" + yesterdayFK + ":" + jgListforFK);
				}

				DD dd = dDSprider.get28(kfget);
				if (Integer.parseInt(dd.getJcTime()) > 10) {
					if (jgListforFK.size() > 2) {
						int sleepTime = (int)(Math.random() * Integer.parseInt(dd.getJcTime()));
						Thread.sleep(sleepTime * 1000);
						if (jgListforFK.contains(dd.jieguo)) {
							bsFK = 1;
						} else {
							if (bsFK < 13) {
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
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Async
	@Scheduled(cron = "49 0/1 * * * ?")
	public void tzForJS() {
		try {
			if (!DDTasks.getIdAndGold().contains("null")) {
				if (!yesterdayJS.equals(DateUtils.getYesterday()) || jgListforJS.size() < 2) {
					yesterdayJS = DateUtils.getYesterday();
					jgListforJS.clear();
					String url = "https://www.yuce28.com/action/Handler.ashx?cmd=getdatac&t=155&c=100&d=" + yesterdayJS
						+ "&_=" + System.currentTimeMillis();
					jgListforJS = dDSprider.getList(url, 0.94);
					logger.info("tzForJS:" + yesterdayJS + ":" + jgListforJS);
				}

				DD dd = dDSprider.get28(jsget);
				if (Integer.parseInt(dd.getJcTime()) > 10) {
					if (jgListforJS.size() > 2) {
						int sleepTime = (int)(Math.random() * Integer.parseInt(dd.getJcTime()));
						Thread.sleep(sleepTime * 1000);
						if (jgListforJS.contains(dd.jieguo)) {
							bsJS = 1;
						} else {
							if (bsJS < 18) {
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

}
