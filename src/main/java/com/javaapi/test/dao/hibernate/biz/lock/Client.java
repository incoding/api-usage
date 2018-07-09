package com.javaapi.test.dao.hibernate.biz.lock;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;

/**
 * test lock to be continued
 */
public class Client {

	private SessionFactory	sf;

	@Before
	public void configure() throws Exception {
		Configuration cfg=new Configuration();
		cfg.configure();
		sf = cfg.buildSessionFactory();
	}

}
