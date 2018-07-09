package com.javaapi.test.buisness.exception.exceptionusage.catchorder;

import org.junit.Test;

public class Client {

	@Test
	public void testCatchOrder() throws Exception {
		try {
			throw new RuntimeException("nihao");
		}
		catch (RuntimeException r) {
			System.out.println("catch Runtime");
			System.out.println(r.getMessage());
		}
		catch (Exception e) {
			System.out.println("catch E");
			System.out.println(e.getMessage());
		}
	}
	
}
