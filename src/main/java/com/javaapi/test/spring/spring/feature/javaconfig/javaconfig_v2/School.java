package com.javaapi.test.spring.spring.feature.javaconfig.javaconfig_v2;

public class School {
	public WorkerI teacher;

    public School(WorkerI teacher) {
        this.teacher = teacher;
    }

    public WorkerI getTeacher() {
		return teacher;
	}

	public void setTeacher(WorkerI teacher) {
		this.teacher = teacher;
	}
	public void haveClass(){
		teacher.work();
	}
}
