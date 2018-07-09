package com.javaapi.test.buisness.exception.exceptionusage.commonexception;

import org.junit.Test;

/**
 * 常用异常
 *
 */
public class ClientRuntimeException {
	
	@Test
	public void RuntimeException(){
		throw new RuntimeException("比较笼统的非售检查异常");
	}
	/**
	 * 常用，用于提示接口调用者传入得参数错误(虽说是未检查得但是也是可以用的)
	 */
	@Test
	public void IllegalArgumentException(){
		throw new IllegalArgumentException("非法参数");
	}
	@Test
	public void IllegalStateException(){
		throw new IllegalStateException("非法状态异常");
	}
	@Test
	public void SecurityException(){
		throw new SecurityException("安全相关异常");
	}
	@Test
	public void UnsupportedOperationException(){
		throw new UnsupportedOperationException("不支持的操作");
	}
}
