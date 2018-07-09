package com.javaapi.test.concurrent.thread.thread.exception.exception2ThreadUncaughtExceptionHandler;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * refer http://www.cnblogs.com/chenfei0801/archive/2013/04/23/3039286.html
 *  用 UncaughtExceptionHandler 处理线程池中线程产生的异常(不用线程池也能处理)
 *
 *
 *     	   //下面有3中方式来执行线程。

 */
public class Client {
    /**
     *         //第1种按照普通的方式。这是能捕获到异常
     */
    @Test
    public void testSetUncaughtExceptionHandler(){
        Thread t = new Thread(new ExceptionThread2());
        t.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
        t.start();
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第2种按照现成池，直接按照thread方式,此时不能捕获到异常，为什么呢？因为在下面代码中创建了一个线程，且设置了异常处理器，
     但是呢，在我们线程池中会重设置新的Thread对象，而这个Thread对象没有设置任何异常处理器，换句话说，我们在线程池外对线程做的
     任何操作都是没有用的
     */
    @Test
    public void testExceptionHandlerInThreadPool(){
        ExecutorService exec1 = Executors.newCachedThreadPool();
        Runnable runnable = new ExceptionThread2();
        Thread t1 = new Thread(runnable);
        t1.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
        exec1.execute(runnable);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第3种情况一样的，也是走的线程池，但是呢是通过ThreadFactory方式，在ThreadFactory中会对线程做一些控制，可以设置异常处理器
     此时是可以捕获异常的。

     // kk是这么个情况,先创建一个线程,然后运行线程后,该线程在最后抛出异常,
     //  此时线程池先生成新线程,然后在对上一个线程发生的异常机型处理
     */
    @Test
    public void testExceptionHanlderInThreadFactory(){
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  通过 future,
     *  future  包装了 runnable,  catch 了runnable的异常.  使之不抛给 UncaughtExceptionHandler 处理,
     *  所以 submit 的异常需要用future.get处理
     */
    @Test
    public void testExceptionHandleByFuture(){
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new ExceptionThread2());
        try {
            Object o = future.get();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 在线程池通过覆写 afterExecute
     */
    @Test
    public void testAfterExecute(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(11, 100,
                1, TimeUnit.MINUTES, //
                new ArrayBlockingQueue<Runnable>(10000)//
        ) {

            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                printException(r, t);
            }
        };
        threadPoolExecutor.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("执行");
                    throw new RuntimeException("错误1");
                } catch (Exception e) {
                    throw new RuntimeException("catch then throw",e);
                }

            }
        });
    }

    private static void printException(Runnable r, Throwable t) {
        if (t == null && r instanceof Future<?>) {
            try {
                Future<?> future = (Future<?>) r;
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        if (t != null) {
            System.out.println("error occur");
        }
    }

}