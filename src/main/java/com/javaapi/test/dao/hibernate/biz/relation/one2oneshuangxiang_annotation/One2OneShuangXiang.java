package com.javaapi.test.dao.hibernate.biz.relation.one2oneshuangxiang_annotation;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


public class One2OneShuangXiang {

	private SessionFactory	sf;

	@Before
	public void testConfigure() throws Exception {
		Configuration cfg=new Configuration();
		// 绝对路径只能这么写
		cfg.configure(new File(this.getClass().getResource("").getPath()+"hibernate.cfg.xml"));
		sf = cfg.buildSessionFactory();
	}
	/**
	 * Hibernate: select billdetail0_.id as id1_, billdetail0_.create_user as create2_1_, billdetail0_.billid as billid1_ from billdetail billdetail0_
		Hibernate: select bill0_.id as id0_1_, bill0_.billname as billname0_1_, billdetail1_.id as id1_0_, billdetail1_.create_user as create2_1_0_, billdetail1_.billid as billid1_0_ from bill bill0_ left outer join billdetail billdetail1_ on bill0_.id=billdetail1_.billid where bill0_.id=?
		Hibernate: select billdetail0_.id as id1_1_, billdetail0_.create_user as create2_1_1_, billdetail0_.billid as billid1_1_, bill1_.id as id0_0_, bill1_.billname as billname0_0_ from billdetail billdetail0_ left outer join bill bill1_ on billdetail0_.billid=bill1_.id where billdetail0_.billid=?
		Hibernate: select bill0_.id as id0_1_, bill0_.billname as billname0_1_, billdetail1_.id as id1_0_, billdetail1_.create_user as create2_1_0_, billdetail1_.billid as billid1_0_ from bill bill0_ left outer join billdetail billdetail1_ on bill0_.id=billdetail1_.billid where bill0_.id=?
		Hibernate: select billdetail0_.id as id1_1_, billdetail0_.create_user as create2_1_1_, billdetail0_.billid as billid1_1_, bill1_.id as id0_0_, bill1_.billname as billname0_0_ from billdetail billdetail0_ left outer join bill bill1_ on billdetail0_.billid=bill1_.id where billdetail0_.billid=?
		wk
		user_wk
		user_wk
		kk
		user_kk
		user_kk

	 */
	@Test
	public void testSelectListBillDetail() throws Exception {
		Session openSession = sf.openSession();
		@SuppressWarnings("unchecked")
		List<BillDetail> list = openSession.createQuery("from BillDetail").list();
		for (BillDetail billDetail : list) {
			System.out.println(billDetail.getBill().getBillname());
			System.out.println(billDetail.getCreate_user());
			System.out.println(billDetail.getBill().getBilldetail().getCreate_user());
		}
	}
	/**
	 *  Hibernate: select bill0_.id as id0_, bill0_.billname as billname0_ from bill bill0_
		Hibernate: select billdetail0_.id as id1_1_, billdetail0_.create_user as create2_1_1_, billdetail0_.billid as billid1_1_, bill1_.id as id0_0_, bill1_.billname as billname0_0_ from billdetail billdetail0_ left outer join bill bill1_ on billdetail0_.billid=bill1_.id where billdetail0_.billid=?
		Hibernate: select billdetail0_.id as id1_1_, billdetail0_.create_user as create2_1_1_, billdetail0_.billid as billid1_1_, bill1_.id as id0_0_, bill1_.billname as billname0_0_ from billdetail billdetail0_ left outer join bill bill1_ on billdetail0_.billid=bill1_.id where billdetail0_.billid=?
		wk
		user_wk
		wk
		kk
		user_kk
		kk
	 */
	@Test
	public void testSelectListBill() throws Exception {
		Session openSession = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Bill> list = openSession.createQuery("from Bill").list();
		for (Bill billDetail : list) {
			System.out.println(billDetail.getBillname());
			System.out.println(billDetail.getBilldetail().getCreate_user());
			System.out.println(billDetail.getBilldetail().getBill().getBillname());
		}
	}
	/**
	 * 正确
	 * http://yangfei520.blog.51cto.com/1041581/274605/
	 */
	@Test
	public void testInsert() throws Exception {
		Bill bill = new Bill();
		bill.setBillname("b_kk");
		
		BillDetail detail = new BillDetail();
		detail.setCreate_user("kk");
		detail.setBill(bill);
		
		Session openSession = sf.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
//		beginTransaction.begin();
		openSession.save(detail);
		beginTransaction.commit();
		openSession.close();
	}
	
}
