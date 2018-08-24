package com.javaapi.test.spring.feature.scheduler.quartz2.original.concurrent;

import org.quartz.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MyJobNonConcurrent implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + ": doing something...");
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}