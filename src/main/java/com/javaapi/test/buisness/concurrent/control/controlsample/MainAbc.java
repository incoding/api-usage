package com.javaapi.test.buisness.concurrent.control.controlsample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 2021/9/1.
 */
public class MainAbc {

    private volatile boolean init = true;

    private ReentrantLock lock = new ReentrantLock();

    private Condition a = lock.newCondition();

    private Condition b = lock.newCondition();

    private Condition c = lock.newCondition();


    public static void main(String[] args) {
        new MainAbc().invoke();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("args = 结束");
    }

    private void invoke() {

        Thread bThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        b.await();
                        System.out.println("B");
                        c.signal();
                    } catch (InterruptedException e) {
                        System.out.println("B = 异常");

                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        bThread.start();

        Thread cThread = new Thread(new Runnable() {
            public void run() {
                while (true) {

                    lock.lock();
                    try {
                        c.await();
                        System.out.println("C");
                        a.signal();
                    } catch (InterruptedException e) {
                        System.out.println("C = 异常");
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

            }
        });
        cThread.start();

        Thread aThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        if (!init) {
                            a.await();
                        }
                        System.out.println("A");
                        init = false;
                        b.signal();
                    } catch (InterruptedException e) {
                        System.out.println("A = 异常");
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        });
        aThread.start();


    }
}