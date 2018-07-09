package com.javaapi.test.dao.hibernate.biz.dynamic;

import java.io.File;
import java.util.List;

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
	public void testNoneDynamic() throws Exception {
		Session openSession = sf.openSession();
		Bill load = (Bill) openSession.load(Bill.class, 59);
		System.out.println(load.getBillname());
		load.setBillname(null);
		Bill newBill = new Bill();
		newBill.setId(load.getId());
		Transaction beginTransaction = openSession.beginTransaction();
		//org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session : [com.javaapi.test.dao.hibernate.biz.dynamic.Bill#59]
		//openSession.saveOrUpdate(newBill);
		openSession.update(load);
		beginTransaction.commit();
		openSession.close();
	}

	/**
	 * 设置为null也会更新
	 * @throws Exception
	 */
	@Test
	public void testDynamic() throws Exception {
		Session openSession = sf.openSession();
		Bill load = (Bill) openSession.load(Bill.class, 59);
		load.setBillname(null);
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.update(load);
		beginTransaction.commit();
		openSession.close();
	}
}
