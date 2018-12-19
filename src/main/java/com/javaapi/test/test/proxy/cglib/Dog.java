package com.javaapi.test.test.proxy.cglib;

public class Dog implements IAnimal {

	@Override
	public void active(String string) {
		System.out.println(string);
	}

}
