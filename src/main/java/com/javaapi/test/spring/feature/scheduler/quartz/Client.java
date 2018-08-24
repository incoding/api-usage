package com.javaapi.test.spring.feature.scheduler.quartz;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
//@ContextConfiguration("applicationContext-simple.xml")
public class Client {
	
	@Autowired
	QuartzJob quartzJob;

	@Test
	public void test() {
		try {
			// 休眠十小时
			TimeUnit.HOURS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReflect() throws Exception {
		
		Method method = quartzJob.getClass().getMethod("work", null);
		
		Object invokeMethod = ReflectionUtils.invokeMethod(method,quartzJob );
		System.out.println(invokeMethod);
	}
}
