
package com.javaapi.test.application.log.log.log4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog4j {
	private static transient Logger	logger	= LoggerFactory
												.getLogger(TestLog4j.class);



    @Test
	public void testLog4jlogger() {
		logger.info("this is log4j style");
		logger.info("test replace in {}", "log4j");
		logger.info("nihao");
	}
	
	/**
	 * 异常不在占位符中,无论多少个占位符都会打印堆栈</br>
	 * 记住，别把异常放进占位符号里就可以打印完整堆栈
	 */
	@Test
	public void testSlf4jException() {
		logger.info("test replace in {}","exception", new RuntimeException("sss"));
	}
	/**
	 * 异常在占位符中,1个占位符号可以正确执行
	 */
	@Test
	public void testSlf4jException1() {
		logger.info("test replace in {}", new RuntimeException("sss"));
	}
	/**
	 * 异常在占位符中,2个占位符号以及以上,不会打印堆栈
	 */
	@Test
	public void testSlf4jException2() {
		logger.info("test replace in {} {}","exception", new RuntimeException("sss"));
	}
	@Test
	public void testSlf4jException3() {
	}
	
}
