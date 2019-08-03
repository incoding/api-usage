package com.javaapi.test.buisness.dao.hibernate.biz.idGenerator;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


/**
 *
 *
 *
 CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `billname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `billdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `billid` int(11) DEFAULT NULL,
  `create_user` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `billid_idx` (`billid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

当设为true的时候，Hibernate在运行期动态产生sql语句，对于insert来说，只插入那些不是null的属性，这样就可以支持数据库字段的default属性；
</br>
对于update来说，只更新那些修改过的属性。
 *
 */
public class One2OneDanXiang {

	private SessionFactory	sf;

	@Before
	public void testConfigure() throws Exception {
		Configuration cfg=new Configuration();
		// 绝对路径只能这么写
		cfg.configure(new File(this.getClass().getResource("").getPath()+"hibernate.cfg.xml"));
		sf = cfg.buildSessionFactory();
	}
	

	@Test
	public void testId() throws Exception {
		Session openSession = sf.openSession();
		Bill load = (Bill) openSession.load(Bill.class, 59);
		System.out.println(load.getBillname());
		load.setBillname(null);
		Bill newBill = new Bill();
		// 注意 1
		newBill.setId(load.getId());
		Transaction beginTransaction = openSession.beginTransaction();
//		注意2 只要xml里配置里id生成器,java代码里自己设置得就会失效
		openSession.save(newBill);
		beginTransaction.commit();
		openSession.close();
	}
	/**
	 * merge的作用是：新new一个对象，如果该对象设置了ID，则这个对象就当作游离态处理：
                                      当ID在数据库中不能找到时，用update的话肯定会报异常，然而用merge的话，就会insert。
                                      当ID在数据库中能找到的时候，update与merge的执行效果都是更新数据，发出update语句；
                              如果没有设置ID的话，则这个对象就当作瞬态处理：
                               用update的话，由于没有ID，所以会报异常，merge此时则会保存数据，根据ID生产策略生成一条数据；
	 */
	@Test
	public void testUpdate() throws Exception {
		Session openSession = sf.openSession();
		Bill newBill = new Bill();
		newBill.setId(88);
		newBill.setBillname("kkkkkkkk");
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.update(newBill);
		beginTransaction.commit();
		openSession.close();
	}
	/**merge得实现就是先select一下,判断有无该数据,有则更新,无则插入
	 * @throws Exception
	 */
	@Test
	public void testMerge() throws Exception {
		Session openSession = sf.openSession();
		Bill newBill = new Bill();
		newBill.setId(88);
		newBill.setBillname("kkkkkkkk");
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.merge(newBill);
		beginTransaction.commit();
		openSession.close();
	}
}
