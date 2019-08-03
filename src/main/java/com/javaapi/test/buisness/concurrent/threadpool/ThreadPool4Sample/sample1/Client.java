package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool4Sample.sample1;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 16/12/12.
 */
public class Client {

    private ExecutorService es = Executors.newFixedThreadPool(5);

    @Test
    public void test(){

    }
}
