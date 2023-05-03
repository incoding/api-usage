package com.javaapi.test.spring.spring.pattern.event.custom.annotation;

import com.javaapi.test.spring.spring.pattern.event.custom.CustomEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2019/11/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Autowired
    private ApplicationContext applicationContext;


    @Autowired
    private ApplicationEventMulticaster applicationEventMulticaster;


    @Test
    public void test() {
        System.out.println("push thread " + Thread.currentThread().getName());
        applicationContext.publishEvent(new CustomEvent(this, "custom data"));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMulticaster() {
        System.out.println("push thread=" + Thread.currentThread().getName());
        applicationEventMulticaster.multicastEvent(new CustomEvent(this, "custom data"));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCondition() {
        applicationContext.publishEvent(new CustomEvent(this, "nihao"));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 默认情况下，监听事件都是同步执行的。在需要异步处理时，可以在方法上加上@Async进行异步化操作。
     * 此时，可以定义一个线程池，同时开启异步功能，加入@EnableAsync。
     */
    @Test
    public void testAsync() {
        String name = Thread.currentThread().getName();
        System.out.println("name = " + name);
        applicationContext.publishEvent(new CustomEvent(this, "nihao"));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
