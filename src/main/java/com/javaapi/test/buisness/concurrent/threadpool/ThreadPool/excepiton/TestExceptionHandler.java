package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.excepiton;

import com.javaapi.test.buisness.concurrent.thread.thread.exception.exception2ThreadUncaughtExceptionHandler.Client;
import org.junit.Test;

/**
 * http://blog.onlycatch.com/post/Java%E7%BA%BF%E7%A8%8B%E6%B1%A0%E5%BC%82%E5%B8%B8%E5%A4%84%E7%90%86%E6%9C%80%E4%BD%B3%E5%AE%9E%E8%B7%B5
 * 总共2种思路
 * 1. 在提交的任务中将异常捕获并处理，不抛给线程池。
 2. 异常抛给线程池，但是我们要及时处理抛出的异常。


 第2种思路又有以下几种实现方式：
 1. 自定义线程池，继承ThreadPoolExecutor并复写其afterExecute(Runnable r, Throwable t)方法。
 2. execute提交,实现Thread.UncaughtExceptionHandler接口，实现void uncaughtException(Thread t, Throwable e);方法，并将该handler传递给线程池的ThreadFactory
 3. submit提交,使用Future，将返回结果以及异常放到Future中，在Future中处理
 4. 继承ThreadGroup，覆盖其uncaughtException方法。（与第二种方式类似，因为ThreadGroup类本身就实现了Thread.UncaughtExceptionHandler接口)
 @see com.javaapi.test.buisness.concurrent.thread.thread.exception.exception2ThreadUncaughtExceptionHandler.Client
 */
public class TestExceptionHandler {
    private com.javaapi.test.buisness.concurrent.thread.thread.exception.exception2ThreadUncaughtExceptionHandler.Client client = new Client();

    /**
     * 线程池处理 异常
     */
    @Test
    public void testAfterExecute() {
        client.testAfterExecute();
    }

    /**
     * UncaughtExceptionHandler 是否适合在线程池中使用
     从上面的分析中可以看出，使用 UncaughtExceptionHandler，可以处理到使用 execute 方法执行任务所抛出的异常，但是对 submit 方法无效。那如果只是用 execute 方法，我们是否可以通过设置 UncaughtExceptionHandler 从而添加一种默认的异常处理机制，以避免重复的 try...catch 代码呢？

     答案是不能。原因在于，如果在执行 execute 方法时不在 Runnable.run 方法中写 try...catch 方法，自然异常会交由 UncaughtExceptionHandler 处理，但是，在这之前，线程的工作线程会因为异常而退出。虽然线程池会创建一个新的工作线程，但是如果这个步骤反复执行，效率自然会下降很多。

     作者：编走编想
     链接：https://www.jianshu.com/p/281958d20b04
     來源：简书
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @Test
    public void testExceptionHanlderInThreadFactory() {
        client.testExceptionHanlderInThreadFactory();
    }

    @Test
    public void testExceptionHandleByFuture() {
        client.testExceptionHandleByFuture();
    }

    @Test
    public void testThreadGroup(){

    }


}
