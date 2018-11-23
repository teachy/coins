package com.teachy.coins.dd;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teachy.coins.mapper.Dd3799DDAO;

//@Component
public class SpiderTask3 {

	static double[] jg = {0.001, 0.003, 0.006, 0.01, 0.015, 0.021, 0.028,
		0.036, 0.045, 0.055, 0.063, 0.069, 0.073, 0.075};
	static int[] bet = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75,
		75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
	List<Integer> allres = new ArrayList<>();
	@Autowired
	private Dd3799DDAO dd3799DDAO;
	int max1 = 1;
	int max2 = 1;
	int mmm = 0;
	int mmm1 = 0;

	@Scheduled(cron = "0/1 * * * * ?")
	public void getHistory1() {
		allres = dd3799DDAO.getAllListByType("JS");
		for (int beginNum = 100; beginNum <= 2000; beginNum = beginNum + 50) {
			System.out.println(beginNum + "---------------");
			for (double t = 0.9; t <= 1.3; t = t + 0.1) {
				for (int j = 1; j <= 40; j++) {
					for (int k = -3000; k <= 10000; k = k + 200) {
						List<Integer> begin = allres.stream().limit(beginNum).collect(toList());
						List<Integer> after = allres.stream().skip(beginNum).collect(toList());
						int tem;
						int temcout = 0;
						List<Integer> count = new ArrayList<>();
						int jishuqi = 0;
						int jishuqicount = 0;
						for (Integer integer : after) {
							int countTem = 0;
							if (count.size() == j) {
								countTem = count.stream().mapToInt(e -> e).sum();
								count.remove(0);
							}
							List<Integer> tz = getTZ(begin, t);
							tem = tz.stream().mapToInt(e -> bet[e]).sum();
							if (tz.contains(integer)) {
								if (count.size() < j) {
									count.add(990 - tem);
								}
								if (count.size() == j && countTem < k) {
									mmm1++;
									temcout = temcout - tem + 990;
									jishuqicount = jishuqicount - tem + 990;
								}
							} else {
								if (count.size() < j) {
									count.add(0 - tem);
								}
								if (count.size() == j && countTem < k) {
									mmm1++;
									temcout = temcout - tem;
									jishuqicount = jishuqicount - tem;
								}
							}
							jishuqi++;
							//								if (jishuqi > 300) {
							//									System.out.println("jishuqicount" + ":" + jishuqicount + ":mmm1:" + mmm1);
							//									jishuqicount = 0;
							//									jishuqi = 0;
							//									mmm1 = 0;
							//								}
							begin.remove(0);
							begin.add(integer);
						}
						if (temcout > mmm) {
							System.out.println(
								"temcout:" + temcout + ":beginNum:" + beginNum + ":t:" + t + ":j:" + j + ":k:" + k);
							mmm = temcout;
						}
					}
				}
			}
		}
	}

	//@Scheduled(cron = "0/1 * * * * ?")
	public void getHistory2() {
		allres = dd3799DDAO.getAllListByType("JS");
		for (int beginNum = 100; beginNum <= 250; beginNum = beginNum + 50) {
			System.out.println(beginNum + "---------------");
			for (double t = 0.9; t <= 1.3; t = t + 0.1) {
				for (int j = 1; j <= 40; j++) {
					for (int k = -3000; k <= 10000; k = k + 200) {
						for (int m = 1; m <= 1; m++) {
							List<Integer> begin = allres.stream().limit(beginNum).collect(toList());
							List<Integer> after = allres.stream().skip(beginNum).collect(toList());
							int tem;
							int temcout = 0;
							List<Integer> count = new ArrayList<>();
							int jishuqi = 0;
							int jishuqicount = 0;
							int bs = 1;
							for (Integer integer : after) {
								int countTem = 0;
								if (count.size() == j) {
									countTem = count.stream().mapToInt(e -> e).sum();
									count.remove(0);
								}
								List<Integer> tz = getTZ(begin, t);
								tem = tz.stream().mapToInt(e -> bet[e]).sum();
								if (tz.contains(integer)) {
									if (count.size() < j) {
										count.add(990 - tem);
									}
									if (bs >= m) {
										if (count.size() == j && countTem < k) {
											mmm1++;
											temcout = temcout - tem + 990;
											jishuqicount = jishuqicount - tem + 990;
										}
									}
									bs = 1;
								} else {
									if (count.size() < j) {
										count.add(0 - tem);
									}
									if (bs >= m) {
										if (count.size() == j && countTem < k) {
											mmm1++;
											temcout = temcout - tem;
											jishuqicount = jishuqicount - tem;
										}
									}
								}
								bs++;
								jishuqi++;
								//								if (jishuqi > 300) {
								//									System.out.println("jishuqicount" + ":" + jishuqicount + ":mmm1:" + mmm1);
								//									jishuqicount = 0;
								//									jishuqi = 0;
								//									mmm1 = 0;
								//								}
								begin.remove(0);
								begin.add(integer);
							}
							if (temcout > mmm) {
								System.out.println(
									"temcout:" + temcout + ":beginNum:" + beginNum + ":t:" + t + ":j:" + j + ":k:" + k
										+ ":m:" + m);
								mmm = temcout;
							}
						}
					}
				}
			}
		}
	}

	private List<Integer> getTZ(List<Integer> begin, double t) {
		List<Integer> tz = new ArrayList<>();
		for (int i = 0; i <= 27; i++) {
			int[] count = new int[28];
			begin.stream().forEach(e -> count[e]++);
			double temd = ((double)count[i] / begin.size()) / jg[i > 13 ? 27 - i : i];
			BigDecimal b = new BigDecimal(temd);
			temd = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			if (temd < t) {
				tz.add(i);
			}
		}
		return tz;
	}

}
