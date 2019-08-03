package com.javaapi.test.spring.spring.aop.aspectj.annotation;

public interface CustomerBo {
	 
	void addCustomer();
 
	String addCustomerReturnValue();
 
	void addCustomerThrowException() throws Exception;
 
	void addCustomerAround(String name);
}