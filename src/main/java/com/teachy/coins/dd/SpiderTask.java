package com.teachy.coins.dd;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.utils.DateUtils;

//@Component
public class SpiderTask {

	static double[] jg = {0.001, 0.003, 0.006, 0.01, 0.015, 0.021, 0.028,
		0.036, 0.045, 0.055, 0.063, 0.069, 0.073, 0.075};
	static int[] bet = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75,
		75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
	List<String> allres = new ArrayList<>();
	List<Integer> lastres = new ArrayList<>();
	int getCount = 0;
	double test = 0.80;
	int test1 = 0;

	@Scheduled(cron = "0/5 * * * * ?")
	public void getHistory() throws IOException {
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> evemap = new HashMap<>();
		List<Integer> evelist = new ArrayList<>();
		allres.clear();
		lastres.clear();
		test = test + 0.01;
		test1 = test1 + 1;
		for (int i = 0; i <= 27; i++) {
			allres.add("");
		}
		String time = "2018-10-26";
		for (int i = 0; i <= 14; i++) {
			evemap.clear();
			evelist.clear();
			HttpGet get = new HttpGet(
				"https://www.yuce28.com/action/Handler.ashx?cmd=getdatac&t=155&c=100&d=" + DateUtils.plusDay(i, time)
					+ "&_=" + System.currentTimeMillis());
			HttpResponse response = DDTasks.httpClient.execute(get);
			String res = DDTasks.getAllContent(response);
			JSONObject jsonObject = JSONObject.parseObject(res);
			if (jsonObject.containsKey("list")) {
				JSONArray jsonArray = jsonObject.getJSONArray("list");
				if (jsonArray != null) {
					for (int i1 = 0; i1 < jsonArray.size(); i1++) {
						JSONObject obj = jsonArray.getJSONObject(i1);
						map.put(obj.getInteger("id"), obj.getInteger("num"));
						evemap.put(obj.getInteger("id"), obj.getInteger("num"));
					}
				}
				List<Integer> list = new ArrayList<>();
				map.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey())).forEachOrdered(
					e -> list.add(e.getValue()));
				evemap.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey())).forEachOrdered(
					e -> evelist.add(e.getValue()));
				//			fx3(evelist);
				fx2(evelist);
			}
		}
		System.out.println("getCount:" + getCount + ":" + test);
		getCount = 0;
	}

	public void fx2(List<Integer> list) {
		if (lastres.size() == 0) {
			lastres.addAll(list);
		} else {
			int[] count = new int[28];
			lastres.stream().forEach(e -> count[e]++);
			int use = 0;
			int get = 0;
			int tem = 0;
			List<Integer> tz = new ArrayList<>();
			for (int i = 0; i <= 27; i++) {
				double temd = ((double)count[i] / lastres.size()) / jg[i > 13 ? 27 - i : i];
				BigDecimal b = new BigDecimal(temd);
				temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
				if (temd < 0.84) {
					if (i > 2 && i < 25) {
						tz.add(i);
						tem = tem + bet[i];
					}
				}
			}
			int bs = 1;
			int temcout=0;
			for (int kj : list) {
				use = use + tem * bs;
				if (tz.contains(kj)) {
					temcout= temcout-tem * bs+990 * bs;
					get = get + 990 * bs;
					bs = 1;
//					System.out.println(temcout);
				} else {
					temcout= temcout-tem * bs;
					if (bs < 18) {
						bs++;
					}
//					System.out.println(temcout);
				}

			}
			System.out.println(tz);
			int temcha = get - use;
			System.out.println(temcha);
			getCount = getCount + temcha;
			lastres.clear();
			lastres.addAll(list);
		}
	}

	public void fx(List<Integer> list) {
		int[] count = new int[28];
		list.stream().forEach(e -> count[e]++);
		for (int i = 0; i <= 27; i++) {
			double temd = ((double)count[i] / list.size()) / jg[i > 13 ? 27 - i : i];
			BigDecimal b = new BigDecimal(temd);
			temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			allres.set(i, allres.get(i) + (temd + ">>"));
		}
	}

	public void fx3(List<Integer> list) {
		System.out.println("count:" + list.size());
		int[] count = new int[28];
		list.stream().forEach(e -> count[e]++);
		List<Integer> tz = new ArrayList<>();
		for (int i = 0; i <= 27; i++) {
			double temd = ((double)count[i] / list.size()) / jg[i > 13 ? 27 - i : i];
			BigDecimal b = new BigDecimal(temd);
			temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			if (temd < 1) {
				if (i > 2 && i < 25) {
					tz.add(i);
				}
			}
		}
		System.out.println(tz);
		System.out.println("=====================");
	}

	public void fx1(List<Integer> list) {
		System.out.println("count:" + list.size());
		int[] count = new int[28];
		list.stream().forEach(e -> count[e]++);
		for (int i = 0; i <= 27; i++) {
			double temd = ((double)count[i] / list.size()) / jg[i > 13 ? 27 - i : i];
			BigDecimal b = new BigDecimal(temd);
			temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println((temd + "-----" + i + "....." + (temd > 1 ? i : "")));
		}
		System.out.println("=====================");
	}

}
