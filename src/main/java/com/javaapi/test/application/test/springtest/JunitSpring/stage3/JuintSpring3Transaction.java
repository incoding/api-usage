package com.javaapi.test.application.test.springtest.JunitSpring.stage3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 继承自AbstractTransactionalJUnit4SpringContextTests后</br> 1 支持事务回滚</br> 2
 * 支持数据库操作,从而对数据正确性进行验证</br>
 * 
 * @Transactional 
 *                注解的使用http://www.ibm.com/developerworks/cn/java/j-lo-springunitest
 *                </br>
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext-transaction.xml")
// 这么配置的话 1 使用默认名字为transactionManager 事务管理器 2 所有方法都回滚
@Transactional
// 再额外添加TransactionConfiguration的话 则 1 使用默认名字为txManager 事务管理器 2
// 只回滚标记了@RollBack的方法
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class JuintSpring3Transaction {
	@Autowired
	public JdbcTemplate	jdbcTemplate;
	
	@Test
	public void test(){
		String sql = "update csc_sns_dev.tbl_b set val='kk2' where id='2'";
		System.out.println("开始");
		int a = jdbcTemplate.update(sql);
		System.out.println("结束");
		Assert.assertEquals(1, a);
	}

	@BeforeTransaction
	@AfterTransaction
	public void testBeforeAfterTransaction() {
		System.out.println("-------");
	}

	@Test
	@Rollback
	public void test2() {
		String sql = "update csc_sns_dev.tbl_b set val='kk2' where id='2'";
		System.out.println("开始");
		int a = jdbcTemplate.update(sql);
		System.out.println("结束");
		Assert.assertEquals(1, a);
	}

	@Test(timeout = 3000)
	public void testTimeOut() {
		String sql = "update csc_sns_dev.tbl_b set val='kk2' where id='2'";
		System.out.println("开始");
		int a = jdbcTemplate.update(sql);
		System.out.println("结束");
		Assert.assertEquals(1, a);
	}

	@Test
	@Repeat
	public void testRepeat() {
		String sql = "update csc_sns_dev.tbl_b set val='kk2' where id='2'";
		System.out.println("开始");
		int a = jdbcTemplate.update(sql);
		System.out.println("结束");
		Assert.assertEquals(1, a);
	}
}
