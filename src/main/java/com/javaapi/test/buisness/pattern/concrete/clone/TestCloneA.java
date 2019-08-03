package com.javaapi.test.buisness.pattern.concrete.clone;

public class TestCloneA {

	public TestCloneA() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		A a = new A();
		a.name = "5";
		System.out.println("a的地址是" + a + "a的值是" + a.name);
		A b = (A) a.clone();
		System.out.println("b的地址是" + b + "b的值是" + b.name);
	}
}
