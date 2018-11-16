package com.teachy.coins.dd;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.mapper.Dd3799DDAO;
import com.teachy.coins.model.Dd3799D;
import com.teachy.coins.utils.StringUtils;

@Component
public class DDSprider {
	static double[] jg = {0.001, 0.003, 0.006, 0.01, 0.015, 0.021, 0.028,
		0.036, 0.045, 0.055, 0.063, 0.069, 0.073, 0.075};
	static int[] bet = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75,
		75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
	@Autowired
	private Dd3799DDAO dd3799DDAO;

	public DD get28(HttpGet get) throws IOException, InterruptedException {
		DD dd = new DD();
		String jcTime = null;
		String kjTime = null;
		String qihao = null;
		String currentNumber = null;
		int tryTime = 0;
		String htmlPage = null;
		while (jcTime == null || jcTime.length() <= 0) {
			tryTime++;
			if (tryTime >= 3) {
				break;
			}
			HttpResponse response = DDTasks.httpClient.execute(get);
			htmlPage = DDTasks.getAllContent(response);
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
		insertDD(get, htmlPage, temQH);
		int jieguo = Integer.parseInt(currentNumber);
		dd.setJcTime(jcTime);
		dd.setKjTime(kjTime);
		dd.setTemQH(temQH);
		dd.setJieguo(jieguo);
		return dd;
	}

	public void tz28(DD dd, int betting, HttpPost post, List<Integer> list) throws IOException {
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

	public List<Integer> getList(String url, double f) throws IOException {
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
				if (temd < f) {
					if (i > 2 && i < 25) {
						tz.add(i);
					}
				}
			}
		}
		return tz;
	}

	public List<Integer> getListbyDB(String type, double f){
		List<Integer> evelist;
		List<Integer> tz = new ArrayList<>();
		int[] count = new int[28];
		if(type.equals("JS")){
			evelist = dd3799DDAO.getListByDay("JS");
		}else{
			evelist = dd3799DDAO.getListByDay("FK");
		}
		evelist.stream().forEach(e -> count[e]++);
		for (int i = 0; i <= 27; i++) {
			double temd = ((double)count[i] / evelist.size()) / jg[i > 13 ? 27 - i : i];
			BigDecimal b = new BigDecimal(temd);
			temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			if (temd < f) {
				if (i > 2 && i < 25) {
					tz.add(i);
				}
			}
		}
		return tz;
	}

	public List<Integer> getListbyDBLimit(String type, double f,int limit){
		List<Integer> evelist;
		List<Integer> tz = new ArrayList<>();
		int[] count = new int[28];
		Map<String,Object> map = new HashMap();
		map.put("limit",limit);
		if(type.equals("JS")){
			map.put("type","JS");
			evelist = dd3799DDAO.getListByLimit(map);
		}else{
			map.put("type","FK");
			evelist = dd3799DDAO.getListByLimit(map);
		}
		evelist.stream().forEach(e -> count[e]++);
		for (int i = 0; i <= 27; i++) {
			double temd = ((double)count[i] / evelist.size()) / jg[i > 13 ? 27 - i : i];
			BigDecimal b = new BigDecimal(temd);
			temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			if (temd < f) {
				if (i > 2 && i < 25) {
					tz.add(i);
				}
			}
		}
		return tz;
	}

	private void insertDD(HttpGet get, String htmlPage, long temQH) {

		List<String> res;
		String type;
		if (get.getURI().toString().contains("Speed28")) {
			res = StringUtils.getRegexStrs(htmlPage, "class=\"js-ball b-js28\">(\\d+)<");
			type = "JS";
		} else {
			res = StringUtils.getRegexStrs(htmlPage, "class=\"js-ball b-fk28\">(\\d+)<");
			type = "FK";
		}
		for (String s : res) {
			temQH = temQH - 1;
			Dd3799D dd3799D = new Dd3799D(type, temQH + "", s);
			try {
				dd3799DDAO.insert(dd3799D);
			} catch (Exception e) {

			}
		}
	}

}
