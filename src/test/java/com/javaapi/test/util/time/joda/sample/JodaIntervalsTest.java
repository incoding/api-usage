package com.javaapi.test.util.time.joda.sample;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.testng.collections.Lists;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * An interval in Joda-Time represents an interval of time from one millisecond instant to another instant
 * duration ,interval 之间的区别，duration的是持续时间，interval是时间间隔，举些例子吧，我被弄糊涂了</br>
 * http://zhidao.baidu.com/link?url=eZtAHGCL3EM3OrpBdzKj6LAWnxZSQkG7PzUqZ7BT347wuyuI_VKCv34Mz7j6XsC0OhmEhi2PP_cJa6dbSag86a</br>
 *隔一分钟打一次雷，每次雷持续响半分钟。</br>
一分钟就是interval，半分钟就是duratioin</br>


 https://stackoverflow.com/questions/2653567/joda-time-whats-the-difference-between-period-interval-and-duration

 */
public class JodaIntervalsTest {

	@Test
	public void test() {
		// interval from start to end
		DateTime start = new DateTime(2014, 1, 1, 0, 0, 0, 0);
		DateTime end = new DateTime(2015, 1, 1, 0, 0, 0, 0);
		Interval interval = new Interval(start, end);
		//---------
		dealInterval(interval);
	}

	private void dealInterval(Interval interval) {
		DateTime start = interval.getStart();
		DateTime end = interval.getEnd();
		Chronology chrono = interval.getChronology();
		Duration duration = interval.toDuration();
		Period period = interval.toPeriod();
		System.out.println(duration.getStandardDays());
		System.out.println(period.getDays());
	}
	@Test
	public void test1(){
		DateTime dateTime = new DateTime();
		DateTime dateTime2 = dateTime.minusMonths(1).withDayOfMonth(1);
		System.out.println("dateTime2 = " + dateTime2);
		Calendar calendar = dateTime2.toCalendar(Locale.getDefault());
		System.out.println("calendar = " + calendar);

		int days = Days.daysBetween(dateTime, dateTime2).getDays();
		days = Math.abs(days);
		for (int i = 0; i < days; i++) {
			DateTime tmp = dateTime2.plusDays(i);
			System.out.println("tmp = " + tmp);
		}


	}

	@Test
	public void testBetween(){
		DateTime now = new DateTime();
		DateTime old = now.minusMonths(1);
		System.out.println("dateTime2 = " + Days.daysBetween(now, old).getDays());
		System.out.println("dateTime2 = " + Days.daysBetween(old, now).getDays());
	}

	@Test
	public void testBetween2(){
		DateTime now = new DateTime().withTimeAtStartOfDay();
		DateTime old = now.plusDays(3).withTimeAtStartOfDay();

		DateTime now2 = new DateTime().withTimeAtStartOfDay();
		DateTime old2 = now2.plusDays(1).withTimeAtStartOfDay();



		Interval gap = overlap(now, old, now2, old2);
		System.out.println("overlap = " + gap);
	}

	@Test
	public void testBetween3(){
		Interval gap2 = overlap(getDateTime("2019-04-08"), getDateTime("2019-04-15"), getDateTime("2019-04-05"), getDateTime("2019-04-07"));
		System.out.println("overlap = " + gap2);
		Interval gap3 = overlap(getDateTime("2019-04-08"), getDateTime("2019-04-15"), getDateTime("2019-04-06"), getDateTime("2019-04-10"));
		System.out.println("overlap = " + gap3);
		Interval gap4 = overlap(getDateTime("2019-04-08"), getDateTime("2019-04-15"), getDateTime("2019-04-09"), getDateTime("2019-04-10"));
		System.out.println("overlap = " + gap4);
		Interval gap6 = overlap(getDateTime("2019-04-08"), getDateTime("2019-04-15"), getDateTime("2019-04-09"), getDateTime("2019-04-17"));
		System.out.println("gap6 = " + gap6);
		Interval gap7 = overlap(getDateTime("2019-04-08"), getDateTime("2019-04-15"), getDateTime("2019-04-16"), getDateTime("2019-04-18"));
		System.out.println("gap6 = " + gap7);
		Interval gap8 = overlap(getDateTime("2019-04-08"), getDateTime("2019-04-15"), getDateTime("2019-04-05"), getDateTime("2019-04-18"));
		System.out.println("gap8 = " + gap8);
	}
	@Test
	public void testBetween4(){
		Interval overlap = overlap(getDateTime("2019-03-01"), getDateTime("2019-05-01"), getDateTime("2019-04-01"), getDateTime("2019-04-30"));
		List<String> days = getDays(overlap, "0110001");
		days.stream().forEach(System.out::println);
	}

	private List<String> getDays(Interval interval, String rule) {
		List<String> dayResult = Lists.newArrayList();
		if (interval == null) {
			return dayResult;
		}
		DateTime start = interval.getStart();
		int days = Days.daysIn(interval).getDays();
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyy/MM/dd");
		for (int i = 0; i < days; i++) {
			DateTime dateTime = start.plusDays(i);
			int dayOfWeek = dateTime.getDayOfWeek();
			if (hasDay(rule, dayOfWeek)) {
				dayResult.add(dateTime.toString(format));
			}
		}
		return dayResult;
	}

	private boolean hasDay(String rule, int weekIndex) {
		if (weekIndex == 7){
			weekIndex = 0;
		}
		String flag = new String(new char[]{rule.charAt(weekIndex)});
		if ("1".equals(flag)){
			return true;
		}
		return false;
	}

	private DateTime getDateTime(String str) {
		org.joda.time.format.DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
		return DateTime.parse(str, format);
	}


	private Interval overlap(DateTime now, DateTime old, DateTime now2, DateTime old2) {
		Interval interval = new Interval(now, old);
		Interval interval2 = new Interval(now2, old2);
		Interval gap = interval.overlap(interval2);

		return gap;
	}

	@Test
	public void test2(){
		Calendar calendar = Calendar.getInstance();

		DateTime dateTime = new DateTime(calendar);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.DAY_OF_MONTH, 0);
		DateTime dateTime2 = new DateTime(calendar2);

		int days = Days.daysBetween(dateTime, dateTime2).getDays();
		System.out.println("days = " + Math.abs(days));
	}

	@Test
	public void test3(){
		DateTime dateTime = new DateTime(2017,12,31,0,0);
//		DateTime start = dateTime.withDayOfMonth(1);
//		int days = Days.daysBetween(start, dateTime).getDays()+1;
//		System.out.println("days = " + days);
		int days = dateTime.dayOfMonth().get();
		for (int i = days - 1; i >= 0; i--) {
			String dateKey = dateTime.plusDays(-i).toString("yyyy-MM-dd");
			System.out.println("dateKey = " + dateKey);
		}

	}
}
