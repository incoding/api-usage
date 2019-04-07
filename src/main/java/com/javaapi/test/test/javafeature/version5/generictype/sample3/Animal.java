package com.javaapi.test.test.javafeature.version5.generictype.sample3;

public class Animal {
	private String name;

	public Animal(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println(getName() + " can eat.");
	}
	
	public String getName(){
		return name;
	}
}