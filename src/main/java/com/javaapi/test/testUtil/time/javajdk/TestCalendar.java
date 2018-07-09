package com.javaapi.test.testUtil.time.javajdk;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestCalendar extends  TestParent{

	@Test
	public void test() {
		SimpleDateFormat sd = new SimpleDateFormat("u");
		Calendar instance = Calendar.getInstance();
		System.out.println(sd.format(instance.getTime()));
		System.out.println("-----------");
		instance.add(Calendar.DAY_OF_WEEK, 1);
		System.out.println(sd.format(instance.getTime()));
	}
	@Test
	public void testWeekDesc() {
		SimpleDateFormat sd = new SimpleDateFormat("E",Locale.CHINESE);
		String format = sd.format(new Date());
		System.out.println(format);
	}
	/**
	 * 原始得 instance.get(Calendar.DAY_OF_WEEK)</br> 星期天是1,星期六是7</br>
	 */
	@Test
	public void testOrigin() {
		Calendar instance = Calendar.getInstance();
		String day = String.valueOf(instance.get(
                Calendar.DAY_OF_WEEK) - 1);
		System.out.println(day);
	}

	/**
	 *
	 */
	@Test
	public void testTimeInMili() {
		long timeInMillis = Calendar.getInstance().getTimeInMillis();
		System.out.println("time = " + timeInMillis);
		long time = System.currentTimeMillis();
		System.out.println("time = " + time);
	}


	/**
	 * 凌晨俩点再更新key
	 */
	@Test
	public void testSample1() {
		Calendar instance = Calendar.getInstance();
		// 凌晨2点后再更新key
		instance.set(Calendar.HOUR_OF_DAY, instance.get(Calendar.HOUR_OF_DAY) - 11);
		Date time = instance.getTime();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
		String format = simpleDateFormat.format(time);
		System.out.println("format = " + format);
	}

	/**
	 * 凌晨俩点再更新key
	 */
	@Test
	public void testSample2() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		try {
			Date parse = simpleDateFormat.parse("19:40");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(parse);
			Calendar instance = Calendar.getInstance();
			instance.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY));
			instance.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE));
			System.out.println("parse = " + instance.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 凌晨俩点再更新key
	 */
	@Test
	public void testSample3() {
		String s = "2017-08-25 17:44:55";
		String[] split = s.split(" ");
		System.out.println("split = " + split[0]);

	}
	@Test
	public void testSample4(){
		SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Integer dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		String upperRecordDate = formatYYYYMMDD.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH,1);
		String lowerRecordDate = formatYYYYMMDD.format(calendar.getTime());
		System.out.println("lowerRecordDate = " + lowerRecordDate);
		System.out.println("upperRecordDate = " + upperRecordDate);
		for (int i = 1; i < dayOfMonth; i++) {
			calendar.set(Calendar.DAY_OF_MONTH, i);
			String day = formatYYYYMMDD.format(calendar.getTime());
			System.out.println("day = " + day);
		}
	}
	@Test
	public void testSample5(){
		SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Integer dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		String upperRecordDate = formatYYYYMMDD.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH,0);
		String lowerRecordDate = formatYYYYMMDD.format(calendar.getTime());
		for (int i = 0; i < 20; i++) {
			calendar.set(Calendar.DAY_OF_MONTH, i);
			String format = formatYYYYMMDD.format(calendar.getTime());
//			System.out.println("format = " + format);
		}


		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_MONTH, 0);
		String format = formatYYYYMMDD.format(instance.getTime());

		System.out.println(" " + format);
	}
	@Test
	public void testSample6(){
		Calendar startDay = Calendar.getInstance();
		startDay.set(Calendar.AM_PM, Calendar.AM);
		startDay.set(Calendar.HOUR, 0);
		startDay.set(Calendar.MINUTE, 0);
		startDay.set(Calendar.SECOND, 0);
		startDay.add(Calendar.YEAR, -1);
		startDay.add(Calendar.DATE, 5);

		Date time = startDay.getTime();
		String format = DateFormatUtils.format(time, "yyyy-MM-dd HH:mm:ss");
		System.out.println("format = " + format);

	}
	@Test
	public void testSample7(){
		Calendar nextDay = Calendar.getInstance();
		nextDay.set(Calendar.AM_PM, Calendar.AM);
		nextDay.set(Calendar.HOUR, 0);
		nextDay.set(Calendar.MINUTE, 0);
		nextDay.set(Calendar.SECOND, 0);


		nextDay.add(Calendar.YEAR, -1);
		nextDay.add(Calendar.DATE, 25 + 1);

		Date time = nextDay.getTime();
		String format = DateFormatUtils.format(time, "yyyy-MM-dd HH:mm:ss");
		System.out.println("format = " + format);

	}

}
