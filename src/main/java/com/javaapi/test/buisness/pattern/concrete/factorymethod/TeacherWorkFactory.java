package com.javaapi.test.buisness.pattern.concrete.factorymethod;

public class TeacherWorkFactory implements IWorkFactory {

	public Work getWork() {
		return new TeacherWork();
	}

}
