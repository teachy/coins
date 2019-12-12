package com.teachy.coins.macdandkdj;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final String maskA = "yyyy年MM月dd日 HH:mm";
	public static final String maskB = "yyyy-MM-dd HH:mm";
	public static final String maskC = "yyyy-MM-dd HH:mm:ss";
	public static final String maskD = "chinese";
	public static final String maskE = "yyyyMMdd";
	public static final String maskF = "long10";
	public static final String maskG = "long13";
	public static final String maskH = "HH:mm";
	public static final String maskI = "MM-dd";
	public static final String maskK = "yyyyMMdd HH:mm:ss";
	public static final String maskL = "yyyy-MM-dd";
	public static final String maskYmdhms = "yyyyMMddHHmmss";
	public static final String maskM ="MM月dd日 HH:mm";
	public static final String maskN ="yyyy年MM月dd日 HH:mm:ss";
	public static final String maskO ="yyyy年MM月dd日 HHmm";
	public static final String maskP ="EnglishTime";
	/**
	 * @throws ParseException
	 *             将指定格式的字符串转换为Date
	 * @Title toMaskDate
	 * @para @param dateStr
	 * @para @param mask
	 * @retur Date
	 * @throws
	 */
	public static Date toMaskDate(String dateStr, String mask)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(mask);
		return format.parse(dateStr);
	}

	/**
	 * 将日期型的日期转为换yyyymmddhhmmss
	 * 
	 * @Title: toYmdhmsString
	 * @Description: TODO
	 * @param @param date
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String toYmdhmsString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(maskYmdhms);
		return format.format(date);
	}

	/**
	 * 将日期型的日期转为换yyyymmddhhmmss
	 * 
	 * @Title: toYmdhmsString
	 * @Description: TODO
	 * @param @param date
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String toDefineString(Date date, String mask) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(mask);
		return format.format(date);
	}

	/**
	 * 将日期转换为年月日
	 * 
	 * @Title: toymd000Date
	 * @Description: TODO
	 * @param @param date
	 * @param @return
	 * @return Date
	 * @throws
	 */
	public static Date toymd000Date(Date date) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.set(Calendar.HOUR_OF_DAY, 0);
		cl.set(Calendar.MINUTE, 0);
		cl.set(Calendar.SECOND, 0);
		cl.set(Calendar.MILLISECOND, 0);
		return cl.getTime();
	}


	/**
	 * 指定日期增加天数
	 * 
	 * @Title: addDate
	 * @Description: TODO
	 * @param @return
	 * @return Date
	 * @throws
	 */
	public static Date addDate(Date date, int dayCount) {

		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_MONTH, ca.get(Calendar.DAY_OF_MONTH) + dayCount);
		return ca.getTime();

	}


	/**
	 * 指定日期增加小时数
	 * 
	 * @Title: addDate
	 * @return Date
	 * @throws
	 */
	public static Date addHour(Date date, int hour) {

		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY) + hour);
		return ca.getTime();

	}

	/**
	 * 指定日期增加分钟数
	 * 
	 * @Title: addMinute
	 * @return Date
	 * @throws
	 */
	public static Date addMinute(Date date, int minute) {

		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.MINUTE, ca.get(Calendar.MINUTE) + minute);
		return ca.getTime();

	}

	/**
	 * 根据秒获取时间间隔
	 * 
	 * @Title: getTimeInterval
	 * @Description: TODO
	 * @param @param time
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getTimeInterval(int time) {
		String r;
		if (time <= 60) {
			r = time + "秒";
		} else if (time > 60 && time < 3600) {
			r = time / 60 + "分";
			if (time % 60 != 0) {
				r = r + time % 60 + "秒";
			}
		} else {
			r = time / 3600 + "小时";

			time = time - time / 3600 * 3600;

			r = r + time / 60 + "分";

			if (time % 60 != 0) {
				r = r + time % 60 + "秒";
			}
		}

		return r;
	}
	/**
	 * 
	* @Title: getOldDate 
	* @Description: get固定天数以前的时间
	* @param @param days
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getOldDate(int days){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date().getTime()-days*24*60*60*1000);

	}
	
	/** 
     * 得到几天前的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return now.getTime();  
    }    
    /** 
     * 得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
    
    /**
     * yyyy-MM-dd HH:mm
     */
    public static String getNow(){
       return DateUtil.toDefineString(new Date(),DateUtil.maskC);
    }
}
