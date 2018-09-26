package com.teachy.coins.tasks;

import java.io.IOException;
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

	/**
	 * 1m-btc_usdt
	 */
	@Scheduled(cron = "* 0/1 * * * ?")
	private void getKline1m() {
		String pairs = null;
		try {
			pairs = stockGet.candlestick2(Coins.BTC.getName(), CoinsType.USDT.getType(), 60, 0.5);
			JSONObject res = JSONObject.parseObject(pairs);
			if (hasData(res)) {
				List<JSONArray> datas = (List<JSONArray>)res.get("data");
				List<Kbase> klines = datas.parallelStream().map(
					(JSONArray line) -> getKbase(line, Coins.BTC.getName(), CoinsType.USDT.getType(),
						TabbleName.M1.getValue())).collect(
					Collectors.toList());
				insertKlines(klines);
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
