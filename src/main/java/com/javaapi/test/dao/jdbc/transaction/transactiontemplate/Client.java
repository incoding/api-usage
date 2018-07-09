package com.javaapi.test.dao.jdbc.transaction.transactiontemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 更实际点得应用配置可以参照这个:http://blog.csdn.net/wang0928007/article/details/7576591
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	DevServiceI			devServiceI;
	/**使用TransactionTemplate模板类</br>
	 * 如果采用编程式事务推荐使用TransactionTemplate模板类和高级别解决方案。
	 * http://sishuok.com/forum/blogPost/list/2506.html
	 * 如果发生异常需要自己处理并且显示调用status.setRollbackOnly() 后,模板才能在回调中回滚
	 */
	@Test
	public void testTransactionTemplate() {
		int update = devServiceI.update();
		System.out.println(update);
	}
}
