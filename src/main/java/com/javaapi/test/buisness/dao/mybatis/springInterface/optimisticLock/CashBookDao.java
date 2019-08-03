package com.javaapi.test.buisness.dao.mybatis.springInterface.optimisticLock;


public interface CashBookDao  {
	CashBook selectOne(CashBook cashBook);
	
	
	
	int updateBalance(CashBook cashbook);
	
	
	CashBook selectOne_2(CashBook cashBook);
	
	
	
	int updateBalance_2(CashBook cashbook);
	
	//以下悲观锁
	CashBook selectOneForUpdate(CashBook cashBook);
	
	int update(CashBook cashBook);
	
	CashBook selectOneForUpdate_2(CashBook cashBook);
	
	int update_2(CashBook cashBook);
}
