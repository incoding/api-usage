package com.javaapi.test.buisness.dataTrans.synchroinzed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class Synchronized {

	@Test
	public void test() {
		System.out.println("test");
		List<String> list = new ArrayList<String>();
		Collection<String> c = Collections.synchronizedCollection(list);
		// 包装成为线程安全的类之后,如果调用iterator 需要手动调用synchronized,其他的则不必
		synchronized (c) {
			Iterator<String> i = c.iterator(); // Must be in the synchronized
												// block
			while (i.hasNext()) {
				System.out.println(i.next());
			}
		}

	}
}
