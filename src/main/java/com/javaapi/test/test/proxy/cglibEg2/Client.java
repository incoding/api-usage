package com.javaapi.test.test.proxy.cglibEg2;

/**
 * http://my.oschina.net/bairrfhoinn/blog/144812
 *
 */
public class Client {

	public static void main(String[] args) {
		TableDAO tableDao = TableDAOFactory.getInstance();
		tableDao.create();
		tableDao.query();
		tableDao.update();
		tableDao.delete();
	}
}