package com.javaapi.test.util.validate;

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Test;

public class Client {
	/**
	 * validator 对象线程不安全
	 * 
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		boolean valid = EmailValidator.getInstance().isValid("123@163.com");
		System.out.println(valid);
	}
}
