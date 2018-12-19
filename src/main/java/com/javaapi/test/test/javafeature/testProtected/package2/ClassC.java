package com.javaapi.test.test.javafeature.testProtected.package2;

import org.junit.Test;

public class ClassC {

	/**
	 * 同包 非子类
	 */
	@Test
	public void testclassB() {
		ClassB classB = new ClassB();
		// classB.test(); compile error c虽然与b同包,但是访问不了b得protected
	}
}
