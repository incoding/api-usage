package com.javaapi.test.spring.spring.feature.function.applicationListener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent arg0) {
        System.out.println("ContextStartedEvent Received");
    }


}