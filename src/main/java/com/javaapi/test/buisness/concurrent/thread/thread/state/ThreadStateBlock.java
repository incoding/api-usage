package com.javaapi.test.buisness.concurrent.thread.thread.state;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 1 只有等待进入synchronize 线程状态才是 block
 */
public class ThreadStateBlock {
    @Test
    public void test() {
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    System.out.println("子线程获取锁");
                    try {
                        TimeUnit.HOURS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程释放锁");
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程尝试获取锁");
        synchronized (o) {
            System.out.println("主线程获取锁");
        }
    }
}
