package com.javaapi.test.buisness.dao.jdbc.transaction.transactiondeclare.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClientPlain {

	/**
	 * 
	 */
	@Test
	public void test() {
		String path = ClientPlain.class.getResource("")
				.getPath();
		String apppath = "file:" + path + "applicationContext.xml";
		ApplicationContext app = new FileSystemXmlApplicationContext(apppath);
		IupdateService bean = (IupdateService) app
				.getBean("targetUpdateService");
		bean.update();
	}
}