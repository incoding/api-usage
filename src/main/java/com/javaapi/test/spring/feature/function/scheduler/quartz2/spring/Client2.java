package com.javaapi.test.spring.feature.function.scheduler.quartz2.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by user on 17/11/1.
 */
public class Client2 {
    public static void main(String[] args) throws BeansException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/javaapi/test/spring/feature/function/scheduler/quartz2/spring/applicationContext.xml");        QuartzManager quartzManager = (QuartzManager) ctx.getBean("quartzManager");
        try {
            System.out.println("【系统启动】开始(每1秒输出一次 job2)...");

            Thread.sleep(5000);
            System.out.println("【增加job1启动】开始(每1秒输出一次)...");
            quartzManager.addJob("test", "test", "test", "test", MyJob.class, "0/1 * * * * ?");

            Thread.sleep(5000);
            System.out.println("【修改job1时间】开始(每2秒输出一次)...");
            quartzManager.modifyJobTime("test", "test", "test", "test", "0/2 * * * * ?");

            Thread.sleep(10000);
            System.out.println("【移除job1定时】开始...");
            quartzManager.removeJob("test", "test", "test", "test");

            // 关掉任务调度容器
            // quartzManager.shutdownJobs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
