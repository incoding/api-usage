package com.javaapi.test.spring.spring.pattern.event.custom.nomal;

import com.javaapi.test.spring.spring.pattern.event.custom.CustomEvent;
import com.javaapi.test.spring.spring.pattern.event.custom.CustomOtherEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
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
    ApplicationContext applicationContext;

    @Test
    public void test() {
        applicationContext.publishEvent(new CustomEvent(this, "custom data"));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        ApplicationListener listener = (ApplicationListener) applicationContext.getBean("customEventListener");
        ApplicationEvent event = new CustomEvent(this, "custom data");
        listener.onApplicationEvent(event);

    }

    /**
     * 这么传会报错
     */
    @Test
    public void test3() {
        ApplicationListener listener = (ApplicationListener) applicationContext.getBean("customEventListener");
        listener.onApplicationEvent(new CustomOtherEvent(this, "2"));
    }


}
