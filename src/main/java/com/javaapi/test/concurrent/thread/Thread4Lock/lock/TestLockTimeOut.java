package com.javaapi.test.concurrent.thread.Thread4Lock.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  使用带超时的锁避免死锁
 */
public class TestLockTimeOut {
    @Test
    public void test() {
        final ReentrantLock lock = new ReentrantLock(); // 参数默认false，不公平锁
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程1尝试获取锁");
                    lock.lock(); // 如果被其它资源锁定，会在此等待锁释放，达到暂停的效果
                    System.out.println("线程1获取锁");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    print("线程1");
                    // 操作
                } finally {
                    System.out.println("线程1 释放锁");
                    lock.unlock();
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程2尝试获取锁");
                    if (lock.tryLock(3, TimeUnit.SECONDS)) {
                        System.out.println("线程2获取锁");
                        print("线程2");
                    } else {
                        System.out.println("线程2获取锁失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("线程2 释放锁");
                    // 会抛出以下异常,IllegalMonitorStateException - 如果当前线程不是此对象监视器的所有者。
                    lock.unlock();
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void print(String name) {
        System.out.println(Thread.currentThread().getName());
    }
}
