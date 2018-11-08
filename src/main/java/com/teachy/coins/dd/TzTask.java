package com.teachy.coins.dd;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.utils.DateUtils;

@Component
public class TzTask {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	static double[] jg = {0.001, 0.003, 0.006, 0.01, 0.015, 0.021, 0.028,
		0.036, 0.045, 0.055, 0.063, 0.069, 0.073, 0.075};
	static int[] bet = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75,
		75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
	private static String yesterday = "";
	private static List<Integer> jgList = new ArrayList<>();
	@Scheduled(cron = "0/5 * * * * ?")
	public void tzForFK() throws IOException {
		if (!yesterday.equals(getYesterday())) {
			yesterday = getYesterday();
			jgList.clear();
			String url = "https://www.yuce28.com/action/Handler.ashx?cmd=getdatac&t=29&c=100&d=" + yesterday
				+ "&_=" + System.currentTimeMillis();
			jgList = getListforFK(url);
			logger.info("tzForFK:"+yesterday+":"+jgList);
		}
        if(jgList.size()>4){

		}
	}

	public void tzForJS() throws IOException {
		if (!yesterday.equals(getYesterday())) {
			yesterday = getYesterday();
			jgList.clear();
			String url = "https://www.yuce28.com/action/Handler.ashx?cmd=getdatac&t=155&c=100&d=" + yesterday
				+ "&_=" + System.currentTimeMillis();
			jgList = getListforFK(url);
			logger.info("tzForJS:"+yesterday+":"+jgList);
		}
		if(jgList.size()>4){

		}
	}

	public List<Integer> getListforFK(String url) throws IOException {
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
				if(jsonArray.size()<900){
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
}
