package com.javaapi.test.application.log.log.jul;

import org.junit.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Logger;

/**
 * http://wen-owen.iteye.com/blog/1473550
 * http://stackoverflow.com/questions/9117030/jul-to-slf4j-bridge
 */
public class Client {
    static {
//        LogManager.getLogManager().reset();
        // 没被注释得俩句就好使
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
//        Logger.getLogger("global").setLevel(Level.FINEST);
    }

    Logger logger = Logger.getLogger(getClass().getName());  //根据当前的class.getName()获得日志实例

    @Test
    public void test() {
        logger.info("nihao");  //用日志输出一条info级别的消息；
    }
}
