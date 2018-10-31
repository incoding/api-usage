package com.javaapi.test.arithmetic.LRU.self.linkedhashmap.inheritance;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2018/10/28
 */
public class Client {
    @Test
    public void test(){
        LRUCache2 lruCache = new LRUCache2(100);
        for (int i = 0; i < 200; i++) {
            lruCache.put(i, i);
        }
        System.out.println("lruCache = " + lruCache.size());
    }

    @Test
    public void testTimeOut(){
        LRUCache2 lruCache = new LRUCache2(100);
        for (int i = 0; i < 200; i++) {
            lruCache.put(i, i);
        }
        System.out.println("lruCache = " + lruCache.size());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lruCache.put("this action will active prune","value");
        System.out.println("lruCache = " + lruCache.size());

    }



}
