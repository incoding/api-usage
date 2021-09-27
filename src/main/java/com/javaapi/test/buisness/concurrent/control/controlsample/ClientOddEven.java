package com.javaapi.test.buisness.concurrent.control.controlsample;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 2021/9/2.
 */
public class ClientOddEven {
    private boolean init = true;
    private ReentrantLock lock = new ReentrantLock();

    private Condition a = lock.newCondition();

    private Condition b = lock.newCondition();

    @Test
    public void test() {
        new ClientOddEven().invoke();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("args = 结束");
    }

    private void invoke() {
        Thread bThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    b.await();
                    if (i % 2 == 1) {
                        System.out.println("奇数=" + i);
                    }
                    a.signal();
                } catch (InterruptedException e) {
                    System.out.println("奇数 = 异常" + i);

                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        bThread.start();


        Thread aThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    if (!init) {
                        a.await();
                    }
                    if (i % 2 == 0) {
                        System.out.println("偶数" + i);
                    }

                    init = false;
                    b.signal();
                } catch (InterruptedException e) {
                    System.out.println("偶数 = 异常" + i);
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        aThread.start();
    }
}
