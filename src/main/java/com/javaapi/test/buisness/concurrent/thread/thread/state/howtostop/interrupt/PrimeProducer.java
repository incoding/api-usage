package com.javaapi.test.buisness.concurrent.thread.thread.state.howtostop.interrupt;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * PrimeProducer
 * <p/>
 * Using interruption for cancellation
 *
 * @author Brian Goetz and Tim Peierls
 */
public class PrimeProducer extends Thread {
    private static ExecutorService exec = Executors.newCachedThreadPool();



    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
                System.out.println("p = " + p);
            }
        } catch (InterruptedException consumed) {
            /* Allow thread to exit */
            consumed.printStackTrace();
            System.out.println("响应中断,退出");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancel() {
        this.interrupt();
    }
    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(queue);
    }


    static List<BigInteger> aSecondOfPrimes(BlockingQueue<BigInteger> queue) throws InterruptedException {
        PrimeProducer generator = new PrimeProducer(queue);
        exec.execute(generator);
        try {
            TimeUnit.SECONDS.sleep(10);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }

    static List<BigInteger> futureCancel(BlockingQueue<BigInteger> queue) throws InterruptedException {
        PrimeProducer generator = new PrimeProducer(queue);
        Future<?> future = exec.submit(generator);
        try {
            Object o = future.get(10,TimeUnit.SECONDS);
            System.out.println("o = " + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            future.cancel(true);
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println("done" );
        return generator.get();
    }




    static List<BigInteger> shutdownNow(BlockingQueue<BigInteger> queue) throws InterruptedException {
        PrimeProducer generator = new PrimeProducer(queue);
        exec.execute(generator);
        try {
            TimeUnit.SECONDS.sleep(10);
        } finally {
            exec.shutdownNow();
        }
        return generator.get();
    }
}