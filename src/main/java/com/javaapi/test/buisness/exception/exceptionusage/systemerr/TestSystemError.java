package com.javaapi.test.buisness.exception.exceptionusage.systemerr;

import com.alibaba.dubbo.rpc.RpcException;

/**
 * http://jackycheng2007.iteye.com/blog/1473625
 * 
 */
public class TestSystemError {
	public static void main(String[] args) {
		System.out.println("这个标准输出,this is stdout");
		System.err.println("这是标准错误,this is stderror");
		throw new RpcException("异常");
	}
}
