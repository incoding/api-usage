package com.javaapi.test.util.math.format;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Test;

public class TestNumberRoundUp {



	/**
	 * 具体计算,可以计算之后再进行四舍五入. precision是指的是整个数字精确后的长度，而非理解的精度（scale）。
	 */
	@Test
	public void testJiSuan() {
		System.out.println(new BigDecimal(1332.1222, new MathContext(7,
				RoundingMode.CEILING)));
		System.out.println(new BigDecimal(1332.1222, new MathContext(8,
				RoundingMode.CEILING)));
		System.out.println(new BigDecimal(1332.1222, new MathContext(9,
				RoundingMode.CEILING)));
		System.out.println(new BigDecimal(1332.1222, new MathContext(10,
				RoundingMode.CEILING)));

	}

	/**
	 * 正确对数字进行四舍五入得方式.对数字转字符串四舍五入参考numberformat
	 */
	@Test
	public void testHalfUp() {
//		System.out.println("---------------------");
//		System.out.println(new BigDecimal(1332.124));
//		// 原样获取值
//		System.out.println(BigDecimal.valueOf(1332.124));
//		System.out.println(BigDecimal.valueOf(1332.124).setScale(2,
//				RoundingMode.HALF_UP));
//		System.out.println(new BigDecimal(1332.125).setScale(2,
//				RoundingMode.HALF_UP));
//		BigDecimal bigDecimal = new BigDecimal("1332.525");
//		System.out.println("bigDecimal = " + bigDecimal);
//		BigDecimal bigDecimal1 = bigDecimal.setScale(0, RoundingMode.HALF_UP);
//		System.out.println("bigDecimal = " + bigDecimal1);
		System.out.println(new BigDecimal("1300.525").setScale(-1,
				RoundingMode.HALF_UP).toPlainString());
	}

	@Test
	public void testRoundUp() {
		BigDecimal bigDecimal = new BigDecimal("1332.45");

//		BigDecimal bigDecimal1 = bigDecimal.setScale(0, RoundingMode.UP);
		BigDecimal bigDecimal1 = bigDecimal.setScale(0, BigDecimal.ROUND_UP);
		System.out.println("bigDecimal1 = " + bigDecimal1.toPlainString());
		System.out.println("bigDecimal1 = " + "56.50".contains(".50"));
	}

	/**
	 * 逢一进一
	 */
	@Test
	public void testRoundUp3() {
		BigDecimal bigDecimal = new BigDecimal("1691");

//		BigDecimal bigDecimal1 = bigDecimal.setScale(0, RoundingMode.UP);
		BigDecimal bigDecimal1 = bigDecimal.setScale(-1, BigDecimal.ROUND_UP);
		System.out.println("bigDecimal1 = " + bigDecimal1.toPlainString());
		System.out.println("bigDecimal1 = " + "56.50".contains(".50"));
	}

	@Test
	public void testRoundUp4() {
		BigDecimal bigDecimal = new BigDecimal("1691.2");
		BigDecimal bigDecimal1 = bigDecimal.setScale(-1, BigDecimal.ROUND_HALF_UP);
		System.out.println("bigDecimal1 = " + bigDecimal1.toPlainString());
	}



	/**
	 * bigdecimal 原生的四舍五入
	 */
	@Test
	public void testRoundUp2(){
		BigDecimal bigDecimal = new BigDecimal("5.63");
		bigDecimal = bigDecimal.setScale(1,RoundingMode.DOWN);
		System.out.println("bigDecimal = " + bigDecimal);
	}
	@Test
	public void testRoundUp5(){
		BigDecimal bigDecimal = new BigDecimal("5.6355");
		System.out.println("bigDecimal = " + bigDecimal.setScale(2,RoundingMode.HALF_UP).toPlainString());
	}

}
