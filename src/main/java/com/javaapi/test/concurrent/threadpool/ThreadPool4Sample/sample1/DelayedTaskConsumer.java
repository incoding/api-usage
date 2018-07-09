package com.javaapi.test.concurrent.threadpool.ThreadPool4Sample.sample1;

import java.util.concurrent.DelayQueue;

class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                q.take().run();
            //new Thread(q.take()).start();
        } catch (InterruptedException e) {
            System.err.println("InterruptedException");
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
