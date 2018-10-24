package com.teachy.coins.tasks;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;

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
import com.teachy.coins.utils.DateUtils;

/**
 * Tracking but not warning
 */
@Component
public class GateKlineTasksNotAnalyzed extends BaseTask {

	private final static String query_url = "https://data.gateio.io";
	private final static String trade_url = "https://api.gateio.io";
	private static IStockRestApi stockGet = new StockRestApiImpl(query_url);
	private static IStockRestApi stockPost = new StockRestApiImpl(trade_url);
	private final static String WEBSITE = "gate";
	private final static String GROUP_SET = "group_set";
	private final static String GROUP_SEC = "group_sec";
	private final String CoinsType_USTD = CoinsType.USDT.getType();

	/**
	 * 1m-long
	 */
	@Scheduled(cron = "31 1 0/4 * * ?")
	public void getKline1m_NotAnalyzed() {
		List<BaseCoins> disableCoins = baseCoinsDAO.getDisableCoins();
		disableCoins.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 60, 12, TabbleName.M1.getValue()));
		disableCoins.stream().filter(e -> e.getEnable() == 0).filter(
			e -> DateUtils.differentDays(e.getUpdateTime()) > 5).forEach(e -> {
			baseCoinsDAO.updateCoinsIsable(new BaseCoins(e.getName(), e.getWebsite(), 1));
		});
	}

	/**
	 * 5m-long
	 */
	@Scheduled(cron = "33 3 0/8 * * ?")
	public void getKline5m_NotAnalyzed() {
		baseCoinsDAO.getDisableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 300, 24, TabbleName.M5.getValue()));
	}

	/**
	 * 10m-long
	 */
	@Scheduled(cron = "35 10 0/16 * * ?")
	public void getKline10m_NotAnalyzed() {
		baseCoinsDAO.getDisableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 600, 48, TabbleName.M10.getValue()));
	}

	/**
	 * 30m-long
	 */
	@Scheduled(cron = "37 7 0/23 * * ?")
	public void getKline30m_NotAnalyzed() {
		baseCoinsDAO.getDisableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 1800, 64, TabbleName.M30.getValue()));
	}

	/**
	 * 1h-long
	 */
	@Scheduled(cron = "39 5 0/23 * * ?")
	public void getKline1h_NotAnalyzed() {
		baseCoinsDAO.getDisableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 3600, 96, TabbleName.H1.getValue()));
	}

	/**
	 * 4h
	 */
	@Scheduled(cron = "15 10 0/23 * * ?")
	public void getKline4h_NotAnalyzed() {
		baseCoinsDAO.getDisableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 14400, 320, TabbleName.H4.getValue()));
	}

	/**
	 * 12h
	 */
	@Scheduled(cron = "19 11 0/12 * * ?")
	public void getKline12h_NotAnalyzed() {
		baseCoinsDAO.getDisableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 43200, 1200, TabbleName.H12.getValue()));
	}

	/**
	 * 24h
	 */
	@Scheduled(cron = "24 21 0 * * ?")
	public void getKline24h_NotAnalyzed() {
		baseCoinsDAO.getDisableCoins().stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 86400, 2400, TabbleName.H24.getValue()));
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
			}
		} catch (Exception e) {
			//do nothing
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
		klines.stream().forEach((Kbase each) -> {
			try {
				klineDAO.insert(each);
			} catch (Exception e) {
			}
		});
	}

}
