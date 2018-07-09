package com.javaapi.test.concurrent.thread.Thread4Lock.deadlock;

/**
 * Created by user on 15/11/2.
 */
public class ClassA {
    public synchronized void a1(ClassB b) {

        String name = Thread.currentThread().getName();
        System.out.println("name = 进入A a1" + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("name = 试图访问B b2" + name);
        b.b2();
    }

    public synchronized void a2() {
        System.out.println("true = 进入A a2 ");
    }
}
