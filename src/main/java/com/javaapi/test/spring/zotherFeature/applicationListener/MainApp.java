package com.javaapi.test.spring.zotherFeature.applicationListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("com/javaapi/test/spring/zotherFeature/applicationListener/applicationContext.xml");

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

    }
}