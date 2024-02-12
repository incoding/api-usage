package com.javaapi.test.spring.spring.pattern.statemachinecolacup;

public interface TransitInfoListener<S,E> {
    S getFrom();
    E getEvent();
    S getTo();
}
