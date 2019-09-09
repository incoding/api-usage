package com.javaapi.test.test.testJdk.runtime;

import org.junit.Test;

/**
 * @see http://blog.csdn.net/zolalad/article/details/11519327
 *  jvm的-D参数要在主类名之前,程序参数要在主类之后
 *  java -Dsss=6666 -Dkkvalue=333 com.javaapi.test.test.testRuntime.TestProgramArgsAndJvmArgs  
 */
public class TestProgramArgsAndJvmArgs {

	public static void main(String[] args) {
		for(String string: args){
			System.out.println(string);
		}
		// -Dsss=sssvalue

//		 设置jvm系统属性名/值对，运行在此jvm之上的应用程序可用System.getProperty("property")得到value的值。
		System.out.println(System.getProperty("sss"));// 要这样获取
	}
	
	/**
	 * 获取linux/widows 服务器环境变量 
	 */
	@Test
	public void getLiunxEnvVal() throws Exception {
		System.out.println(System.getenv("kkvalue")); 
		System.out.println(System.getenv("sss"));
		System.out.println(System.getenv("PATH"));
	}
}
