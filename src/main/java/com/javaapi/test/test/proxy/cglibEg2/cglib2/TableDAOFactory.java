package com.javaapi.test.test.proxy.cglibEg2.cglib2;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import com.javaapi.test.test.proxy.cglibEg2.cglib1.AuthProxy;


public class TableDAOFactory {
	private static TableDAO tDao = new TableDAO();
	public static TableDAO getAuthInstanceByFilter(AuthProxy authProxy){
		Enhancer en = new Enhancer();
		en.setSuperclass(TableDAO.class);
		en.setCallbacks(new Callback[]{authProxy,NoOp.INSTANCE});
		en.setCallbackFilter(new AuthProxyFilter());
		return (TableDAO)en.create();
	}
	
}