package com.javaapi.test.spring.spring.feature.function.scheduler.quartz2.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by user on 17/11/1.
 */
public class Client {
    public static void main(String[] args) throws BeansException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/javaapi/test/spring/spring/feature/function/scheduler/quartz2/spring/applicationContext.xml");
        QuartzManager quartzManager = (QuartzManager) ctx.getBean("quartzManager");
        try {
            System.out.println("【系统启动】开始(每1秒输出一次)...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
