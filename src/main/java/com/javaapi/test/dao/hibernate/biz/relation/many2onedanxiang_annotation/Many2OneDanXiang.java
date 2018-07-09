package com.javaapi.test.dao.hibernate.biz.relation.many2onedanxiang_annotation;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
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
注解映射
http://blog.csdn.net/hxlzpnyist/article/details/7789165
 *
 */
public class Many2OneDanXiang {

//	private SessionFactory	sf;
	
	private static SessionFactory sf;

	private static ServiceRegistry serviceRegistry;

	@SuppressWarnings("deprecation")
	@Before
	public void testConfigure() throws Exception {
		Configuration cfg=new Configuration();
		// 绝对路径只能这么写
		cfg.configure(new File(this.getClass().getResource("").getPath()+"hibernate.cfg.xml"));
		sf = cfg.buildSessionFactory();
		
//	    Configuration configuration =new Configuration();
//
//	    configuration.configure(new File(this.getClass().getResource("").getPath()+"hibernate.cfg.xml"));
//
//	    serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties()).getBootstrapServiceRegistry();        
//
//	    sf = configuration.buildSessionFactory(serviceRegistry);
	}
	/**先查所有得billdetail,再查询bill,bill得加载情况跟bill得lazy属性有关
	 * 这种情况不是懒加载
	 *  Hibernate: select billdetail0_.id as id1_, billdetail0_.create_user as create2_1_, billdetail0_.billid as billid1_ from billdetail billdetail0_
		Hibernate: select bill0_.id as id0_0_, bill0_.billname as billname0_0_ from bill bill0_ where bill0_.id=?
		Hibernate: select bill0_.id as id0_0_, bill0_.billname as billname0_0_ from bill bill0_ where bill0_.id=?
		wk
		user_wk
		kk
		user_kk

		这种情况是懒加载
		Hibernate: select billdetail0_.id as id1_, billdetail0_.create_user as create2_1_, billdetail0_.billid as billid1_ from billdetail billdetail0_
		Hibernate: select bill0_.id as id0_0_, bill0_.billname as billname0_0_ from bill bill0_ where bill0_.id=?
		wk
		user_wk
		Hibernate: select bill0_.id as id0_0_, bill0_.billname as billname0_0_ from bill bill0_ where bill0_.id=?
		kk
		user_kk
	 */
	@Test
	public void testSelectList() throws Exception {
		Session openSession = sf.openSession();
		@SuppressWarnings("unchecked")
		List<BillDetail> list = openSession.createQuery("from BillDetail").list();
		for (BillDetail billDetail : list) {
			System.out.println(billDetail.getBill().getBillname());
			System.out.println(billDetail.getCreate_user());
		}
	}
	/**http://yangfei520.blog.51cto.com/1041581/274199 
	 * 1 要在<many-to-one>中加上cascade="save-update",
	 * 2 或者是在session.save(person)之前session.save(idCard)
	 * 非xml下, 错误得方式
	 */
	@Test
	public void testInsert() throws Exception {
		Bill b = new Bill();
		b.setBillname("b_kk_many2one");
		
		BillDetail bd = new BillDetail();
		bd.setCreate_user("kk_many2one");
		bd.setBill(b);
		
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
//		beginTransaction.begin();
		// 这样会报错,因为b还未持久化到数据库
		openSession.save(bd);
		beginTransaction.commit();
		openSession.close();
	}
	/**
	 * 非XML下,正确得插入方式
	 */
	@Test
	public void testInsertN_1() throws Exception {
		Bill b = new Bill();
		b.setBillname("b_kk_many2one");
		
		BillDetail bd = new BillDetail();
		bd.setCreate_user("kk_many2one");
		bd.setBill(b);
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
//		beginTransaction.begin();
		openSession.save(b);
		openSession.save(bd);
		beginTransaction.commit();
		openSession.close();
	}
	/** 
	 * 非XML下,不是非常正确得插入,因为会多产生一条update
	 * Hibernate: insert into billdetail (create_user, billid) values (?, ?)
Hibernate: insert into bill (billname) values (?)
Hibernate: update billdetail set create_user=?, billid=? where id=?

	 */
	@Test
	public void testInsertN_1_not_right() throws Exception {
		Bill b = new Bill();
		b.setBillname("b_kk_many2one");
		
		BillDetail bd = new BillDetail();
		bd.setCreate_user("kk_many2one");
		bd.setBill(b);
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		beginTransaction.begin();
		openSession.save(bd);
		openSession.save(b);
		beginTransaction.commit();
		openSession.close();
	}
}
