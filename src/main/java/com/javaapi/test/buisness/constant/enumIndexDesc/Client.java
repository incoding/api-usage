package com.javaapi.test.buisness.constant.enumIndexDesc;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Client {
	@Test
	public void getByIndex() throws Exception {
		int key = 2;
		CashTradeIn_task byIndex = CashTradeIn_task.getByIndex(key);
		System.out.println(byIndex.getIndex());
		Assert.assertEquals(2, byIndex.getIndex());
	}
	@Test
	public void getByDesc() throws Exception {
		String desc = "待打款";
		CashTradeIn_task byIndex = CashTradeIn_task.getByDesc(desc);
		System.out.println(byIndex.getDesc());
		Assert.assertEquals(desc, byIndex.getDesc());
	}
	@Test
	public void getAllType() throws Exception {
		List<CashTradeIn_task> allType = CashTradeIn_task.getAllType();
		System.out.println(allType);
		for (CashTradeIn_task cashTradeIn_task : allType) {
			System.out.println(cashTradeIn_task.getIndex()+"=="+cashTradeIn_task.getDesc());
		}
	}
}
