package com.teachy.coins.dd;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Times {
	/**
	 *
	 * @Title: getCheckTime
	 * @Description: 时间策略
	 * @param @return    设定文件
	 * @return Boolean    返回类型
	 * @throws
	 */
	public static Boolean getCheckTime() {
		int currentTime = getTime();
		List<Integer> list0 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> list20 = Arrays.asList(0, 7);
		List<Integer> list40 = Arrays.asList(23);
		List<Integer> list60 = Arrays.asList(12, 18);
		List<Integer> list80 = Arrays.asList(8, 11, 22);
		if (list0.contains(currentTime)) {
			return false;
		} else if (list20.contains(currentTime)) {
			int i = (int)(Math.random() * 10);
			if (i <= 2) {
				return true;
			} else {
				return false;
			}
		} else if (list40.contains(currentTime)) {
			int i = (int)(Math.random() * 10);
			if (i <= 4) {
				return true;
			} else {
				return false;
			}
		} else if (list60.contains(currentTime)) {
			int i = (int)(Math.random() * 10);
			if (i <= 6) {
				return true;
			} else {
				return false;
			}
		} else if (list80.contains(currentTime)) {
			int i = (int)(Math.random() * 10);
			if (i <= 8) {
				return true;
			} else {
				return false;
			}
		} else {
			int i = (int)(Math.random() * 40);
			if (i > 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 *
	 * @Title: getTime
	 * @Description: 得到当前小时
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public static int getTime() {
		Date currentTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		String time = format.format(currentTime);
		int h = Integer.parseInt(time.split(":")[0]);
		return h;
	}
}
