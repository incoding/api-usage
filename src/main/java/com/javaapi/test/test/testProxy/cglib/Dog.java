package com.javaapi.test.test.testProxy.cglib;

public class Dog implements IAnimal {

	@Override
	public void active(String string) {
		System.out.println(string);
	}

}
