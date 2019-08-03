package com.javaapi.test.buisness.pattern.structure.decorator;

public class ManDecoratorC extends Decorator {

	public void eat() {
		super.eat();
		System.out.println("===============");
		System.out.println("ManDecoratorC类");
	}
}
