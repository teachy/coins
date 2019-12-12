package com.teachy.coins.macdandkdj;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/** 
* @ClassName: StringUtil 
* @Description: 字符串工具类
* @author gang.tu
* @date 2018年5月7日 上午11:47:03 
*  
*/
public class StringUtil {

	/**
	 * 根据正则表达式获取匹配的字符串 只获取括号中的第一个
	 * 
	 * @Title: getRegexStr @param @return @return String @throws
	 */
	public static String getRegexStr1(String sourceStr, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sourceStr);
		if (m.find()) {
			return m.group(1);
		}

		return null;
	}

	public static String getRegexStr(String sourceStr, String regex) {
		Pattern p = Pattern.compile(regex, Pattern.DOTALL);
		Matcher m = p.matcher(sourceStr);
		if (m.find()) {
			return m.group(1);
		}

		return null;
	}

	/**
	 * 
	 * @Title: getRegexStrs @Description: 根据正则返回字符串匹配的所有集合 @param @param
	 * sourceStr @param @param regex @param @return 设定文件 @return Set<String>
	 * 返回类型 @throws
	 */
	public static List<String> getRegexStrs(String sourceStr, String regex, String begin) {
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sourceStr);
		while (m.find()) {
			list.add(begin + m.group(1));
		}
		return list;
	}

	/**
	 * 
	 * @Title: getRegexStrs @Description: 根据正则返回字符串匹配的所有集合 @param @param
	 * sourceStr @param @param regex @param @return 设定文件 @return Set<String>
	 */
	public static List<String> getRegexStrs(String sourceStr, String regex) {
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sourceStr);
		while (m.find()) {
			list.add(m.group(1));
		}
		return list;
	}

	public static List<String> getRegexStrs1(String sourceStr, String regex) {
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(regex, Pattern.DOTALL);
		Matcher m = p.matcher(sourceStr);
		while (m.find()) {
			list.add(m.group(1));
		}
		return list;
	}

	/**
	 * 
	 * 随机生成id @Title: getUUID @param @return 设定文件 @return String 返回类型 @throws
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
