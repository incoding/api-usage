package com.javaapi.test.test.javafeature.version_1_5.genericType.sample3;

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