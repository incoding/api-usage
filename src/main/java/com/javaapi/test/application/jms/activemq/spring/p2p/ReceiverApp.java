package com.javaapi.test.application.jms.activemq.spring.p2p;

import java.util.concurrent.TimeUnit;

import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;
import org.junit.Test;

/**
 * 
 *http://www.cnblogs.com/huang0925/p/3558690.html
 */
public class ReceiverApp {

    @Test
    public void test() {
        String path = "file:" + ReceiverApp.class.getResource("").getPath();
        String string = path + "springJMSConfiguration.xml";
        String string2 = path + "springJMSReceiver.xml";
        FileSystemXmlApplicationContext classPathXmlApplicationContext = new FileSystemXmlApplicationContext(
                new String[] { string, string2 });
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}