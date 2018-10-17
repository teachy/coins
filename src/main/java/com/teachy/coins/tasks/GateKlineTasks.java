package com.teachy.coins.tasks;

import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.teachy.coins.enumers.CoinsType;
import com.teachy.coins.enumers.TabbleName;
import com.teachy.coins.gateio.restApi.IStockRestApi;
import com.teachy.coins.gateio.restApi.impl.StockRestApiImpl;
import com.teachy.coins.model.BaseCoins;
import com.teachy.coins.model.Kbase;

//@Component
public class GateKlineTasks extends BaseTask {

	private final static String query_url = "https://data.gateio.io";
	private final static String trade_url = "https://api.gateio.io";
	private static IStockRestApi stockGet = new StockRestApiImpl(query_url);
	private static IStockRestApi stockPost = new StockRestApiImpl(trade_url);
	private final static String WEBSITE = "gate";
	private final static String GROUP_SET = "group_set";
	private final static String GROUP_SEC = "group_sec";
	private boolean first = true;
	private final String CoinsType_USTD = CoinsType.USDT.getType();

	/**
	 * 1m
	 */
	@Scheduled(cron = "1 0/1 * * * ?")
	public void getKline1m() {
		if (first) {
			init();
			first = false;
		}
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 60, 1, TabbleName.M1.getValue()));
	}

	/**
	 * 1m-long
	 */
	@Scheduled(cron = "31 1 0/5 * * ?")
	public void getKline1m_long() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 60, 6, TabbleName.M1.getValue()));
	}

	/**
	 * 5m
	 */
	@Scheduled(cron = "3 0/5 * * * ?")
	public void getKline5m() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 300, 2, TabbleName.M5.getValue()));
	}

	/**
	 * 5m-long
	 */
	@Scheduled(cron = "33 3 0/10 * * ?")
	public void getKline5m_long() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 300, 24, TabbleName.M5.getValue()));
	}

	/**
	 * 10m
	 */
	@Scheduled(cron = "5 0/10 * * * ?")
	public void getKline10m() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 600, 5, TabbleName.M10.getValue()));
	}

	/**
	 * 10m-long
	 */
	@Scheduled(cron = "35 10 0/20 * * ?")
	public void getKline10m_long() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 600, 48, TabbleName.M10.getValue()));
	}

	/**
	 * 30m
	 */
	@Scheduled(cron = "7 0/30 * * * ?")
	public void getKline30m() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 1800, 20, TabbleName.M30.getValue()));
	}

	/**
	 * 30m-long
	 */
	@Scheduled(cron = "37 7 0/23 * * ?")
	public void getKline30m_long() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 1800, 96, TabbleName.M30.getValue()));
	}

	/**
	 * 1h
	 */
	@Scheduled(cron = "9 1 0/1 * * ?")
	public void getKline1h() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 3600, 48, TabbleName.H1.getValue()));
	}

	/**
	 * 1h-long
	 */
	@Scheduled(cron = "39 1 0/23 * * ?")
	public void getKline1h_long() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 3600, 192, TabbleName.H1.getValue()));
	}

	/**
	 * 2h
	 */
	@Scheduled(cron = "11 1 0/2 * * ?")
	public void getKline2h() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 7200, 320, TabbleName.H2.getValue()));
	}

	/**
	 * 4h
	 */
	@Scheduled(cron = "15 1 0/4 * * ?")
	public void getKline4h() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 14400, 640, TabbleName.H4.getValue()));
	}

	/**
	 * 12h
	 */
	@Scheduled(cron = "19 1 0/12 * * ?")
	public void getKline12h() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 43200, 2400, TabbleName.H12.getValue()));
	}

	/**
	 * 24h
	 */
	@Scheduled(cron = "24 1 0 * * ?")
	public void getKline24h() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 86400, 4800, TabbleName.H24.getValue()));
	}

	private void insert(String coinName, String coinType, int time, double hour, String tableName) {
		try {
			String pairs = stockGet.candlestick2(coinName, coinType, time, hour, GROUP_SEC);
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
	}

	private void init() {
		try {
			String res = stockGet.pairs();
			JSONArray array = JSONArray.parseArray(res);
			List<BaseCoins> list = array.stream().map(e -> e.toString()).filter(e -> e.endsWith("_USDT")).map(
				e -> new BaseCoins(e.replace("_USDT", ""), "gateIo", 0)).collect(toList());
			list.stream().forEach(e -> baseCoinsDAO.insert(e));
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
