package com.javaapi.test.util.time.joda.sample;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

/**Partial 只是个概念,没有具体类.只代表时间中的部分字段.
 * 比如说20141212,则2014部分就算是partial
 * @author hncw
 *
 */
public class JodaPartialTest {
	@Test
	public void test() {
		// setup objects
		LocalDate date = new LocalDate(2004, 12, 25);
		LocalTime time = new LocalTime(12, 20);

		int year = date.getYear();  // returns 2004
//		int hour = time.getHour();  // returns 12
//		String monthStr = date.month().getAsText();  // returns 'December'
	}
	@Test
	public void test2() {
		LocalDate date = new LocalDate(2004, 12, 25);
		LocalTime time = new LocalTime(12, 20);

		// merge, resulting in 2004-25-12T12:20 (default time zone)
		DateTime someDT = date.toDateTime(time);

		LocalDate date2 = new LocalDate(someDT);

	}
}
