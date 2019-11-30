package com.javaapi.test.spring.spring.pattern.event.buildin;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class CRefreshedEventHandler implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        System.out.println("ContextRefreshedEvent received");
    }

}