package com.javaapi.test.test.proxy.cglibEg2;

public class TableDAOFactory {
	private static TableDAO tDao = new TableDAO();
	public static TableDAO getInstance(){
		return tDao;
	}
}