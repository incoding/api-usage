package com.javaapi.test.testUtil.opensource.guava.range;

import org.junit.Test;

import com.google.common.collect.Range;

public class TestRange {
	/**
	 * guava 相对来说看起来强大一些 http://www.cnblogs.com/peida/p/Guava_Range.html
	 */
	@Test
	public void range() {
		System.out.println("open:" + Range.open(1, 10));
		System.out.println("closed:" + Range.closed(1, 10));
		System.out.println("closedOpen:" + Range.closedOpen(1, 10));
		System.out.println("openClosed:" + Range.openClosed(1, 10));
		System.out.println("greaterThan:" + Range.greaterThan(10));
		System.out.println("atLeast:" + Range.atLeast(10));
		System.out.println("lessThan:" + Range.lessThan(10));
		System.out.println("atMost:" + Range.atMost(10));
		System.out.println("all:" + Range.all());
		System.out.println("closed:" + Range.closed(10, 10));
		System.out.println("closedOpen:" + Range.closedOpen(10, 10));
		// 会抛出异常
		System.out.println("open:" + Range.open(10, 10));

	}

	/**
	 * guava
	 */
	@Test
	public void practice() {
		Range<Integer> r = Range.closed(1, 12);
		Range<Integer> r2 = Range.closed(11, 12);
		System.out.println(r.encloses(r2));
	}

	@Test
	public void apacheRange() {
		org.apache.commons.lang3.Range<Integer> r = org.apache.commons.lang3.Range
				.between(1, 12);
		org.apache.commons.lang3.Range<Integer> r2 = org.apache.commons.lang3.Range
				.between(11, 12);
		System.out.println(r.containsRange(r2));
	}
}
