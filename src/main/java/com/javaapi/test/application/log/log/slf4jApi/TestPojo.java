package com.javaapi.test.application.log.log.slf4jApi;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 18/4/9
 */
public class TestPojo {
    private static transient Logger logger	= LoggerFactory
            .getLogger(TestPojo.class);

    @Test
    public void testList(){
        logger.info("this is list ={}", Lists.newArrayList("nihao","222"));

    }

}
