package com.javaapi.test.spring.spring.pattern.event.custom.annotation;

import com.javaapi.test.spring.spring.pattern.event.custom.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/11/10
 */
@Component
@EnableAsync
public class ReceiveCustomListener {


    @EventListener
    public void listenter(CustomEvent event) {
        System.out.println("ReceiveCustomListener annotation event = " + event.getData());
    }

    @EventListener(condition = "#event.data == 'nihao'")
    public void listenterCondition(CustomEvent event) {
        System.out.println("ReceiveCustomListener listenterCondition annotation event = " + Thread.currentThread().getName());
        System.out.println("ReceiveCustomListener listenterCondition annotation event = " + event.getData());
    }

    @EventListener(condition = "#event.data == 'nihao'")
    @Async
    public void listenerAsync(CustomEvent event) {
        System.out.println("ReceiveCustomListener listenerAsync annotation event =" + Thread.currentThread().getName());
        System.out.println("ReceiveCustomListener listenerAsync annotation event = " + event.getData());
    }

}
