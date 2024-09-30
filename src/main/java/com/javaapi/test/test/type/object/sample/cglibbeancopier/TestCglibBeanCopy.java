package com.javaapi.test.test.type.object.sample.cglibbeancopier;

import net.sf.cglib.beans.BeanCopier;

import org.junit.Test;

import com.javaapi.test.test.type.object.DiffBean;
import com.javaapi.test.test.type.object.FromBean;
import com.javaapi.test.test.type.object.ToBean;

/**
 * beancopier使用得时候要缓存beancopier,不然临时创建beancopier实例,然后再复制属性,还没spring得beanutil好
 *
 */
public class TestCglibBeanCopy {
	BeanCopier	ff	= BeanCopier.create(FromBean.class, FromBean.class, false);
	BeanCopier	ft	= BeanCopier.create(FromBean.class, ToBean.class, false);
	BeanCopier	fd	= BeanCopier.create(FromBean.class, DiffBean.class, false);
	
	@Test
	public void testSameBeanCopy() {
		FromBean fb = new FromBean();
		fb.setAddress("北京市朝阳区大屯路");
		fb.setAge(20);
		fb.setMoney(30000.111);
		fb.setIdno("110330219879208733");
		fb.setName("测试");
		FromBean to = new FromBean();
		ff.copy(fb, to,null);
		System.out.println(to.toString());
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
		ft.copy(fb, to, null);
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
		fd.copy(fb, to, null);
		System.out.println(to.toString());
	}
}
