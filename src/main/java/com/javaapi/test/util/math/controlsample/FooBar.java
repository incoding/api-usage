package com.javaapi.test.util.math.controlsample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private Lock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private Boolean fooBoolean = true;
    private int n;

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);

        new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                System.out.println("foobar = error");
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.println("foo");

                });
            } catch (InterruptedException e) {
                System.out.println("foo = error");
            }
        }).start();


        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
        }
    }

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (!fooBoolean) {
                    fooCondition.await();
                }

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooBoolean = false;
                barCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (fooBoolean) {
                    barCondition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooBoolean = true;
                fooCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}