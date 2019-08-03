package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.queueStrategy.practice;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CallerRunsPolicy 主线程 调用runnable得run(当做普通方法调用,也就是会令主线程阻塞)
 * http://www.importnew.com/10790.html
 * http://zhidao.baidu.com/link?url=MZx4vIzWkQtkwQ4F1Jc7tQpk23Qx6dNgLplXqoNazV4wK6j4yy1oDiIcva7yUBfXkZtILS-xmPNf2Hlcl7VUZK
 * http://my.oschina.net/flashsword/blog/114527
 */
public class ExecutorTest {
    private ExecutorService es = newBlockingExecutorsUseCallerRun(3);

    public static ExecutorService newBlockingExecutorsUseCallerRun(int size) {
        return new ThreadPoolExecutor(size, size, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Random random = new Random();
                        int time = random.nextInt(3) + 1;
                        TimeUnit.SECONDS.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费 = " + finalI + "个线程");
                }
            });
            System.out.println("第 " + i + "个线程出发");
        }


    }
}
