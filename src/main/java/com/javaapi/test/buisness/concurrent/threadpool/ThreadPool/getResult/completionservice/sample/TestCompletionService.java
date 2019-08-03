package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.getResult.completionservice.sample;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * refer https://blog.csdn.net/aitangyong/article/details/38169383
 *
 * ExecutorCompletionService任务的提交和执行都是委托给Executor来完成。当提交某个任务时，该任务首先将被包装为一个QueueingFuture
 */
public class TestCompletionService {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(
                threadPool1);

        for (int i = 0; i < 9; i++) {
            Thread t = new Thread(new UserThread(threadPool1,
                    completionService, i));
            t.start();
        }

    }
}
