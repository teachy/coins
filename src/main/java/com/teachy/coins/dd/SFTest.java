package com.teachy.coins.dd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teachy.coins.mapper.Dd3799DDAO;

@Component
public class SFTest {
	static double[] jg = {0.001, 0.003, 0.006, 0.01, 0.015, 0.021, 0.028,
		0.036, 0.045, 0.055, 0.063, 0.069, 0.073, 0.075};
	static int[] bet = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75,
		75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
	@Autowired
	private Dd3799DDAO dd3799DDAO;

	List<Integer> jstz1 = new ArrayList<>();
	List<Integer> fktz1 = new ArrayList<>();
	List<Integer> jstz2 = new ArrayList<>();
	List<Integer> fktz2 = new ArrayList<>();
	public static int js1 = 0;
	public static int fk1 = 0;
	public static int js2 = 0;
	public static int fk2 = 0;
	public static int js3 = 0;
	public static int fk3 = 0;
	int jsbs1 = 1;
	int fkbs1 = 1;
	int jsbs2 = 1;
	int fkbs2 = 1;
	int jsbs3 = 1;
	int fkbs3 = 1;
	int cankao = 700;
	public void test(DD dd, String type, double f, int max, List<Integer> res) {
		try {
			test1(dd, type, f, max);
			test2(dd, type, f, max);
			test3(dd, type, max, res);
		} catch (Exception e) {

		}

	}

	private void test1(DD dd, String type, double f, int max) {
		if (type.equals("JS")) {
			if (!(jstz1.size() == 0)) {
				int tem = jstz1.stream().mapToInt(e -> bet[e]).sum();
				if (jstz1.contains(dd.getJieguo())) {
					js1 = js1 + jsbs1 * 990 - tem * jsbs1;
					jsbs1 = 1;
				} else {
					js1 = js1 - tem * jsbs1;
					if (jsbs1 < max) {
						jsbs1++;
					}
				}
			}
			List res = dd3799DDAO.getList("JS");
			if (res.size() > cankao) {
				fx(res, f, jstz1);
			}
		}

		if (type.equals("FK")) {
			if (!(fktz1.size() == 0)) {
				int tem = fktz1.stream().mapToInt(e -> bet[e]).sum();
				if (fktz1.contains(dd.getJieguo())) {
					fk1 = fk1 + fkbs1 * 990 - tem * fkbs1;
					fkbs1 = 1;
				} else {
					fk1 = fk1 - tem * fkbs1;
					if (fkbs1 < max) {
						fkbs1++;
					}
				}
			}
			List res = dd3799DDAO.getList("FK");
			if (res.size() > cankao) {
				fx(res, f, fktz1);
			}
		}
	}

	private void test2(DD dd, String type, double f, int max) {
		if (type.equals("JS")) {
			if (!(jstz2.size() == 0)) {
				int tem = jstz2.stream().mapToInt(e -> bet[e]).sum();
				if (jstz2.contains(dd.getJieguo())) {
					js2 = js2 + jsbs2 * 990 - tem * jsbs2;
					jsbs2 = 1;
				} else {
					js2 = js2 - tem * jsbs2;
					if (jsbs2 < max) {
						jsbs2++;
					}
				}
			}
			List res = dd3799DDAO.getListByDay("JS");
			if (res.size() > cankao) {
				fx(res, f, jstz2);
			}
		}

		if (type.equals("FK")) {
			if (!(fktz2.size() == 0)) {
				int tem = fktz2.stream().mapToInt(e -> bet[e]).sum();
				if (fktz2.contains(dd.getJieguo())) {
					fk2 = fk2 + fkbs2 * 990 - tem * fkbs2;
					fkbs2 = 1;
				} else {
					fk2 = fk2 - tem * fkbs2;
					if (fkbs2 < max) {
						fkbs2++;
					}
				}
			}
			List res = dd3799DDAO.getListByDay("FK");
			if (res.size() > cankao) {
				fx(res, f, fktz2);
			}
		}
	}

	private void test3(DD dd, String type, int max, List<Integer> res) {
		if (type.equals("JS")) {
			if (res.size() != 0) {
				int tem = res.stream().mapToInt(e -> bet[e]).sum();
				if (res.contains(dd.getJieguo())) {
					js3 = js3 + jsbs3 * 990 - tem * jsbs3;
					jsbs3 = 1;
				} else {
					js3 = js3 - tem * jsbs3;
					if (jsbs3 < max) {
						jsbs3++;
					}
				}
			}
		}

		if (type.equals("FK")) {
			if (res.size() != 0) {
				int tem = res.stream().mapToInt(e -> bet[e]).sum();
				if (res.contains(dd.getJieguo())) {
					fk3 = fk3 + fkbs3 * 990 - tem * fkbs3;
					fkbs3 = 1;
				} else {
					fk3 = fk3 - tem * fkbs3;
					if (fkbs3 < max) {
						fkbs3++;
					}
				}
			}
		}
	}

	public List<Integer> fx(List<Integer> list, double f, List<Integer> tz) {
		tz.clear();
		int[] count = new int[28];
		list.stream().forEach(e -> count[e]++);
		for (int i = 0; i <= 27; i++) {
			double temd = ((double)count[i] / list.size()) / jg[i > 13 ? 27 - i : i];
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
}
