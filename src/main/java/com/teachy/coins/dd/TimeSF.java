package com.teachy.coins.dd;

import static java.util.stream.Collectors.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TimeSF {
	public static List<Integer> getRes(long qihao) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		long k = qihao-853105;
		for (int j = 0; j <= 1; j++) {
			Random rd = new Random(1542080154852l + j + k * 90000);
			a.add(rd.nextInt(10));
		}

		for (int j = 0; j <= 1; j++) {
			Random rd = new Random(1542080164327l + j + k * 90000);
			b.add(rd.nextInt(10));
		}

		for (int j = 0; j <= 1; j++) {
			Random rd = new Random(1542080158513l + j + k * 90000);
			c.add(rd.nextInt(10));
		}
		List<Integer> d = new ArrayList<>();
		int a1 = a.get(0)+b.get(0)+c.get(0);
		int a2 = a.get(0)+b.get(0)+c.get(1);
		int a3 = a.get(0)+b.get(1)+c.get(0);
		int a4 = a.get(0)+b.get(1)+c.get(1);
		int a5 = a.get(1)+b.get(0)+c.get(0);
		int a6 = a.get(1)+b.get(0)+c.get(1);
		int a7 = a.get(1)+b.get(1)+c.get(0);
		int a8 = a.get(1)+b.get(1)+c.get(1);
		d.add(a1);
		d.add(a2);
		d.add(a3);
		d.add(a4);
		d.add(a5);
		d.add(a6);
		d.add(a7);
		d.add(a8);
		return d.stream().distinct().sorted().collect(toList());
	}
	public static long getTimeforLong(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(time).getTime();
	}

	public static void main(String[] args) {
		System.out.println(getRes(853391));
	}
}
