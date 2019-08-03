package com.javaapi.test.buisness.concurrent.concurrentMap.weakConsistency;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 参考
 * http://blog.csdn.net/u011031854/article/details/16842951
 * （1）两个读线程和一个修改线程，每个线程各自拥有一个Iterator，并发访问ConcurrentHashMap。
 * 结果：正常运行
 */
public class ConcurrentMapIteration {
    private final Map<String, String> map = new ConcurrentHashMap<String, String>();

    private final static int MAP_SIZE = 100000;

    public static void main(String[] args) {
        new ConcurrentMapIteration().run();
    }

    public ConcurrentMapIteration() {
        for (int i = 0; i < MAP_SIZE; i++) {
            map.put("key" + i, UUID.randomUUID().toString());
        }
    }

    private final ExecutorService executor = Executors.newCachedThreadPool();

    private final class Accessor implements Runnable {
        private final Map<String, String> map;

        public Accessor(Map<String, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            for (Map.Entry<String, String> entry : this.map.entrySet()) {
                System.out.println(
                        Thread.currentThread().getName() + " - [" + entry.getKey() + ", " + entry.getValue() + ']'
                );
            }
        }
    }

    private final class Mutator implements Runnable {

        private final Map<String, String> map;
        private final Random random = new Random();

        public Mutator(Map<String, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                this.map.remove("key" + random.nextInt(MAP_SIZE));
                this.map.put("key" + random.nextInt(MAP_SIZE), UUID.randomUUID().toString());
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

    private void run() {
        Accessor a1 = new Accessor(this.map);
        Accessor a2 = new Accessor(this.map);
        Mutator m = new Mutator(this.map);

        executor.execute(a1);
        executor.execute(m);
        executor.execute(a2);

    }
}