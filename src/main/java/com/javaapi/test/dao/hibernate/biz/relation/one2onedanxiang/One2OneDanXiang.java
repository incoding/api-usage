package com.javaapi.test.dao.hibernate.biz.relation.one2onedanxiang;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;


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
	 * 
	 */
	@Test
	public void testInsert() throws Exception {
		Bill b = new Bill();
		b.setBillname("b_kk");
		
		BillDetail bd = new BillDetail();
		bd.setCreate_user("kk");
		bd.setBill(b);
		
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		beginTransaction.begin();
		openSession.save(bd);
		beginTransaction.commit();
		openSession.close();
	}

    /**
     * 2 或者是在session.save(person)之前session.save(idCard)
     */
    @Test
    public void testInsert_v2() throws Exception {
        Bill b = new Bill();
        b.setBillname("b_kk");

        BillDetail bd = new BillDetail();
        bd.setCreate_user("kk");

        Session openSession = sf.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
//        beginTransaction.begin();

        openSession.save(b);
        bd.setBill(b);
        System.out.println("doSomething");
        openSession.save(bd);
        beginTransaction.commit();
        openSession.close();
    }
}
