package com.javaapi.test.test.testJavaFeature.testProtected.package3;

import org.junit.Test;

import com.javaapi.test.test.testJavaFeature.testProtected.package2.ClassB;

public class Client {
	/**
	 * 非子类,非同包 访问不到protected
	 */
	@Test
	public void testProtected() {
		ClassB b = new ClassB();
		// b.test(); compile error
	}

}
