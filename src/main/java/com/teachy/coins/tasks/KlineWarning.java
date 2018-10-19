package com.teachy.coins.tasks;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teachy.coins.enumers.TabbleName;
import com.teachy.coins.model.Kbase;
import com.teachy.coins.model.Warning;

@Component
public class KlineWarning extends BaseTask {
	private final String WEBSITE = "gate";
	private final String TYPE = "usdt";

	@Scheduled(cron = "33 0/1 * * * ?")
	public void warningKline() {
		baseCoinsDAO.getEnableCoins().stream().forEach(e -> check(e.getName()));
	}

	private void check(String name) {
		List<List<Kbase>> allList = Stream.of(TabbleName.M1.getValue(), TabbleName.M5.getValue(),
			TabbleName.M10.getValue(), TabbleName.M30.getValue(), TabbleName.H1.getValue(),
			TabbleName.H2.getValue()).map(
			e -> klineDAO.getList(new Kbase(WEBSITE, TYPE, name, e))).collect(
			toList());
		int volume = checks(allList, KlineWarning::checkVolume);
		int price = checks(allList, KlineWarning::checkPrice);
		int count = volume + price;
		if (price > 1 && count > 2) {
			Warning warning = new Warning(WEBSITE, name, volume, price, count, 0, "");
			Warning warning1 = warningDAO.selectWarning(warning);
			if (warning1 == null) {
				warningDAO.insert(warning);
			} else {
				warning.setId(warning1.getId());
				warningDAO.updateById(warning);
			}
		}
	}

	private int checks(List<List<Kbase>> allList, ToIntFunction<List<Kbase>> toIntFunction) {
		IntStream intStream = allList.stream().mapToInt(toIntFunction);
		return intStream.sum();
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
		if (newList.size() > 10) {
			DoubleStream doubleStream = newList.stream().skip(1).mapToDouble(Double::doubleValue);
			DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
			double avg = doubleSummaryStatistics.getAverage();
			return (int)(firstVolume / avg);
		}
		return 0;
	}
}
