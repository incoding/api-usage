package com.javaapi.test.concurrent.lock.shareAndExclusive.exclusive;

import java.util.Collection;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Mutex {
    // 静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {
        // 是否处于占用状态
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
        // 当状态为0的时候获取锁
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        // 释放锁，将状态设置为0
        protected boolean tryRelease(int releases) {
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }
    // 仅需要将操作代理到Sync上即可
    private final Sync sync = new Sync();

    //获取等待的线程
    public Collection<Thread> getQueuedThreads(){
        return sync.getQueuedThreads();
    }

    //独占锁的操作接口
    public void lock() {//获取锁
        sync.acquire(1);
    }

    public void unlock() {//释放锁
        sync.release(1);
    }
}