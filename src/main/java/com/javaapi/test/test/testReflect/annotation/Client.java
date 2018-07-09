package com.javaapi.test.test.testReflect.annotation;

import org.junit.Test;

/**
 * Created by user on 16/8/3.
 */
public class Client {
    @Test
    public void test() {
        SuperClass<Integer> integerStringPeople = new People<>();
        Class<? extends SuperClass> aClass = integerStringPeople.getClass();
    }
}
