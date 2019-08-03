package com.javaapi.test.buisness.dao.hibernate.biz.relation.one2onedanxiang;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class TestHibernateBiz {

	private SessionFactory	sf;

	@Before
	public void configure() throws Exception {
		Configuration cfg=new Configuration();
		cfg.configure();
		sf = cfg.buildSessionFactory();
	}
	/**查询单独对象不会造成N+1问题
	 * @throws Exception
	 */
	@Test
	public void testSelectListBill() throws Exception {
		Session openSession = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Bill> list = openSession.createQuery("from Bill").list();
		for (Bill bill : list) {
			System.out.println(bill.getBillname());
		}
	}
	/**查询单独对象有N+1问题
	 * @throws Exception
	 */
	@Test
	public void testSelectIterateBill() throws Exception {
		Session openSession = sf.openSession();
		 @SuppressWarnings("unchecked")
		Iterator<Bill> iterate = openSession.createQuery("from Bill").iterate();
		 while (iterate.hasNext()) {
			Bill bill =  iterate.next();
			System.out.println(bill.getBillname());
		}
	}
	/**
	 *Hibernate: select billdetail0_.id as id1_, billdetail0_.create_user as create2_1_, billdetail0_.billid as billid1_ from billdetail billdetail0_ left outer join bill bill1_ on billdetail0_.billid=bill1_.id
	Hibernate: select bill0_.id as id0_0_, bill0_.billname as billname0_0_ from bill bill0_ where bill0_.id=?
	Hibernate: select bill0_.id as id0_0_, bill0_.billname as billname0_0_ from bill bill0_ where bill0_.id=?
	 */
	@Test
	public void testSelectListLeftJoin() throws Exception {
		Session openSession = sf.openSession();
		@SuppressWarnings("unchecked")
		List<BillDetail> list = openSession.createQuery("select d from BillDetail d left join d.bill ").list();
		for (BillDetail billDetail : list) {
			System.out.println(billDetail.getBill().getBillname());
			System.out.println(billDetail.getCreate_user());
		}
	}
	@Test
	public void testSelectIterate() throws Exception {
		Session openSession = sf.openSession();
		 @SuppressWarnings("unchecked")
		Iterator<BillDetail> iterate = openSession.createQuery("from BillDetail").iterate();
		 while (iterate.hasNext()) {
			BillDetail billDetail = (BillDetail) iterate.next();
			System.out.println(billDetail.getBill().getBillname());
			System.out.println(billDetail.getCreate_user());
		}
	}
}
