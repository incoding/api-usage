package com.javaapi.test.buisness.concurrent.control.waitnotify.condition.sample1;

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
     * 1 signal 唤醒其他线程,但是前提是当前线程要获取到锁
     * 2 调用完signal 后，并且调用signal的线程释放掉锁之后，其他被signal锁的线程才能获取到锁
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
