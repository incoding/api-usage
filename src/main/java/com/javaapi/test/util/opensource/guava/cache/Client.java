package com.javaapi.test.util.opensource.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by user on 17/7/6.
 */
public class Client {
    @Test
    public void TestLoadingCache() throws Exception {
        LoadingCache<String, String> cahceBuilder = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue = "hello " + key + "!";
                        return strProValue;
                    }

                });

        System.out.println("jerry value:" + cahceBuilder.apply("jerry"));
        System.out.println("jerry value:" + cahceBuilder.get("jerry"));
        System.out.println("peida value:" + cahceBuilder.get("peida"));
        System.out.println("peida value:" + cahceBuilder.apply("peida"));
        System.out.println("lisa value:" + cahceBuilder.apply("lisa"));
        cahceBuilder.put("harry", "ssdded");
        System.out.println("harry value:" + cahceBuilder.get("harry"));
        System.out.println("lisa value:" + cahceBuilder.apply("lisa"));
    }


    /**
     * 泛型
     * @throws Exception
     */
    @Test
    public void testcallableCache()throws Exception{
        Cache<String, Map<String,String>> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        Map<String, String> resultVal = getAllCache(cache);
        System.out.println("jerry value : " + resultVal);
        resultVal = getAllCache(cache);
        System.out.println("resultVal = " + resultVal);

    }

    private Map<String, String> getAllCache(Cache<String, Map<String, String>> cache) throws java.util.concurrent.ExecutionException {
        return cache.get("delayAll", new Callable<Map<String,String>>() {
                public Map<String,String> call() {
                    System.out.println("retrive from remote");

                    HashMap<String, String> result = new HashMap<>();
                    result.put("nihao", "nihaovalue");
                    return result;
                }
            });
    }


    /**
     * 泛型
     * @throws Exception
     */
    @Test
    public void testAll()throws Exception{
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        Cache<String, String> delayCache = CacheBuilder.newBuilder().maximumSize(1000).build();
        getAllDelayCache(cache,delayCache);
        String nihaoDelay = delayCache.getIfPresent("nihaoDelay");
        String nihaoDelay2 = delayCache.getIfPresent("nihaoDelay2");
        System.out.println("nihaoDelay = " + nihaoDelay);
        System.out.println("nihaoDelay2 = " + nihaoDelay2);
    }

    private void getAllDelayCache(Cache<String, String> stringStringCache, Cache<String, String> cache) throws ExecutionException {
        stringStringCache.get("2017-07-06", new Callable<String>() {
            @Override
            public String call() throws Exception {

                System.out.println("retrive from remote");

                Map<String, String> map = new HashMap<>();
                map.put("nihaoDelay", "nihaoDelay");
                cache.putAll(map);
                return "true";
            }

        });

    }


}
