package com.javaapi.test.spring.spring.pattern.event.buildin;

import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * refer https://www.jianshu.com/p/d0c8843aecc9
 */
public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("com/javaapi/test/spring/spring/pattern/event/buildin/applicationContext.xml");

            // Let us raise a start event.
            context.start();

            HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

            obj.getMsg();

            // Let us raise a refresh event
            context.refresh();

            // Let us raise a stop event.
            context.stop();
        } catch (BeansException e) {
            if (context != null) {
                context.close();
            }
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}