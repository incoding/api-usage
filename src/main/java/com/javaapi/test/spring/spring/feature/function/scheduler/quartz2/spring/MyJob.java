package com.javaapi.test.spring.spring.feature.function.scheduler.quartz2.spring;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by user on 17/11/1.
 */
public class MyJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + ": job 1 doing something...");
    }
}