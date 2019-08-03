package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool3Knowledge;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 1 工作线程  worker
 * 2 任务接口  task
 * 3 任务队列  work queue
 *
 *
 *
 * Proceed in 3 steps:
 *
 * 1. If fewer than corePoolSize threads are running, try to
 * start a new thread with the given command as its first
 * task.  The call to addWorker atomically checks runState and
 * workerCount, and so prevents false alarms that would add
 * threads when it shouldn't, by returning false.
 *
 * 2. If a task can be successfully queued, then we still need
 * to double-check whether we should have added a thread
 * (because existing ones died since last checking) or that
 * the pool shut down since entry into this method. So we
 * recheck state and if necessary roll back the enqueuing if
 * stopped, or start a new thread if there are none.
 *
 * 3. If we cannot queue task, then we try to add a new
 * thread.  If it fails, we know we are shut down or saturated
 * and so reject the task.
 */

public class Client {
    @Test
    public void test() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("es = nihao");
                }
            });

        }
        TimeUnit.HOURS.sleep(1);

    }

}
