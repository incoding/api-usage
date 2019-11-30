package com.javaapi.test.spring.spring.pattern.event.buildin;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class CCloseEventHandler implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent arg0) {
        System.out.println("ContextClosedEvent Received");
    }


}