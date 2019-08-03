package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool4Sample.sample2;

import com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.queueStrategy.ThreadPoolTest;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPool里的功能
 */
public class TestThreadPoolFunctionSamle2 extends ThreadPoolTest {

    /**
     * queue 使用了 DelayedWorkQueue
     * <p>
     * <p>
     * scheduleWithFixedDelay的意思是当结束前一个执行后延迟的时间
     * <p>
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:21:16 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:21:24 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:21:32 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:21:40 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:21:48 CST 2017
     */
    @Test
    public void testScheduleWithFixedDelay() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newScheduledThreadPool(5);

        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("newSingleThreadScheduledExecutor = " + new Date());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.HOURS.sleep(24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如果执行时间比间隔时间大,那么 执行完了会立刻再执行.
     * <p>
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:19:47 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:19:52 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:19:57 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:20:02 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:20:07 CST 2017
     * newSingleThreadScheduledExecutor = Tue Jul 11 19:20:12 CST 2017
     */
    @Test
    public void testScheduleAtFixedRate() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newScheduledThreadPool(5);

        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("newSingleThreadScheduledExecutor = " + new Date());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.HOURS.sleep(24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
