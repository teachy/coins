package com.teachy.coins.tasks;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teachy.coins.enumers.TabbleName;
import com.teachy.coins.model.Kbase;

@Component
public class KlineWarning extends BaseTask {
	private final String WEBSITE = "gate";
	private final String TYPE = "usdt";

	@Scheduled(cron = "0/10 * * * * ?")
	public void warningKline() {
		baseCoinsDAO.getEnableCoins().stream().forEach(e -> check(e.getName()));
	}

	private void check(String name) {
		List<List<Kbase>> allList = Stream.of(TabbleName.M1.getValue()).map(
			e -> klineDAO.getList(new Kbase(WEBSITE, TYPE, name, e))).collect(
			toList());
		int volume = checkPrices(allList.stream().collect(toList()));
		int price = checkVolumes(allList.stream().collect(toList()));
		System.out.println(volume + price);
	}

	private int checkPrices(List<List<Kbase>> allList) {
		IntStream intStream = allList.stream().mapToInt(e -> checkPrice(e));
		return intStream.sum();
	}

	private int checkVolumes(List<List<Kbase>> allList) {
		IntStream intStream = allList.stream().mapToInt(e -> checkVolume(e));
		return intStream.sum();
	}

	private int checkPrice(List<Kbase> list) {
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
					* 10);
			}
		}
		return 0;
	}

	private int checkVolume(List<Kbase> list) {
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
