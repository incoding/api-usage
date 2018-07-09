package com.javaapi.test.appframework.distribute.idworker.idworker2;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class IdWorkerTest {
    static class IdWorkThread implements Runnable {
        private Set set;
        private IdWorker idWorker;
        public IdWorkThread(Set set, IdWorker idWorker) {
            this.set = set;
            this.idWorker = idWorker;
        }
        @Override
        public void run() {
            while (true) {
                long id = idWorker.nextId();
                if (!set.add(id)) {
                    System.out.println("duplicate:"+ id);
                }
            }
        }

        public Set getSet() {
            return set;
        }

        public void setSet(Set set) {
            this.set = set;
        }
    }
    public static void main(String[] args) {
        Set set = new HashSet();
        final IdWorker idWorker1 = new IdWorker(0, 0);
        final IdWorker idWorker2 = new IdWorker(1, 0);
        IdWorkThread workThread1 = new IdWorkThread(set, idWorker1);
        IdWorkThread workThread2 = new IdWorkThread(set, idWorker2);
        Thread t1 = new Thread(workThread1);
        Thread t2 = new Thread(workThread2);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        int timeout = 0;
        try {
            timeout = 30;
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(timeout+"秒生成id数 = "+workThread1.getSet().size());
    }
}