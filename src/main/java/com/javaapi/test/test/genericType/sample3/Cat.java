package com.javaapi.test.test.genericType.sample3;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	public void jump(){
		System.out.println(getName() + " can jump.");
	}
}