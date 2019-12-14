package com.javaapi.test.buisness.concurrent.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1  await内部有等待后释放锁, 唤醒后获取锁的逻辑 , 但是signal没有.
 * 2  await是将同步队列放入等待队列
 * 3  signal是将等待队列放入同步队列
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            // await内部有等待后释放锁, 唤醒后获取锁的逻辑
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

}
