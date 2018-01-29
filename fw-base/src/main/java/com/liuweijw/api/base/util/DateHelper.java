package com.liuweijw.api.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 * @author liuweijw
 */
public class DateHelper extends DateUtils {

	/**
	 * 日期格式
	 */
	private static final String[] PARSE_PATTERNS = { "yyyy-MM-dd",
			"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
			"yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyyMMdd",
			"yyyyMMddHHmmss", "yyyyMMddHHmm", "yyyyMM" };

	/**
	 * 日期格式
	 */
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * 日期时间格式
	 */
	private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期时间格式
	 */
	public static final String DEFAULT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 *
	 * @return the date
	 */
	public static String getDate() {
		return getDate(DEFAULT_DATE_FORMAT);
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 *
	 * @param pattern
	 *            the pattern
	 * @return the date
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 *
	 * @param date
	 *            the date
	 * @param pattern
	 *            the pattern
	 * @return the string
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, DEFAULT_DATE_FORMAT);
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 *
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, DEFAULT_DATETIME_FORMAT);
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 *
	 * @return the time
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 *
	 * @return the date time
	 */
	public static String getDateTime() {
		return formatDate(new Date(), DEFAULT_DATETIME_FORMAT);
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 *
	 * @return the year
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 *
	 * @return the month
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 *
	 * @return the day
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 *
	 * @return the week
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyyMMdd", "yyyyMMddHHmmss",
	 * "yyyyMMddHHmm", "yyyyMM" }
	 *
	 * @param str
	 *            the str
	 * @return the date
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), PARSE_PATTERNS);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 *
	 * @param date
	 *            对比日期
	 * @return long long
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 *
	 * @param date
	 *            对比日期
	 * @return long long
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 *
	 * @param date
	 *            对比日期
	 * @return long long
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 *
	 * @param timeMillis
	 *            毫秒数
	 * @return 天, 时:分:秒.毫秒
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = timeMillis / (60 * 60 * 1000) - day * 24;
		long min = timeMillis / (60 * 1000) - day * 24 * 60 - hour * 60;
		long s = timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min
				* 60;
		long sss = timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60
				* 1000 - min * 60 * 1000 - s * 1000;
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "."
				+ sss;
	}

	/**
	 * 获取两个日期之间的天数
	 *
	 * @param before
	 *            开始日期
	 * @param after
	 *            结束日期
	 * @return 天数 distance of two date
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (double) (1000 * 60 * 60 * 24);
	}

	/**
	 * 获取东八区当前时间
	 *
	 * @return Date est 8 date
	 */
	public static Date getEst8Date() {
		TimeZone tz = TimeZone.getTimeZone("GMT+8:00");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				DEFAULT_DATETIME_FORMAT);
		dateFormat.setTimeZone(tz);
		return parseDate(dateFormat.format(date));
	}

	/**
	 * 取得指定日期所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	/**
	 * 取得指定日期所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	/**
	 * 取得指定日期所在月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 获得指定日期step月份之后的所在月第一天
	 *
	 * @param date
	 * @param step
	 * @return String
	 */
	public static Date getFirstDayOfStepMonth(Date date, Integer step) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + step);
		return getFirstDayOfMonth(c.getTime());
	}

	/**
	 * 获得指定日期step月份之后的日期
	 *
	 * @param date
	 * @param step
	 * @return String
	 */
	public static Date getDayOfStepMonth(Date date, Integer step) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + step);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取指定日期setp年份的日期
	 * 
	 * @param regDate
	 * @param step
	 * @return
	 */
	public static Date getFirstDayOfStepYear(Date regDate, int step) {
		Calendar c = new GregorianCalendar();
		c.setTime(regDate);
		c.set(Calendar.YEAR, c.get(Calendar.YEAR) + step);
		return c.getTime();
	}

	/**
	 * 获得指定日期step月份之后的所在月最后第一天的日期
	 *
	 * @param date
	 * @param step
	 * @return String
	 */
	public static Date getLastDayOfStepMonth(Date date, Integer step) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + step);
		return getLastDayOfMonth(c.getTime());
	}

	/**
	 * 取得指定日期所在月的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	/**
	 * 获取当月的最大天数
	 *
	 * @param date
	 * @return int
	 */
	public static int getDayOfMonth(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DATE);
	}

	public static String formatCurrentDate(String pattern) {
		return DateHelper.formatDate(new Date(), pattern);
	}

	/**
	 * 将日期型数据转化为字符串型
	 * 
	 * @param formatDate
	 * @param pattern
	 * @return
	 */
	public static String formatDateToStr(Date formatDate, String pattern) {
		if (null == formatDate) {
			return null;
		}
		if (pattern == null || pattern.equals("")) {
			pattern = DEFAULT_DATETIME_FORMAT;
		}
		DateFormat format = null;
		format = new SimpleDateFormat(pattern);
		String dayBefore = format.format(formatDate.getTime());
		return dayBefore;
	}

	public static String getAssignedDayWithPattern(Date date, String pattern,
			Integer step) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.DATE, step);
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(c.getTime());
	}

	public static Date getAssignedDayWithPattern(Date date, Integer step) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.DATE, step);
		return c.getTime();
	}

	public static Date formatDateWithString(String date, String pattern) {
		pattern = (pattern == null || pattern.equals("")) ? DEFAULT_DATETIME_FORMAT
				: pattern;
		DateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date formatDateWithString(String date) {
		return formatDateWithString(date, null);
	}

}
