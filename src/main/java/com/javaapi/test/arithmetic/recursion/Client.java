package com.javaapi.test.arithmetic.recursion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author kk
 *	未完成
 */
public class Client {

	private List<Perm> permList = new ArrayList<>();
	
	@Test
	public void testDigui() throws Exception {
		List<Perm> list =new ArrayList<>();
		list.add(new Perm(0,1));
		list.add(new Perm(0,2));
		list.add(new Perm(0,3));
		list.add(new Perm(0,4));
		
		list.add(new Perm(1,5));
		list.add(new Perm(1,6));
		list.add(new Perm(1,7));
		list.add(new Perm(1,8));
		list.add(new Perm(1,9));
		
		list.add(new Perm(5,10));
		list.add(new Perm(5,11));
		list.add(new Perm(5,12));
		
		List<Perm> child = getChild(1,list);
		for (Perm perm : child) {
			System.out.println(perm);
		}
	}

	private List<Perm> getChild(int inputId, List<Perm> list) {
		List<Perm> permTmpList = new ArrayList<>();
		for (Perm perm : list) {
			
		}
		return permTmpList;
	}
	
}
