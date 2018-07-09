package com.javaapi.test.application.log.log.slf4jApi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * http://my.oschina.net/pingpangkuangmo/blog/410224
 * http://qingfeng825.iteye.com/blog/1775326
 */
public class TestBridge {

    static {
//        LogManager.getLogManager().reset();
        // 没被注释得俩句就好使
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
//        Logger.getLogger("global").setLevel(Level.FINEST);
    }

    private static transient Logger logback = LoggerFactory
            .getLogger(TestBridge.class);

    private static transient Log jcl = LogFactory.getLog(TestBridge.class);
    private static transient java.util.logging.Logger jul = java.util.logging.Logger.getLogger(TestBridge.class.getName());
    private  transient org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(getClass());


    @Test
    public void testJclOverSlf4j(){
        logback.info("this is logback");
        jcl.info("this is jcl");
        jul.info("this is jul");
        log4j.info("this is log4j");
    }
}
