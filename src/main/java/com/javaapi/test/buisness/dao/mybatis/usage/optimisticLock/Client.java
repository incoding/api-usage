package com.javaapi.test.buisness.dao.mybatis.usage.optimisticLock;

import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 
 * CREATE TABLE `cash_book` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键ID',
  `account_id` bigint(20) DEFAULT NULL COMMENT 'account表id',
  `balance` decimal(12,2) DEFAULT NULL COMMENT '余额',
  `version` decimal(12,2) DEFAULT NULL COMMENT '乐观锁版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='现金表';

INSERT INTO cash_book(cash_book.id,cash_book.account_id,cash_book.balance,cash_book.version)value(1,1,0,0);
SELECT * FROM cash_book;
UPDATE cash_book set balance=0, version=0 WHERE id=1;


 CREATE TABLE `cash_book_2` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键ID',
  `account_id` bigint(20) DEFAULT NULL COMMENT 'account表id',
  `balance` decimal(12,2) DEFAULT NULL COMMENT '余额',
  `version` decimal(12,2) DEFAULT NULL COMMENT '乐观锁版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='现金表';

INSERT INTO cash_book_2(cash_book_2.id,cash_book_2.account_id,cash_book_2.balance,cash_book_2.version)value(1,1,0,0);
SELECT * FROM cash_book_2;
UPDATE cash_book_2 set balance=0, version=0 WHERE id=1;

 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Transactional
public class Client{

	@Autowired
	SqlSessionTemplate	sqlSessionTemplate;
	
	@Autowired
	CashBookService cashBookService;
	@Autowired
	CashBookForUpdateService cashBookForUpdateService;
	
	@Test
	public void selectOne() {
		CashBook cash  = new CashBook();
		cash.setAccountId(1l);
		CashBook seletOne = sqlSessionTemplate.getMapper(CashBookDao.class).selectOne(cash);
		System.out.println(seletOne);
	}
	@Test
	@Rollback(value=false)
	public void update() {
		CashBook cash  = new CashBook();
		cash.setAccountId(1l);
		cash.setBalance(BigDecimal.valueOf(1l));
		cash.setVersion(BigDecimal.valueOf(0l));
		int result = sqlSessionTemplate.getMapper(CashBookDao.class).updateBalance(cash);
		Assert.assertEquals(1, result);
	}
	@Test
	@Rollback(value=false)
	public void testSelectForUpdate() throws Exception {
		cashBookService.addBalance(1l, BigDecimal.valueOf(1l));
	}
	
	/**
	 * 乐观锁，10次测试:并发5个线程，重试5次，5成功.
	 * 乐观锁，10次测试:并发10个线程，重试5次，8-10成功.
	 * 乐观锁，10次测试:并发50个线程，重试5次，10-25成功.
	 * 乐观锁，10次测试:并发100个线程，重试5次，20~38成功.</br>
	 * next 相应时间?//TODO
	 * 统一异常处理//TODO</br>
	 */
	@Test
	@Rollback(value=false)
	public void testConcurrence() throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						cashBookService.addBalance(1l, BigDecimal.valueOf(1l));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
		}
		TimeUnit.HOURS.sleep(1);
	}
	/**	 * 乐观锁，10次测试:并发5个线程，重试5次，5成功.
	 * 乐观锁，10次测试:并发10个线程，重试5次，8-10成功.
	 * 乐观锁，10次测试:并发50个线程，重试5次，10-25成功.
	 * 乐观锁，10次测试:并发100个线程，重试5次，20~38成功.</br>
	 *10次 ( 100次更新 )  平均执行了3296-3916毫秒
	 */
	@Test
	@Rollback(value=false)
	public void testConcurrenceCom() throws Exception {
		StopWatch watch = new StopWatch();
		watch.start();
		int length = 10;
		ExecutorService threadPool1 = Executors.newFixedThreadPool(length);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
				threadPool1);
		
		for (int i = 0; i < length; i++) {
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					cashBookService.addBalance(1l, BigDecimal.valueOf(1l));
					return 1;
				}
			});
		}
		for (int i = 0; i < length; i++) {
			System.out.println("打印返回值"+completionService.take().get());
		}
		watch.stop();
		System.out.println("共执行了"+watch.getTime()+"毫秒");
	}
	/**
	 * 注意一定要加上事务
	 */
	@Test
	@Rollback(value=false)
	public void testForUpdate() throws Exception {
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						cashBookForUpdateService.addBalance(1l, BigDecimal.valueOf(1l));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
		}
		System.out.println("---------");
		TimeUnit.HOURS.sleep(1);
	}
	
	/**
	 *	 *3.6Gib ,2.20GHZ*4 10次 ( 100次更新 )  平均执行了2633-3284毫秒
	 *7.7 GiB ,3.60GHz × 4  :  10次 ( 100次更新 )  平均执行了614毫秒
	 */
	@Test
	@Rollback(value=false)
	public void testForUpdateCom() throws Exception {
		StopWatch watch = new StopWatch();
		watch.start();
		int length = 100;
		ExecutorService threadPool1 = Executors.newFixedThreadPool(length);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
				threadPool1);
		
		for (int i = 0; i < length; i++) {
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					cashBookForUpdateService.addBalance(1l, BigDecimal.valueOf(1l));
					return 1;
				}
			});
		}
		for (int i = 0; i < length; i++) {
			System.out.println("打印返回值"+completionService.take().get());
		}
		watch.stop();
		System.out.println("共执行了"+watch.getTime()+"毫秒");
	}
}
