package com.javaapi.test.buisness.exception.bussiness.exception;

import com.javaapi.test.buisness.exception.bussiness.exception.exception.BusinessException;
import com.javaapi.test.buisness.exception.bussiness.exception.exception.BusinessExceptionUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionClient {

	static Logger logger = LoggerFactory.getLogger(ActionClient.class);
	
	@Test
	public void testRetry() throws Exception {
		try {
			BusinessService.seriviceBusiness();
		} catch (BusinessException e) {
			logger.error("业务异常",e);
		} catch (Exception e) {
			logger.info("系统发生内部错误", e);
			return;
		}
		System.out.println("全部业务执行成功");
	}
	
	@Test
	public void testRetryOther() throws Exception {
		try {
			BusinessService.seriviceBusiness();
		} 
		catch(BusinessException e) {
			BusinessExceptionUtil.dealBusinessException(e);
		}
		catch (Exception e) {
				logger.info("系统发生内部错误",e);
		}
		System.out.println("全部业务执行成功");
	}


}
