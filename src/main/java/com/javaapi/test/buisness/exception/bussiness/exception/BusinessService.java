package com.javaapi.test.buisness.exception.bussiness.exception;

import com.javaapi.test.buisness.exception.bussiness.exception.exception.BusinessException;
import com.javaapi.test.buisness.exception.bussiness.exception.exception.ErrorCode;

public class BusinessService {

	private static  int _0 = 0;

	public static boolean seriviceBusiness() {
		System.out.println("---------");
		BusinessService.business1();
		boolean business2 = BusinessService.business2();
		System.out.println("---------");
		return business2;
	}

	static void business1() {
		System.out.println("1 业务执行成功");
	}

	static boolean business2() {
		if (_0++ == 0) {
			throw new BusinessException(ErrorCode.needRetry3);
		}
		System.out.println("2 业务执行成功");
		return true;
	}

}
