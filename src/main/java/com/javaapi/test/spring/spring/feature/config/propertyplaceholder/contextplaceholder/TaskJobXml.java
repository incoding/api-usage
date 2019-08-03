package com.javaapi.test.spring.spring.feature.config.propertyplaceholder.contextplaceholder;

//@Service
public class TaskJobXml {

	
	private String taskName;
	public void job1() {
		System.out.println("任务执行xml");
    }

	public void job_init() {
		System.out.println("init xml");
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}