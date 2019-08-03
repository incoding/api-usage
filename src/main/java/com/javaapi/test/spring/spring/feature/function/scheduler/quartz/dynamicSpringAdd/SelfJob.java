package com.javaapi.test.spring.spring.feature.function.scheduler.quartz.dynamicSpringAdd;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelfJob implements Job {

	SelfService selfService;
	
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("nihao");
		SelfJob object = (SelfJob) context.getMergedJobDataMap().get("selfJob");
        Object var = (Object) context.getMergedJobDataMap().get("var");

		System.out.println("SelfJob回调SelfJob==>"+this+"========getSelfService==>"+object.getSelfService()+"===spring selfJob==>"+object+"==var==>"+var);
        System.out.println("SelfService = " + selfService+"==var==>"+var);
//		extracted();
	}

	private void extracted() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sd.format(new Date());
		System.out.println("任务执行selfJob == >" + format + this);
	}
	
	public String getService() {
		return selfService.getBussiness();
	}

	public SelfService getSelfService() {
		return selfService;
	}

	public void setSelfService(SelfService selfService) {
		this.selfService = selfService;
	}

	
	
}
