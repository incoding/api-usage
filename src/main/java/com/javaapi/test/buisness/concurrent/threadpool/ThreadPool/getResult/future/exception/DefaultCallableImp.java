package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.getResult.future.exception;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class DefaultCallableImp implements Callable<String> {
    public int taskId;
    public int userId;

    public DefaultCallableImp(int taskId, int userId) {
        super();
        this.taskId = taskId;
        this.userId = userId;
    }

    @Override
    public String call() throws Exception {
        if (taskId == 0) {
            TimeUnit.SECONDS.sleep(5);
            throw new RuntimeException("cuowu");
        }
        System.out.println("执行用户" + userId + "的任务" + taskId);

        return "用户" + userId + "的任务" + taskId;
    }
}
