package com.javaapi.test.concurrent.thread.thread;

/**
 * http://www.cnblogs.com/luochengor/archive/2011/08/11/2134818.html
 * 3 守护线程,当前台线程都退出了,守护线程就会自动退出
 */
public class DaemonThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + "==>" + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();
        dt.setDaemon(true);
        dt.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }
    }
}
