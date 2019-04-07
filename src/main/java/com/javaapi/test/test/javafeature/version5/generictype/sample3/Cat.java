package com.javaapi.test.test.javafeature.version5.generictype.sample3;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	public void jump(){
		System.out.println(getName() + " can jump.");
	}
}