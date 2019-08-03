package com.javaapi.test.buisness.dao.jdbc.transaction.transactiondeclare.aop;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClientPlain {

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
	@Test
	public void testExpression() {
		String path = ClientPlain.class.getResource("")
				.getPath();
		String apppath = "file:" + path + "applicationContext.xml";
		ApplicationContext app = new FileSystemXmlApplicationContext(apppath);
		AspectJExpressionPointcut bean = (AspectJExpressionPointcut) app.getBean("serviceMethod");
		System.out.println(bean);
		boolean canApply = AopUtils.canApply(bean,UpdateImp.class);
		System.out.println(canApply);
		System.out.println(AopUtils.canApply(bean,InsertImp.class));
	}
	@Test
	public void testIsAopProxy() {
		String path = ClientPlain.class.getResource("")
				.getPath();
		String apppath = "file:" + path + "applicationContext.xml";
		ApplicationContext app = new FileSystemXmlApplicationContext(apppath);
		IupdateService bean = (IupdateService) app
				.getBean("targetUpdateService");
		System.out.println(AopUtils.isAopProxy(bean));
		System.out.println(AopUtils.isJdkDynamicProxy(bean));
		System.out.println(AopUtils.isCglibProxy(bean));
	}
}