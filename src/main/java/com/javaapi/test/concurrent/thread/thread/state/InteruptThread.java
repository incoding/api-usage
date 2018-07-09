package com.javaapi.test.concurrent.thread.thread.state;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 虽然不想说，但是还是忍不住，
 * 1 首先你要明确interrupt方法的意思，它是设置一个标志来告诉线程已中断</br>
 * 2 其次它会使得正在进行sleep、wait和join的方法抛出InterruptException异常
 * 3.1 从wait,sleep,join 抛出InterruptException异常后,这种使用isInterrupted()判断 ,返回结果是false.
 * 3.2 根据中断标示位返回,使用isInterrupted()判断 ,返回结果是true
 * ，你的Example1中只是设置了标志，而没有检查标志，或者满足抛出异常的条件，而且在你进行了中断标志设置之后并没有去检查该标志，线程当然会自动的执行下去
 */
public class InteruptThread {
    Logger logger = LoggerFactory.getLogger(InteruptThread.class);
    @Test
    public void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行");
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    logger.error("检测到线程标识被设置为中断",e);
                    logger.error("当前中断标识位"+Thread.currentThread().isInterrupted());
                    logger.error("由程序员自己控制怎么做,这个例子是不向下进行");
                    return;
                }

            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("-----------------------------------------");
        thread.interrupt();
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行");
                while (!Thread.currentThread().isInterrupted()) {

                }
                System.out.println("检测到线程标识被设置为中断");
                logger.error("当前中断标识位"+Thread.currentThread().isInterrupted());
                logger.error("由程序员自己控制怎么做,这个例子是不向下进行");
                return;

            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("-----------------------------------------");
        thread.interrupt();
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
