package com.javaapi.test.buisness.concurrent.thread.waitnotify.condition.sample1;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Client {


    /**
     * 当前线程收到signal后，然后获取到锁后才会从await返回
     */
    @Test
    public void test(){
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * signal 唤醒其他线程,但是前提是当前线程要获取到锁
     */
    @Test
    public void testSignal() {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        try {
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
