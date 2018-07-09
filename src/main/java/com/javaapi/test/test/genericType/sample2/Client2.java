package com.javaapi.test.test.genericType.sample2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Client2 {
	// 可以这么赋值
	@Test
	public void test11() {
		List<Race> list = new ArrayList<>();
		list.add(new ZcRace());
		list.add(new DcRace());
	}

	@Test
	public void test12() {
		List<Race> list = new ArrayList<>();
		list.add(new ZcRace());
		list.add(new DcRace());
		List<DcRace> dcList = new ArrayList<>();
		dcList.add(new DcRace());
		dcList.add(new DcRace());
		List<ZcRace> zcList = new ArrayList<>();
		zcList.add(new ZcRace());
		zcList.add(new ZcRace());
//		但不可以这么赋值
//		list = dcList;
//		list = zcList;
	}
	
	@Test
	public void test21() {
		List<? extends Race> list = new ArrayList<>();
//		不可以这么赋值
//		list.add(new ZcRace());
//		list.add(new DcRace());
	}
	
	@Test
	public void test22() {
		List<? extends Race> list  =null;
		List<DcRace> dcList = new ArrayList<>();
		dcList.add(new DcRace());
		dcList.add(new DcRace());
		List<ZcRace> zcList = new ArrayList<>();
		zcList.add(new ZcRace());
		//但是可以这么赋值
		list = dcList;
		list = zcList;
	}
	
	@Test
	public void test31() {
		List<?> list = new ArrayList<>();
//		list.add(new ZcRace());
//		list.add(new DcRace());
	}
}
