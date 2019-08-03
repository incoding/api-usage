package com.javaapi.test.buisness.concurrent.thread.Thread4Lock.deadlock;

/**
 * Created by user on 15/11/2.
 */
public class ClassB {
    public synchronized void b1(ClassA a) {
        String name = Thread.currentThread().getName();
        System.out.println("name = 进入B b1" + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("name = 试图访问A a2" + name);
        a.a2();
    }

    public synchronized void b2() {
        System.out.println("true = 进入B b2 ");
    }
}
