package com.javaapi.test.spring.zotherFeature.scheduler.springscheduler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
    /**
     * 多个任务共享同一实例
     */
	@Test
	public void test() {
		try {
			// 休眠十小时
			TimeUnit.HOURS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
