package com.javaapi.test.spring.spring.pattern.event.custom.annotation;

import com.javaapi.test.spring.spring.pattern.event.custom.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/11/10
 */
@Component
public class CustomEventListener {


    @EventListener
    public void listenter(CustomEvent event) {
        System.out.println("annotation event = " + event.getData());

    }
}
