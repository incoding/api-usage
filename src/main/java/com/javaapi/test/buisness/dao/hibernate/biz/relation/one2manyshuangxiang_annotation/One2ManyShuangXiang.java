package com.javaapi.test.buisness.dao.hibernate.biz.relation.one2manyshuangxiang_annotation;

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
 *http://www.holdjava.com/Hibernate/126462.htm</br>
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
注解方式是从xml得包,复制过来后进行修改的
 *
 */
public class One2ManyShuangXiang {

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
	/**能正确插入
	 *
	 */
	@Test
	public void testInsert() throws Exception {
		Bill b = new Bill();
		b.setBillname("b_kks");
		
		BillDetail bd = new BillDetail();
		bd.setCreate_user("kk1");
		BillDetail bd2 = new BillDetail();
		bd2.setCreate_user("kk2");
		
		// 在多得一方要维护关联关系,所以java代码里也要跟着设置
		bd.setBill(b);
		bd2.setBill(b);
		
		Set<BillDetail> set = new HashSet<BillDetail>();
		set.add(bd);
		set.add(bd2);
		// 1得一方设置级联,保存1得时候会级联保存多,所以这里要设置多.
		b.setBilldetails(set);
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
//		beginTransaction.begin();
		openSession.save(b);
		beginTransaction.commit();
		openSession.close();
	}
}
