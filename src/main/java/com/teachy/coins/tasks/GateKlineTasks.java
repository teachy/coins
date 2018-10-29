package com.teachy.coins.tasks;

import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
import com.teachy.coins.utils.DateUtils;

/**
 * Timely tracking and early warning
 */
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
	private List<String> warningList = new ArrayList<>();
	private List<String> noWarningList = new ArrayList<>();
	private static List<BaseCoins> coinsList;
	private Map<String, String> emailList = new HashMap<>();
	ExecutorService executorService = Executors.newFixedThreadPool(3);

	/**
	 * 1m
	 */
	@Scheduled(cron = "10 0/1 * * * ?")
	public void getKline1m() throws InterruptedException {
		if (first) {
			init();
			first = false;
			warningList.add(TabbleName.M1.getValue());
			warningList.add(TabbleName.M5.getValue());
			warningList.add(TabbleName.M10.getValue());
			warningList.add(TabbleName.M30.getValue());
			noWarningList.add(TabbleName.H12.getValue());
			noWarningList.add(TabbleName.H24.getValue());
		}
		coinsList = baseCoinsDAO.getEnableCoins();
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 60, 2, TabbleName.M1.getValue(), countDownLatch));
		countDownLatch.await();

	}

	/**
	 * 5m
	 */
	@Scheduled(cron = "12 0/5 * * * ?")
	public void getKline5m() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 300, 10, TabbleName.M5.getValue(), countDownLatch));
		countDownLatch.await();
	}

	/**
	 * 10m
	 */
	@Scheduled(cron = "17 0/10 * * * ?")
	public void getKline10m() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 600, 20, TabbleName.M10.getValue(),countDownLatch));
		countDownLatch.await();
	}

	/**
	 * 30m
	 */
	@Scheduled(cron = "27 0/30 * * * ?")
	public void getKline30m() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 1800, 60, TabbleName.M30.getValue(),countDownLatch));
		countDownLatch.await();
	}

	/**
	 * 1h
	 */
	@Scheduled(cron = "49 1 0/1 * * ?")
	public void getKline1h() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 3600, 120, TabbleName.H1.getValue(),countDownLatch));
		countDownLatch.await();
	}

	/**
	 * 2h
	 */
	@Scheduled(cron = "11 1 0/2 * * ?")
	public void getKline2h() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 7200, 240, TabbleName.H2.getValue(),countDownLatch));
		countDownLatch.await();
	}

	/**
	 * 4h
	 */
	@Scheduled(cron = "15 1 0/4 * * ?")
	public void getKline4h() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 14400, 480, TabbleName.H4.getValue(),countDownLatch));
		countDownLatch.await();
	}

	/**
	 * 12h
	 */
	@Scheduled(cron = "19 1 0/12 * * ?")
	public void getKline12h() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 43200, 1500, TabbleName.H12.getValue(),countDownLatch));
		countDownLatch.await();
	}

	/**
	 * 24h
	 */
	@Scheduled(cron = "24 1 0 * * ?")
	public void getKline24h() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(coinsList.size());
		coinsList.stream().forEach(
			e -> insert(e.getName(), CoinsType_USTD, 86400, 3000, TabbleName.H24.getValue(),countDownLatch));
		countDownLatch.await();
	}

	private void insert(String coinName, String coinType, int time, double hour, String tableName,
		CountDownLatch countDownLatch) {
		executorService.execute(() -> {
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
					Collections.reverse(klines);
					insertKlines(klines.stream().limit(5).collect(toList()));
					if (warningList.contains(tableName) || noWarningList.contains(tableName)) {
						int volume = checkVolume(klines);
						int price = checkPrice(klines);
						int count = volume + price;
						if (price > 1 && volume > 1) {
							if (warningList.contains(tableName)) {
								Warning warning = new Warning(WEBSITE, coinName, volume, price, count, 0, tableName);
								Warning warning1 = warningDAO.selectWarning(warning);
								if (warning1 == null) {
									warningDAO.insert(warning);
								} else {
									warning.setId(warning1.getId());
									warningDAO.updateById(warning);
								}
								String title = WEBSITE + ":" + coinName;
								if (emailList.get(title) == null) {
									sendEmail(warning, title);
								} else {
									if (DateUtils.differentDays(emailList.get(title)) > 1) {
										sendEmail(warning, title);
									}
								}
							} else {
								//If an alarm is generated during this time period, it will not be followed for a short time.
								baseCoinsDAO.updateCoinsIsable(new BaseCoins(coinName, WEBSITE, 0));
							}

						}
					}
				}
			} catch (Exception e) {
				//do nothing
			} finally {
				countDownLatch.countDown();
			}
		});
	}

	private void sendEmail(Warning warning, String title) {
		emailList.put(title, DateUtils.convertTimeToString(System.currentTimeMillis()));
		String content = warning.toString();
		logger.info("send email begin......");
		logger.info("title:{},content:{}", title, content);
		sendEmail.sendEmail(title, content);
		logger.info("send email end......");
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

	public static int checkPrice(List<Kbase> list) {
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
		if (newList.size() > 10) {
			DoubleStream doubleStream = newList.stream().skip(1).mapToDouble(Double::doubleValue);
			DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
			double avg = doubleSummaryStatistics.getAverage();
			if (firstAvg > avg) {
				return (int)(new BigDecimal((firstAvg - avg) / avg).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()
					* 15);
			}
		}
		return 0;
	}

	public static int checkVolume(List<Kbase> list) {
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
		if (newList.size() > 10) {
			DoubleStream doubleStream = newList.stream().skip(1).mapToDouble(Double::doubleValue);
			DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
			double avg = doubleSummaryStatistics.getAverage();
			return (int)(firstVolume / avg);
		}
		return 0;
	}
}
