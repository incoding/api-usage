package com.javaapi.test.buisness.concurrent.threadpool.ThreadPoolBlock;

import org.slf4j.Logger;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 参考http://my.oschina.net/flashsword/blog/114527 文章太老,不建议采用
 http://www.cnblogs.com/steeven/archive/2005/12/08/293219.html  文章太老,不建议采用
 */
public class BlockedThreadPoolExecutor extends ThreadPoolExecutor {
    Logger log = org.slf4j.LoggerFactory.getLogger(getClass());
    public BlockedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public BlockedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public BlockedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public BlockedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    private ReentrantLock pauseLock = new ReentrantLock();
    private Condition unpaused = pauseLock.newCondition();
    @Override
    public void execute(Runnable command) {
        pauseLock.lock();
        try {
            while (getPoolSize()==getMaximumPoolSize() && getQueue().remainingCapacity()==0)
                unpaused.await();
            super.execute(command);//放到lock外面的话，在压力测试下会有漏网的！
        } catch (InterruptedException e) {
            log.warn("失败", e);
        } finally {
            pauseLock.unlock();
        }
    }
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        try{
            pauseLock.lock();
            unpaused.signal();
        }finally{
            pauseLock.unlock();
        }
    }
}
