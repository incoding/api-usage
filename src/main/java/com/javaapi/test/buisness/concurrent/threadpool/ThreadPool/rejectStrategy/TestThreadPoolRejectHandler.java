package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.rejectStrategy;

import com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.queueStrategy.ThreadPoolTest;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by user on 16/12/12.
 * http://www.oschina.net/question/565065_86540
 */
public class TestThreadPoolRejectHandler extends ThreadPoolTest {

    /**
     *  AbortPolicy策略
     *  立刻抛出异常
     */
    @Test
    public void AbortPolicy() {
        ThreadPoolExecutor common = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(QUEUE_SIZE));
        common.setRejectedExecutionHandler( new ThreadPoolExecutor.AbortPolicy());
        checkEsStatus((ThreadPoolExecutor) common, QUEUE_SIZE, MAX_SIZE, REDUNDANT);
        System.out.println("done " );
    }
    /**
     *  CallerRunsPolicy策略
     *  主线程来运行
     */
    @Test
    public void CallerRunsPolicy() {
        ThreadPoolExecutor common = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(QUEUE_SIZE));
        common.setRejectedExecutionHandler( new ThreadPoolExecutor.CallerRunsPolicy());
        checkEsStatus((ThreadPoolExecutor) common, QUEUE_SIZE, MAX_SIZE, REDUNDANT);
        System.out.println("done " );

    }

    /**
     *  DiscardPolicy策略
     *  丢弃任务,没有任何反馈,就是空处理
     */
    @Test
    public void DiscardPolicy() {
        ThreadPoolExecutor common = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(QUEUE_SIZE));
        common.setRejectedExecutionHandler( new ThreadPoolExecutor.DiscardPolicy());
        checkEsStatus((ThreadPoolExecutor) common, QUEUE_SIZE, MAX_SIZE, REDUNDANT);
        System.out.println("done " );
    }

    /**
     *  DiscardOldestPolicy策略
     *
     *  将队列头的任务扔掉,然后把新任务放进队列头(这么不靠谱,估计没什么用处)
     */
    @Test
    public void DiscardOldestPolicy() {
        ThreadPoolExecutor common = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(QUEUE_SIZE));
        common.setRejectedExecutionHandler( new ThreadPoolExecutor.DiscardOldestPolicy());
        checkEsStatus((ThreadPoolExecutor) common, QUEUE_SIZE, MAX_SIZE, REDUNDANT);
        System.out.println("done " );
    }
    /**
     *  该例子为 如果队里满了(线程池不够了),则阻塞
     *  CallerRunsPolicy 主线程 调用runnable得run(当做普通方法调用,也就是会令主线程阻塞)
     * 这个例子的参考地址 http://www.importnew.com/10790.html
     * 另外的参考 ,1 自己实现了阻塞,没有使用queue的put操作2 但是比这个例子少了个对线程池 isShutDown的判断,所以作者发现有问题  http://my.oschina.net/flashsword/blog/114527   事实证明，除了JDK的CallerRunsPolicy方案，其他的方案都存在一个隐患：

     *
     *


     */
    @Test
    public void selfRejectPolicy() {
        ThreadPoolExecutor common = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(QUEUE_SIZE));
        common.setRejectedExecutionHandler(   new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                if (!executor.isShutdown()) {
                    try {
                        executor.getQueue().put(r);
                    } catch (InterruptedException e) {
                        // should not be interrupted
                    }
                }
            }
        });
        checkEsStatus((ThreadPoolExecutor) common, QUEUE_SIZE, MAX_SIZE, REDUNDANT);
        System.out.println("done " );
    }






}
