package com.teachy.coins.tasks;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.enumers.Coins;
import com.teachy.coins.enumers.CoinsType;
import com.teachy.coins.enumers.TabbleName;
import com.teachy.coins.gateio.restApi.IStockRestApi;
import com.teachy.coins.gateio.restApi.impl.StockRestApiImpl;
import com.teachy.coins.mapper.KlineDAO;
import com.teachy.coins.model.Kbase;

@Component
public class KlineTasks {

	@Autowired
	private KlineDAO klineDAO;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final static String query_url = "https://data.gateio.io";
	private final static String trade_url = "https://api.gateio.io";
	private static IStockRestApi stockGet = new StockRestApiImpl(query_url);
	private static IStockRestApi stockPost = new StockRestApiImpl(trade_url);
	private final static String WEBSITE = "gate";
	private final static String GROUP_SET = "group_set";
	private final static String GROUP_SEC = "group_sec";

	/**
	 * 1m-btc_usdt
	 */
	@Scheduled(cron = "0 0/1 * * * ?")
	private void getKline1m() {
		Coins[] coins = Coins.values();
		Arrays.stream(coins).forEach(
			e -> insert(e.getName(), CoinsType.USDT.getType(), 60, 0.1, GROUP_SEC, TabbleName.M1.getValue()));
	}

	private void insert(String coinName, String coinType, int time, double hour, String type, String tableName) {
		try {
			String pairs = stockGet.candlestick2(coinName, coinType, time, hour, type);
			JSONObject res = JSONObject.parseObject(pairs);
			if (hasData(res)) {
				List<JSONArray> datas = (List<JSONArray>)res.get("data");
				List<Kbase> klines = datas.parallelStream().map(
					(JSONArray line) -> getKbase(line, coinName, coinType,
						tableName)).sorted(Comparator.comparingLong(e -> e.getTimeLong())).limit(
					datas.size() - 1).collect(
					toList());
				insertKlines(klines);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Kbase getKbase(JSONArray line, String name, String type, String tableName) {
		long time = Long.parseLong(line.getString(0));
		Double volume = Double.parseDouble(line.getString(1));
		Double close = Double.parseDouble(line.getString(2));
		Double high = Double.parseDouble(line.getString(3));
		Double low = Double.parseDouble(line.getString(4));
		Double open = Double.parseDouble(line.getString(5));
		return new Kbase(time, volume, close, high, low, open, WEBSITE, type, name, tableName);
	}

	private boolean hasData(JSONObject res) {
		return res.getString("result").equals("true");
	}

	private void insertKlines(List<Kbase> klines) {
		AtomicInteger success = new AtomicInteger();
		AtomicInteger error = new AtomicInteger();
		klines.stream().forEach((Kbase each) -> {
			try {
				klineDAO.insert(each);
				success.getAndIncrement();
			} catch (Exception e) {
				error.getAndIncrement();
			}
		});
		System.out.println(success.get());
		System.out.println(error.get());
	}
}
