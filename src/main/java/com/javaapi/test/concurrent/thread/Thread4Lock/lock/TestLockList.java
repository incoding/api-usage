package com.javaapi.test.concurrent.thread.Thread4Lock.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给list加锁,然后当前获得list锁得线程(因为当前线程获取了锁对象)还是可以将元素放入list中的
 * 
 */
public class TestLockList {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<>();
		list.add(list.size());
		addlist(list);
		System.out.println(list.size()+ "====="+list);
	}

	public void addlist(List<Integer> list) {
        if(list.size()==10){
            return;
        }
		synchronized (list) {
			list.add(list.size());
            addlist(list);
		}

	}
}
