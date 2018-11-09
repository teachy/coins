package com.teachy.coins.dd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.utils.StringUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	static double[] jg = {0.001, 0.003, 0.006, 0.01, 0.015, 0.021, 0.028,
		0.036, 0.045, 0.055, 0.063, 0.069, 0.073, 0.075};
	static int[] bet = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75,
		75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
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
	private int MAX = 8;
	private int beeting = 10000;

	@Async
	@Scheduled(cron = "59 0/1 * * * ?")
	public void tzForFK() {
		try {
			if (!yesterdayFK.equals(getYesterday())) {
				yesterdayFK = getYesterday();
				jgListforFK.clear();
				String url = "https://www.yuce28.com/action/Handler.ashx?cmd=getdatac&t=29&c=100&d=" + yesterdayFK
					+ "&_=" + System.currentTimeMillis();
				jgListforFK = getList(url);
				logger.info("tzForFK:" + yesterdayFK + ":" + jgListforFK);
			}
			if (Times.getCheckTime()) {
				DD dd = get28(kfget);
				if (Integer.parseInt(dd.getJcTime()) > 10) {
					if (jgListforFK.size() > 4) {
						int sleepTime = (int)(Math.random() * Integer.parseInt(dd.getJcTime()));
						Thread.sleep(sleepTime * 1000);
						if (jgListforFK.contains(dd.jieguo)) {
							bsFK = 1;
						} else {
							if (bsFK < MAX) {
								bsFK++;
							}
						}
						tz28(dd, beeting * bsFK, postFK, jgListforFK);
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
			if (!yesterdayJS.equals(getYesterday())) {
				yesterdayJS = getYesterday();
				jgListforJS.clear();
				String url = "https://www.yuce28.com/action/Handler.ashx?cmd=getdatac&t=155&c=100&d=" + yesterdayJS
					+ "&_=" + System.currentTimeMillis();
				jgListforJS = getList(url);
				logger.info("tzForJS:" + yesterdayJS + ":" + jgListforJS);
			}
			if (Times.getCheckTime()) {
				DD dd = get28(jsget);
				if (Integer.parseInt(dd.getJcTime()) > 10) {
					if (jgListforJS.size() > 4) {
						int sleepTime = (int)(Math.random() * Integer.parseInt(dd.getJcTime()));
						Thread.sleep(sleepTime * 1000);
						if (jgListforJS.contains(dd.jieguo)) {
							bsJS = 1;
						} else {
							if (bsJS < MAX) {
								bsJS++;
							}
						}
						tz28(dd, beeting * bsJS, postJS, jgListforJS);
						int sleep1 = (Integer.parseInt(dd.getKjTime()) - sleepTime);
						Thread.sleep(sleep1 * 1000);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public List<Integer> getList(String url) throws IOException {
		Map<Integer, Integer> evemap = new HashMap<>();
		List<Integer> evelist = new ArrayList<>();
		List<Integer> tz = new ArrayList<>();
		HttpGet get = new HttpGet(url);
		HttpResponse response = DDTasks.httpClient.execute(get);
		String res = DDTasks.getAllContent(response);
		JSONObject jsonObject = JSONObject.parseObject(res);
		if (jsonObject.containsKey("list")) {
			JSONArray jsonArray = jsonObject.getJSONArray("list");
			if (jsonArray != null) {
				if (jsonArray.size() < 900) {
					return tz;
				}
				for (int i1 = 0; i1 < jsonArray.size(); i1++) {
					JSONObject obj = jsonArray.getJSONObject(i1);
					evemap.put(obj.getInteger("id"), obj.getInteger("num"));
				}
			}
			evemap.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey())).forEachOrdered(
				e -> evelist.add(e.getValue()));
			int[] count = new int[28];
			evelist.stream().forEach(e -> count[e]++);
			for (int i = 0; i <= 27; i++) {
				double temd = ((double)count[i] / evelist.size()) / jg[i > 13 ? 27 - i : i];
				BigDecimal b = new BigDecimal(temd);
				temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
				if (temd < 0.95) {
					if (i > 2 && i < 25) {
						tz.add(i);
					}
				}
			}
		}
		return tz;
	}

	private String getYesterday() {
		DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate btime = LocalDate.now();
		return btime.plusDays(-1).format(ftf);
	}

	private void tz28(DD dd, int betting, HttpPost post, List<Integer> list) throws IOException {
		int sum = 0;
		StringBuffer bet_num = new StringBuffer();
		List<BasicNameValuePair> formParams1 = new ArrayList<>();
		for (int ii = 0; ii < list.size(); ii++) {
			sum += bet[((Integer)list.get(ii)).intValue()];
		}
		int[] betting1 = new int[28];
		int fenshu = betting / sum;
		for (int i = 0; i <= 27; i++) {
			betting1[i] = (bet[i] * fenshu);
			if (list.contains(Integer.valueOf(i))) {
				bet_num.append(betting1[i]).append(",");
			} else {
				bet_num.append(0).append(",");
			}
		}
		bet_num.replace(bet_num.length() - 1, bet_num.length(), "");
		int sum1 = 0;
		for (int i = 0; i <= 27; i++) {
			sum1 += betting1[i];
		}
		formParams1.add(new BasicNameValuePair("total", sum1 + ""));
		formParams1.add(new BasicNameValuePair("bet_num", bet_num
			.toString()));
		formParams1.add(new BasicNameValuePair("period_no", dd.getTemQH() + ""));
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(
			8000).setConnectionRequestTimeout(8000).setSocketTimeout(8000)
			.build();
		post.setConfig(requestConfig);
		post.setEntity(new UrlEncodedFormEntity(formParams1, "UTF-8"));
		HttpResponse response = DDTasks.httpClient.execute(post);
		response.getEntity().getContent().close();
	}

	private DD get28(HttpGet get) throws IOException, InterruptedException {
		DD dd = new DD();
		String jcTime = null;
		String kjTime = null;
		String qihao = null;
		String currentNumber = null;
		int tryTime = 0;
		while (jcTime == null || jcTime.length() <= 0) {
			tryTime++;
			if (tryTime >= 3) {
				break;
			}
			HttpResponse response = DDTasks.httpClient.execute(get);
			String htmlPage = DDTasks.getAllContent(response);
			jcTime = StringUtils.getRegexStr(htmlPage,
				"J_jcTime\" data-lasttime=\"(\\d+)");
			kjTime = StringUtils.getRegexStr(htmlPage,
				"J_kjTime\" data-lasttime=\"(\\d+)");
			qihao = StringUtils.getRegexStr(htmlPage, "距离第 <b>(\\d+)");
			currentNumber = StringUtils.getRegexStr(htmlPage,
				"<span class=\"now-jieguo\">(\\d+)");
			if (jcTime == null || jcTime.length() <= 0) {
				Thread.sleep(5000);
			}
		}
		long temQH = Long.valueOf(qihao);
		int jieguo = Integer.parseInt(currentNumber);
		dd.setJcTime(jcTime);
		dd.setKjTime(kjTime);
		dd.setTemQH(temQH);
		dd.setJieguo(jieguo);
		return dd;
	}

}
