package com.javaapi.test.concurrent.threadpool.ThreadPool.excepiton;

import java.util.concurrent.TimeUnit;

/**
 * refer http://blog.onlycatch.com/post/Java%E7%BA%BF%E7%A8%8B%E6%B1%A0%E5%BC%82%E5%B8%B8%E5%A4%84%E7%90%86%E6%9C%80%E4%BD%B3%E5%AE%9E%E8%B7%B5
 */
public class ThreadGroupExceptionExample {
    public static class MyThreadGroup extends ThreadGroup {
        public MyThreadGroup(String s) {
            super(s);
        }
        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            System.out.println("Thread " + thread.getName()
                    + " died, exception was: ");
            throwable.printStackTrace();
        }
    }
    public static ThreadGroup workerThreads =
            new MyThreadGroup("Worker Threads");
    public static class WorkerThread extends Thread {
        public WorkerThread(String s) {
            super(workerThreads, s);
        }
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        Thread t = new WorkerThread("Worker Thread");
        t.start();
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}