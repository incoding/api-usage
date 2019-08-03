package com.javaapi.test.buisness.pattern.concrete.factorymethod;

public class StudentWorkFactory implements IWorkFactory {

	public Work getWork() {
		return new StudentWork();
	}

}
