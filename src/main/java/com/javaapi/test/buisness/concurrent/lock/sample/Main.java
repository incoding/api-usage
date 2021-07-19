package com.javaapi.test.buisness.concurrent.lock.sample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by user on 2021/6/22.
 */
public class Main {
    private static volatile boolean init = true;

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition a = lock.newCondition();

    private static Condition b = lock.newCondition();

    private static Condition c = lock.newCondition();


    public static void main(String[] args) {
        Thread firstThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }

                    try {
                        if (!init) {
                            a.await();
                        }
                        System.out.print("A");
                        init = false;
                        b.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }
        });
        firstThread.start();

        Thread secondThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }

                    try {
                        b.wait();
                        System.out.print("B");
                        c.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        secondThread.start();
        Thread thirdThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }

                    try {
                        c.await();
                        System.out.print("C");
                        a.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

            }
        });
        thirdThread.start();

    }
}
