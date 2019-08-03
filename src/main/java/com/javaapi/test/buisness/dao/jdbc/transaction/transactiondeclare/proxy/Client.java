package com.javaapi.test.buisness.dao.jdbc.transaction.transactiondeclare.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 通过代理实现事物
 * 1 http://sishuok.com/forum/blogPost/list/2506.html
 * 2 事务配置的5种方式
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

	// @Autowired
	// @Qualifier("proxyInsertService")
	// IinsertService insertService;
	@Autowired
	@Qualifier("proxyUpdateService")
	IupdateService	updateService;
	
	@Test
	public void test(){
		updateService.update();
	}
}
