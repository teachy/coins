package com.teachy.coins.tasks;

import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.apache.http.HttpException;
import org.apache.http.conn.ConnectTimeoutException;
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
import com.teachy.coins.model.Warning;

@Component
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
	@Scheduled(cron = "10 0/1* * * ?")
	public void getKline1m() {
		if (first) {
			init();
			first = false;
		}
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 60, 0.1, TabbleName.M1.getValue()));
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
	@Scheduled(cron = "12 0/5 * * * ?")
	public void getKline5m() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 300, 5, TabbleName.M5.getValue()));
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
	@Scheduled(cron = "17 0/10 * * * ?")
	public void getKline10m() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 600, 10, TabbleName.M10.getValue()));
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
	@Scheduled(cron = "27 0/30 * * * ?")
	public void getKline30m() {
		baseCoinsDAO.getEnableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 1800, 30, TabbleName.M30.getValue()));
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
	@Scheduled(cron = "49 1 0/1 * * ?")
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
				List<Kbase> klines = datas.stream().map(
					(JSONArray line) -> getKbase(line, coinName, coinType,
						tableName)).sorted(Comparator.comparingLong(e -> e.getTimeLong())).limit(
					datas.size() - 1).collect(
					toList());
				insertKlines(klines);
				Collections.reverse(klines);
				int volume = checkVolume(klines);
				int price = checkPrice(klines);
				int count = volume + price;
				if (price > 1 && volume > 1) {
					Warning warning = new Warning(WEBSITE, coinName, volume, price, count, 0, tableName);
					Warning warning1 = warningDAO.selectWarning(warning);
					if (warning1 == null) {
						warningDAO.insert(warning);
					} else {
						warning.setId(warning1.getId());
						warningDAO.updateById(warning);
					}
				}
			}
		} catch (Exception e) {
			//do nothing
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
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
				e -> new BaseCoins(e.replace("_USDT", ""), "gate", 1)).collect(toList());
			list.stream().forEach(e -> baseCoinsDAO.insert(e));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int checkPrice(List<Kbase> list) {
		if (list == null || list.size() == 0) {
			return 0;
		}
		List<Double> avgList = list.stream().map(e -> (e.getClose() + e.getOpen()) / 2).collect(toList());
		double firstAvg = avgList.get(0);
		List<Double> newList = new ArrayList();
		for (Double d : avgList) {
			if (d <= firstAvg) {
				newList.add(d);
			} else {
				break;
			}
		}
		if (newList.size() > 3) {
			DoubleStream doubleStream = newList.stream().skip(1).mapToDouble(Double::doubleValue);
			DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
			double avg = doubleSummaryStatistics.getAverage();
			if (firstAvg > avg) {
				return (int)(new BigDecimal((firstAvg - avg) / avg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()
					* 10);
			}
		}
		return 0;
	}

	private static int checkVolume(List<Kbase> list) {
		if (list == null || list.size() == 0) {
			return 0;
		}
		double firstVolume = list.get(0).getVolume();
		List<Double> newList = new ArrayList();
		for (Kbase kbase : list) {
			if (kbase.getVolume() <= firstVolume) {
				if (kbase.getVolume() > 0) {
					newList.add(kbase.getVolume());
				}
			} else {
				break;
			}
		}
		if (newList.size() > 3) {
			DoubleStream doubleStream = newList.stream().skip(1).mapToDouble(Double::doubleValue);
			DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
			double avg = doubleSummaryStatistics.getAverage();
			return (int)(firstVolume / avg);
		}
		return 0;
	}
}
