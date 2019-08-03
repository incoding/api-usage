package com.javaapi.test.spring.spring.feature.function.scheduler.springscheduler;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TaskJob {

	public void job1() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sd.format(new Date());
		System.out.println("任务执行xml == >" +format);
    }
}