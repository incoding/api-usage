package com.javaapi.test.testUtil.time.joda.sample;

import org.joda.time.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

/**
 * An interval in Joda-Time represents an interval of time from one millisecond instant to another instant
 * duration ,interval 之间的区别，duration的是持续时间，interval是时间间隔，举些例子吧，我被弄糊涂了</br>
 * http://zhidao.baidu.com/link?url=eZtAHGCL3EM3OrpBdzKj6LAWnxZSQkG7PzUqZ7BT347wuyuI_VKCv34Mz7j6XsC0OhmEhi2PP_cJa6dbSag86a</br>
 *隔一分钟打一次雷，每次雷持续响半分钟。</br>
一分钟就是interval，半分钟就是duratioin</br>

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
