package com.javaapi.test.application.log.log.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {
	private static transient Logger	logger	= LoggerFactory
												.getLogger(TestLogback.class);


    public static void main(String[] args) {
        logger.info("this is logback log");
        System.out.println("this is stdout log");
    }

    @Test
	public void test() {
		logger.info("this is {}", "logback");
	}

	@Test
	public void testLevel() {
		logger.trace("this is {}", "logback");
		logger.debug("this is {}", "logback");
		logger.info("this is {}", "logback");
		logger.warn("this is {}", "logback");
		logger.error("this is {}", "logback");
	}
    @Test
    public void testLogadditivity(){
        logger.info("this is {}", "logback");
    }

    @Test
    public void testParamNumber() {
        logger.error("this is {},{},{},{}", "logback","logback","logback","logback");
    }
}
