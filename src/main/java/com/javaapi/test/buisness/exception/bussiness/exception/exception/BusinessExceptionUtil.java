package com.javaapi.test.buisness.exception.bussiness.exception.exception;

import com.javaapi.test.buisness.exception.bussiness.exception.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessExceptionUtil {
	static Logger logger = LoggerFactory.getLogger(BusinessExceptionUtil.class);

	
	public static void dealBusinessException(BusinessException bussiness) {
		boolean isSuccess = false;
		if(bussiness.getError().getIndex() == ErrorCode.needRetry3.getIndex()) {
			logger.info(ErrorCode.needRetry3.getMsg());
			for (int i = 0; i < 3; i++) {
				isSuccess= BusinessService.seriviceBusiness();
				if(isSuccess) {
					break;
				}
			}
			return;
		}else if(bussiness.getError().getIndex() == ErrorCode.doNotRetry.getIndex()) {
			logger.info("乐观锁或其他异常",bussiness);
			return;
		}else if (bussiness.getError().getIndex() == ErrorCode.commonError.getIndex()) {
			String msg = bussiness.getError().getMsg();
			logger.info("一般错误,错误信息={}",msg,bussiness);
			return;
		}
		
	}
}
