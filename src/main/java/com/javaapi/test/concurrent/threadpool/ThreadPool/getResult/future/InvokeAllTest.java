package com.javaapi.test.concurrent.threadpool.ThreadPool.getResult.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 *   https://my.oschina.net/jielucky/blog/158839
 *   当向Executor提交批处理任务时，并且希望在它们完成后获得结果，如果用FutureTask，你可以循环获取task，并用future.get()去获取结果，但是如果这个task没有完成，你就得阻塞在这里，这个实效性不高，
 *   其实在很多场合，其实你拿第一个任务结果时，此时结果并没有生成并阻塞，其实在阻塞在第一个任务时，第二个task的任务已经早就完成了，显然这种情况用future task不合适的，效率也不高。
 */
public class InvokeAllTest {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();
        ArrayList<Callable<Integer>> callers = new ArrayList<Callable<Integer>>();
        int len = 10;
        for (int i = 0; i < len; i++) {
            callers.add(new Callable<Integer>() {
                public Integer call() throws Exception {
                    String name = Thread.currentThread().getName();
                    System.out.println(name);
                    return Float.valueOf(Thread.currentThread().getId()).intValue();
                }
            });
        }
        //这种方式是需要所有的线程都执行完毕才可以往下执行
        List<Future<Integer>> futrues=   pool.invokeAll(callers);
        System.out.println("done!");
        for(Future<Integer> futrue:futrues){
        	System.out.println(futrue.get());
        }
        pool.shutdown();
    }
}
