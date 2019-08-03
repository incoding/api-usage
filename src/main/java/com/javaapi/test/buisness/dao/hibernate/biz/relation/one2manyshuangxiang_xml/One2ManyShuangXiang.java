package com.javaapi.test.buisness.dao.hibernate.biz.relation.one2manyshuangxiang_xml;

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
 *http://lijiejava.iteye.com/blog/776587</br>
 *在一对多关联中，在多的一方设置inverse="true",有助于性能的改善。通过上述分析可以发现少了update语句。 </br>
 *尽量不要用单向1-N,因为会多出update语句</br>
 *用双向1-N替代,注意1得一端无论是xml配置还是code配置都要给set加上inverse="true",让多得一端维护关联关系
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
	/**http://blog.csdn.net/chenssy/article/details/7717175
	 *  通过上面的SQL语句可以看出，Hibernate并不是采用哪种先insert后update的方式来插入employee记录的。而是通过一条insert SQL语句来执行的。为什么？因为程序持久化Employee实体之前，Employee已经知道它所关联Department实体（employee2.setDepartment(department);）。 所以为了保证比较好的性能，需要注意以下两个问题：

          1、应该先持久化主表对象：Department。因为我们希望程序在持久化从表：Employee对象时，Hibernate可以为他的外键属性值分配值。

          2、先设置两个持久化类（Department和Employee）的关系，再保存持久化从表对象（Employee）。如果顺序反过来，程序持久化Employee对象时，该对象还没有关联实体，所以Hibernate不能为对应记录的外键列指定值，等到设置关联关系时，Hibernate只能再次使用update语句来修改了。
          </br>
	 * Hibernate: insert into bill (billname) values (?)
	   Hibernate: insert into billdetail (create_user, billid) values (?, ?)
	   Hibernate: insert into billdetail (create_user, billid) values (?, ?)
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
		beginTransaction.begin();
		openSession.save(b);
		beginTransaction.commit();
		openSession.close();
	}
	/**
	 * wrong
	 */
	@Test
	public void testInsert2() throws Exception {
		Bill b = new Bill();
		b.setBillname("b_kks");
		
		BillDetail bd = new BillDetail();
		bd.setCreate_user("kk1");
		BillDetail bd2 = new BillDetail();
		bd2.setCreate_user("kk2");
		
//		bd.setBill(b);
//		bd2.setBill(b);
		
		Set<BillDetail> set = new HashSet<BillDetail>();
		set.add(bd);
		set.add(bd2);
		
		b.setBilldetails(set);
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		beginTransaction.begin();
		openSession.save(b);
		beginTransaction.commit();
		openSession.close();
	}
}
