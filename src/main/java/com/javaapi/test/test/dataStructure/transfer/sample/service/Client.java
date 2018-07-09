package com.javaapi.test.test.dataStructure.transfer.sample.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.javaapi.test.test.dataStructure.transfer.sample.po.Account;
import com.javaapi.test.test.dataStructure.transfer.sample.po.CashBook;
import com.javaapi.test.test.dataStructure.transfer.sample.po.CashBookTrade;

/**
 * http://ifeve.com/guava-reflection/#more-11200 </br>
 * 对象使用
 *
 */
public class Client {

	private static final ArrayList<CashBookTrade>	trade	= new ArrayList<>();
	private static final ArrayList<CashBook>	book	= new ArrayList<>();
	private static final ArrayList<Account>	account	= new ArrayList<>();


	@Before
	public void testName() throws Exception {
		CashBookTrade e = new CashBookTrade();
		e.setId(1l);
		e.setTime("12");
		e.setCashBookId(1l);
		CashBookTrade e2 = new CashBookTrade();
		e2.setId(2l);
		e2.setTime("12");
		e2.setCashBookId(2l);
		CashBookTrade e3 = new CashBookTrade();
		e3.setId(3l);
		e3.setTime("12");
		e3.setCashBookId(3l);
		trade.add(e);
		trade.add(e2);
		trade.add(e3);
		//
		CashBook book1 = new CashBook();
		book1.setId(1l);
		book1.setAccountId(1l);
		book1.setBalance(new BigDecimal("1"));
		CashBook book2 = new CashBook();
		book2.setId(2l);
		book2.setAccountId(2l);
		book2.setBalance(new BigDecimal("2"));
		CashBook book3 = new CashBook();
		book3.setId(3l);
		book3.setAccountId(3l);
		book3.setBalance(new BigDecimal("3"));
		book.add(book1);
		book.add(book2);
		book.add(book3);
		
		Account account1 = new Account();
		account1.setId(1l);
		Account account2 = new Account();
		account2.setId(2l);
		Account account3 = new Account();
		account3.setId(3l);
		
		account.add(account1);
		account.add(account2);
		account.add(account3);
	}
	@Test
	public void service() throws Exception {
		ArrayList<CashBook> bookList = getBook();
		List<Long> accountIds =new ArrayList<>();
		CollectionUtils.collect(bookList, new Transformer<CashBook,Long>() {
			@Override
			public Long transform(CashBook input) {
				return input.getAccountId();
			}
		},accountIds);
		ArrayList<Account> accountList = getAccount(accountIds);
		ImmutableMap<Long, CashBook> cashBookMap = Maps.uniqueIndex(bookList, new Function<CashBook, Long>() {
			@Override
			public Long apply(CashBook input) {
				return input.getAccountId();
			}
		});
		System.err.println(cashBookMap);
		//
		List<Map<String,Object>> voList =new ArrayList<>();
		//取所有的account
		for (Account account : accountList) {
			CashBook cashBook = cashBookMap.get(account.getId());
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("cash", cashBook);
			hashMap.put("account", account);
			voList.add(hashMap);
		}
		System.err.println(voList);
		
	}
	public static ArrayList<CashBook> getBook() {
		return book;
	}
	public static ArrayList<CashBookTrade> getTrade() {
		return trade;
	}
	public static ArrayList<Account> getAccount() {
		return account;
	}
	private static ArrayList<Account> getAccount(List<Long> accountIds) {
		return account;		
	}
}
