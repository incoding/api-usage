package com.javaapi.test.buisness.concurrent.lock1block;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestLockSupport {


    private Object blocker = new Object();

    /**
     * park需要与unpark一起使用
     */
    @Test
    public void testBlock() {
        Thread thread = new Thread(() -> {
            System.out.println("before park");
            LockSupport.park(blocker);
            System.out.println("after park");
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before unpark");
        LockSupport.unpark(thread);
        System.out.println("after unpark");
    }

    /**
     * LockSupport里park被中断不会直接抛异常的，需要自己判断标识位然后自行抛出异常
     */
    @Test
    public void testInterrupt() {
        Thread thread = new Thread(() -> {
            System.out.println("before park");
            LockSupport.park(blocker);
            System.out.println("is interrupt=" + Thread.interrupted());
            System.out.println("after park");
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before interrupt");
        thread.interrupt();
        System.out.println("after interrupt");
    }

    /**
     * park一段时间
     */
    @Test
    public void testTimeOut() {
        Thread thread = new Thread(() -> {
            System.out.println("before park");
            long now = System.currentTimeMillis();
            LockSupport.parkNanos(blocker, 3 * 1000 * 1000 * 1000 * 1000);
            System.out.println("消耗时间=" + (System.currentTimeMillis() - now));
            System.out.println("after park");
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * park到时间点
     */
    @Test
    public void testTimeOutUntil() {
        Thread thread = new Thread(() -> {
            System.out.println("before park");
            long now = System.currentTimeMillis();
            long endPoint = now + 3000;
            LockSupport.parkUntil(blocker, endPoint);
            System.out.println("消耗时间=" + (System.currentTimeMillis() - now));
            System.out.println("after park");
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
