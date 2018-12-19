package com.javaapi.test.test.javafeature.testProtected.package2;

import org.junit.Test;

import com.javaapi.test.test.javafeature.testProtected.package1.ClassA;

/**
 * 正确
 * 
 */
public class ClassB extends ClassA {


	@Test
	public void testProtectedA() {
		ClassA a = new ClassA();
		// a.test(); compile error 子类不能直接访问父类本身的protected
	}

	@Test
	public void testProtectedB() {
		ClassB b = new ClassB();
		b.test(); // 子类可以访问自己从父类继承的protected
	}

}
