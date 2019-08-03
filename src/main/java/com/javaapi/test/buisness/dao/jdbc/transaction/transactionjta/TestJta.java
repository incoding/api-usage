package com.javaapi.test.buisness.dao.jdbc.transaction.transactionjta;

import org.junit.Test;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;

public class TestJta {

	@Test
	public void test() throws NamingException {
		// UserTransaction
		InitialContext ctx = new InitialContext();
		Object txObj = ctx.lookup("java:comp/UserTransaction");
		UserTransaction utx = (UserTransaction) txObj;
	}

}
