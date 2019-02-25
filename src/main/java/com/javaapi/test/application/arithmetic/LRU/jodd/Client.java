package com.javaapi.test.application.arithmetic.LRU.jodd;

import jodd.cache.LRUCache;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2018/10/28
 */
public class Client {
    @Test
    public void test(){
        LRUCache lruCache = new LRUCache(100);
        for (int i = 0; i < 200; i++) {
            lruCache.put(i, i);
        }
        System.out.println("lruCache = " + lruCache.size());
    }

    @Test
    public void testTimeOut(){
        LRUCache lruCache = new LRUCache(100,1);
        for (int i = 0; i < 200; i++) {
            lruCache.put(i, i);
        }
        System.out.println("lruCache = " + lruCache.size());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lruCache.put("this action will active prune","value");
        System.out.println("lruCache = " + lruCache.size());
        System.out.println("lruCache = " + lruCache.snapshot());

    }



}
