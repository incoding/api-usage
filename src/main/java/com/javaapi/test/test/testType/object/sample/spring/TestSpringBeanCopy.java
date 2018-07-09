package com.javaapi.test.test.testType.object.sample.spring;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.javaapi.test.test.testType.object.DiffBean;
import com.javaapi.test.test.testType.object.FromBean;
import com.javaapi.test.test.testType.object.ToBean;

import java.util.ArrayList;
import java.util.List;

public class TestSpringBeanCopy {

	@Test
	public void testSameBeanCopy() {
		FromBean fb = new FromBean();
		fb.setAddress("北京市朝阳区大屯路");
		fb.setAge(20);
		fb.setMoney(30000.111);
		fb.setIdno("110330219879208733");
		fb.setName("测试");
		FromBean to = new FromBean();
		copy(fb, to);
		System.out.println(to.toString());
	}
	private void copy(FromBean fb, FromBean to) {
		BeanUtils.copyProperties(fb, to);
	}
	@Test
	public void testToBeanCopy() {
		FromBean fb = new FromBean();
		fb.setAddress("北京市朝阳区大屯路");
		fb.setAge(20);
		fb.setMoney(30000.111);
		fb.setIdno("110330219879208733");
		fb.setName("测试");
		ToBean to = new ToBean();
		BeanUtils.copyProperties(fb, to);
		System.out.println(to.toString());
	}
	/**
	 * 不同类型得bean,要属性名字相同
	 */
	@Test
	public void testDiffBeanCopy() {
		FromBean fb = new FromBean();
		fb.setAddress("北京市朝阳区大屯路");
		fb.setAge(20);
		fb.setMoney(30000.111);
		fb.setIdno("110330219879208733");
		fb.setName("测试");
		DiffBean to = new DiffBean();
		BeanUtils.copyProperties(fb, to);
		System.out.println(to.toString());
	}


	@Test
	public void test(){
		List<FromBean> list1 = new ArrayList<>();
		FromBean e = new FromBean();
		e.setName("frombean_1");
		list1.add(e);

		List<FromBean> list2 = new ArrayList<>();
		FromBean e2 = new FromBean();
		e2.setName("frombean_2");
		list2.add(e2);

		BeanUtils.copyProperties(list2.get(0),list1.get(0));
		System.out.println("list1 = " + list1);
		System.out.println("list2 = " + list2);
	}

	/**
	 * 没办法copy   list
	 */
	@Test
	public void testCopyList(){
		List<FromBean> list1 = new ArrayList<>();
		FromBean e = new FromBean();
		e.setName("frombean_1");
		list1.add(e);

		List<FromBean> list2 = new ArrayList<>();
		FromBean e2 = new FromBean();
		e2.setName("frombean_2");
		list2.add(e2);

		BeanUtils.copyProperties(list1,list2);
		System.out.println("list1 = " + list1);
		System.out.println("list2 = " + list2);
	}


}
