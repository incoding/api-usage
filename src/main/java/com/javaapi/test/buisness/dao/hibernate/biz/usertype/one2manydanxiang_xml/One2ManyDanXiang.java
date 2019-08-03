package com.javaapi.test.buisness.dao.hibernate.biz.usertype.one2manydanxiang_xml;

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
 *尽量不要用单向1-N,因为会多出update语句</br>
 *用双向1-N替代
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
</br>
只是测试UserType得使用http://wangzl2222.iteye.com/blog/645501</br>
http://kevdmx.blog.51cto.com/429766/711673
 *
 */
public class One2ManyDanXiang {

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
			System.out.println(billDetail.getBillDesc().getIndex());
			System.out.println(billDetail.getBillDesc().getName());
		}
	}
	@Test
	public void testSelectList2() throws Exception {
		Session openSession = sf.openSession();
		@SuppressWarnings("unchecked")
		List<BillDetail> list = openSession.createQuery("from BillDetail").list();
		for (BillDetail billDetail : list) {
			System.out.println(billDetail.getBankName().getIndex());
		}
	}
	/**能正确插入但是会多update语句
	 * Hibernate: insert into bill (billname) values (?)
Hibernate: insert into billdetail (create_user, billid) values (?, ?)
Hibernate: insert into billdetail (create_user, billid) values (?, ?)
Hibernate: update billdetail set billid=? where id=?
Hibernate: update billdetail set billid=? where id=?

	 */
	@Test
	public void testInsert() throws Exception {
		
		
		BillDetail bd = new BillDetail();
		bd.setCreate_user("kk1");
		bd.setBankName(BankName.ICBC);
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
//		beginTransaction.begin();
		openSession.save(bd);
		beginTransaction.commit();
		openSession.close();
	}
}
