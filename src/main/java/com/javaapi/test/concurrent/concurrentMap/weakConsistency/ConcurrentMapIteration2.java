package com.javaapi.test.concurrent.concurrentMap.weakConsistency;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  * 参考
 * http://blog.csdn.net/u011031854/article/details/16842951
 * （2）两个读线程共享一个Iterator
 * 结果：发生死锁
 */
public class ConcurrentMapIteration2 {
    private final Map<String, String> map = new ConcurrentHashMap<String, String>();
    private final Iterator<Map.Entry<String, String>> iterator;

    private final static int MAP_SIZE = 100000;

    public static void main(String[] args) {
        new ConcurrentMapIteration2().run();
    }

    public ConcurrentMapIteration2() {
        for (int i = 0; i < MAP_SIZE; i++) {
            map.put("key" + i, UUID.randomUUID().toString());
        }
        this.iterator = this.map.entrySet().iterator();
    }

    private final ExecutorService executor = Executors.newCachedThreadPool();

    private final class Accessor implements Runnable {
        private final Iterator<Map.Entry<String, String>> iterator;

        public Accessor(Iterator<Map.Entry<String, String>> iterator) {
            this.iterator = iterator;
        }

        @Override
        public void run() {
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                try {
                    System.out.println(
                            Thread.currentThread().getName() + " - [" + entry.getKey() + ", " + entry.getValue() + ']'
                    );

                } catch (Exception e) {
                    e.printStackTrace();
                }

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
        Accessor a1 = new Accessor(this.iterator);
        Accessor a2 = new Accessor(this.iterator);
        Mutator m = new Mutator(this.map);

        executor.execute(a1);
        executor.execute(m);
        executor.execute(a2);
    }
}