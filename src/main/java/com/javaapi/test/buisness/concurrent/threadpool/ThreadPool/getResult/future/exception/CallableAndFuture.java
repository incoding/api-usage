package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.getResult.future.exception;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableAndFuture {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        long start = System.currentTimeMillis();
        ArrayList<FutureTask<String>> futures = new ArrayList<FutureTask<String>>();
        for (int i = 0; i < 10; i++) {
            FutureTask<String> future = new FutureTask<String>(
                    new DefaultCallableImp(i, 1));
            new Thread(future).start();
            futures.add(future);
        }
        getResult(futures);
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }

	private static void getResult(ArrayList<FutureTask<String>> futures) {
		while (true) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                Future<String> f = futures.get(i);
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    count++;
                }
            }
            System.out.println("----------------------");
            if (count == 10) {
                break;
            }
        }
	}
}