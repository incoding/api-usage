package com.javaapi.test.util.math.controlsample;

import java.util.concurrent.Semaphore;

class FooBarSemaphore {
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);
    private int n;

    public FooBarSemaphore(int n) {
        this.n = n;
    }


    public static void main(String[] args) {
        FooBarSemaphore fooBar = new FooBarSemaphore(10);

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

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}