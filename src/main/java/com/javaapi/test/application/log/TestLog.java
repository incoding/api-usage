package com.javaapi.test.application.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
    private Logger logger = LoggerFactory.getLogger(getClass()); 
    /**
     */
    @Test
    public void testLog4j() throws Exception {
        logger.info("nihao");
    }

}
