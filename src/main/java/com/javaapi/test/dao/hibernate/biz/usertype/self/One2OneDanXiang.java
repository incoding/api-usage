package com.javaapi.test.dao.hibernate.biz.usertype.self;

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
	public void testSelectList() throws Exception {
		Session openSession = sf.openSession();
		@SuppressWarnings("unchecked")
		List<BillDetail> list = openSession.createQuery("from BillDetail").list();
		for (BillDetail billDetail : list) {
			System.out.println(billDetail.getCreate_user());
		}
	}
	/**http://yangfei520.blog.51cto.com/1041581/274199 
	 * 1 要在<many-to-one>中加上cascade="save-update",
	 * 2 或者是在session.save(person)之前session.save(idCard)
	 * 
	 */
	@Test
	public void testInsert() throws Exception {
		
		BillDetail bd = new BillDetail();
		bd.setCreate_user("kk");
		bd.setBillid(OrganType.ORGANTYPE_DEPARTMENT);
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
//		beginTransaction.begin();
		openSession.save(bd);
		beginTransaction.commit();
		openSession.close();
	
	}
}
