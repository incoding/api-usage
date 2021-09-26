package com.javaapi.test.buisness.concurrent.atomic.atomicboolean;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class Client {
    @Test
    public void testBoolean() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        boolean expect = false;
        boolean update = true;
        boolean b = atomicBoolean.compareAndSet(expect, update);
        System.out.println("b = " + b);
    }
}
