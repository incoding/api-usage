package com.javaapi.test.pattern.structure.decorator;

public class ManDecoratorD extends Decorator {

	public void eat() {
		super.eat();
		System.out.println("===============");
		System.out.println("ManDecoratorD类");
	}
}
