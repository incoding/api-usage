package com.javaapi.test.buisness.pattern.ext.proxy;

/**
 * Created by user on 2019/8/21
 */
public class RealSubject implements Subject {
    @Override
    public void buyMac() {
        System.out.println("买一台Mac");
    }
}
