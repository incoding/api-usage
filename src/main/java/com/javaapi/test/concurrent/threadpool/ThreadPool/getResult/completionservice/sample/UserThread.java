package com.javaapi.test.concurrent.threadpool.ThreadPool.getResult.completionservice.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UserThread implements Runnable {
    public ExecutorService           threadPool1;
    public CompletionService<String> completionService;
    public Integer                   id;

    public UserThread(ExecutorService threadPool1,
            CompletionService<String> completionService, Integer id) {
        super();
        this.threadPool1 = threadPool1;
        this.completionService = completionService;
        this.id = id;
    }

    @Override
    public void run() {
        List<Future<String>> futures = new ArrayList<Future<String>>();
        for (int i = 0; i < 3; i++) {
            futures.add(completionService.submit(new DefaultCallableImp(i, id)));
        }
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("用户<" + id + ">获取返回值==>"
                        + futures.get(i).get());
                // System.out.println("用户<" + id + ">获取返回值==>"
                // + completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
