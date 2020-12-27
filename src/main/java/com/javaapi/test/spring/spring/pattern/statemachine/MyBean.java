package com.javaapi.test.spring.spring.pattern.statemachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by user on 2020/12/20.
 */
@WithStateMachine
public class MyBean {

    @OnTransition(target = "STATE1")
    void toState1() {
        System.out.println("true = STATE1");
    }

    @OnTransition(target = "STATE2")
    void toState2() {
        System.out.println("true = STATE2");
    }
}