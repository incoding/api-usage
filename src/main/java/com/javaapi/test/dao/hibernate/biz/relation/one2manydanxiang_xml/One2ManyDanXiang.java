package com.javaapi.test.dao.hibernate.biz.relation.one2manydanxiang_xml;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

 *
 */
@Deprecated
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
		List<Bill> list = openSession.createQuery("from Bill").list();
		for (Bill bill : list) {
			System.out.println(bill.getBillname());
			Set<BillDetail> billdetails = bill.getBilldetails();
			for (BillDetail billDetail : billdetails) {
				System.out.println(billDetail.getCreate_user());
			}
			System.out.println("-----------");
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
		BillDetail bd2 = new BillDetail();
		bd.setCreate_user("kk2");
		
		Set<BillDetail> set = new HashSet<BillDetail>();
		set.add(bd);
		set.add(bd2);
		
		
		Bill b = new Bill();
		b.setBillname("b_kk");
		b.setBilldetails(set);
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
//		beginTransaction.begin();
		openSession.save(b);
		beginTransaction.commit();
		openSession.close();
	}
}
