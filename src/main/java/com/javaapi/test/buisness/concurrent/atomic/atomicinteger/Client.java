package com.javaapi.test.buisness.concurrent.atomic.atomicinteger;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    @Test
    public void test() {
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.incrementAndGet();
        System.out.println("i = " + i);
    }
}
