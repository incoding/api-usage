package com.javaapi.test.buisness.pattern.structure.decorator;

public class ManDecoratorA extends Decorator {

	public void eat() {
		super.eat();
		System.out.println("ManDecoratorA类");
	}
}
