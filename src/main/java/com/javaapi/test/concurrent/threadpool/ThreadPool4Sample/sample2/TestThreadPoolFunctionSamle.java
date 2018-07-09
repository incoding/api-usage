package com.javaapi.test.concurrent.threadpool.ThreadPool4Sample.sample2;

import com.javaapi.test.concurrent.threadpool.ThreadPool.queueStrategy.ThreadPoolTest;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

/**
 * ThreadPool里的功能
 */
public class TestThreadPoolFunctionSamle extends ThreadPoolTest {

    @Test
    public void getNextTime(){
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.DAY_OF_MONTH,instance.get(Calendar.DAY_OF_MONTH)+1);
        instance.set(Calendar.HOUR_OF_DAY,2);
        instance.set(Calendar.MINUTE,0);
        instance.set(Calendar.SECOND,0);

        long duration = instance.getTime().getTime() - System.currentTimeMillis();
        System.out.println("duration = " + duration);
    }


    @Test
    public void newSingleThreadScheduledExecutor() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        oneTime(newSingleThreadScheduledExecutor);

        try {
            TimeUnit.HOURS.sleep(24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void oneTime(ScheduledExecutorService newSingleThreadScheduledExecutor) {
        newSingleThreadScheduledExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                printTime();
                oneDaySchedule(newSingleThreadScheduledExecutor);
            }
        }, 5000, TimeUnit.MILLISECONDS);
    }

    private void oneDaySchedule(ScheduledExecutorService newSingleThreadScheduledExecutor) {
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                printTime();

            }
        }, 5, 5, TimeUnit.SECONDS);
    }
    private void printTime() {
        Date date = new Date();
        System.out.println("" + date.toString());
    }
}
