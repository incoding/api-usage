package com.javaapi.test.testUtil.math.number.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;

public class TestBigDemcial {
	/**
	 * 测试 减法
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		BigDecimal bigDecimal = new BigDecimal(-5);
		BigDecimal bigDecimal2 = new BigDecimal(10);
		BigDecimal subtract = bigDecimal2.subtract(bigDecimal);
		System.out.println(subtract);
	}

	/**
	 * 测试compare
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		BigDecimal bigDecimal = new BigDecimal(10000);
		BigDecimal bigDecimal2 = new BigDecimal(10);
		System.out.println(bigDecimal.compareTo(bigDecimal2));
	}
	
	/**
	 * 字符串格式不符合，会报错
	 * java.lang.NumberFormatException
	 */
	@Test
	public void testRegular() throws Exception {
		BigDecimal bigDecimal = new BigDecimal("100.22..00");
		System.out.println(bigDecimal);
	}

	/**
	 * 正确的double 转BigDecimal 方式1
	 * @throws Exception
	 */
	@Test
	public void RightDoubleToBigdecimal() throws Exception {
		double val = 10.08;
		BigDecimal value = new BigDecimal(String.valueOf(val));
		System.out.println(value);
	}

	/**
	 * 正确的double 转BigDecimal 方式2
	 * @throws Exception
	 */
	@Test
	public void RightDoubleToBigdecimal2() throws Exception {
		double val = 10.08;
		BigDecimal value = BigDecimal.valueOf(val);
		System.out.println(value);
	}

	/**
	 * 错误的 double转BigDecimal
	 * @throws Exception
	 */
	@Test
	public void WrongToBigdecimal() throws Exception {
		double val = 10.08;
		BigDecimal value = new BigDecimal(val);
		System.out.println(value);
	}

	/**
	 * 正确的比较
	 * @throws Exception
	 */
	@Test
	public void RightBigdecimalCompare() throws Exception {
		double val = 10.08;
		BigDecimal value = new BigDecimal(String.valueOf(val));
		BigDecimal value2 = BigDecimal.valueOf(val);
		System.out.println(value.equals(value2) );
		System.out.println(value.compareTo(value2));
	}

	/**
	 * 获取小数点位数
	 * @throws Exception
	 */
    @Test
    public void testScale() throws Exception {
        BigDecimal bigDecimal1 = new BigDecimal("0.04");
        System.out.println("bigDecimal = " + bigDecimal1.scale());

        BigDecimal bigDecimal = new BigDecimal("0.0004");
        System.out.println("bigDecimal = " + bigDecimal.scale());

        BigDecimal big = new BigDecimal("1");
        System.out.println("bigDecimal = " + big.scale());
    }

	/**
	 * 获取对应的负数
	 */
	@Test
	public void testNegate(){
		BigDecimal positive = new BigDecimal("123");
		BigDecimal negate = positive.negate();
		System.out.println("negate = " + negate);
	}

	@Test
	public void testToString() throws Exception {
		BigDecimal cost = new BigDecimal("220.0").multiply(new BigDecimal("5")).divide(new BigDecimal("100"));
		System.out.println("cost = " + cost);
		System.out.println("cost = " + cost.toPlainString());
		System.out.println("cost = " + cost.intValue());
	}
	@Test
	public void testToString2() throws Exception {
		BigDecimal cost = new BigDecimal("2200.0");
		System.out.println("cost = " + cost);
		System.out.println("cost.toPlainString() = " + cost.toPlainString());
		System.out.println("cost.intValue() = " + cost.intValue());
	}
}
