package com.javaapi.test.spring.spring.pattern.event.custom.nomal;

import com.javaapi.test.spring.spring.pattern.event.custom.CustomEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/11/10
 */
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {


    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("event = " + event.getData());

    }
}
