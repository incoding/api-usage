package com.javaapi.test.util.time.joda.sample;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Test;

/**duration概念跟period概念类似;
 * 但是period只有指定了instant 才是准确得持续时间
 * @author hncw
 *
 */
public class JodaDurationTest {

	@Test
	public void test() {
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 2, 0, 0, 0, 0);

		// duration in ms between two instants
		Duration dur = new Duration(start, end);

		// calc will be the same as end
		DateTime calc = start.plus(dur);
		System.out.println(calc.toString());
	}
}
