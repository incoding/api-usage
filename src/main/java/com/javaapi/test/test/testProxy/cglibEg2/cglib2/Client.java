package com.javaapi.test.test.testProxy.cglibEg2.cglib2;

import com.javaapi.test.test.testProxy.cglibEg2.cglib1.AuthProxy;

/**
 * Boss又来训话了，不行不行，现在除了"张三"其他人都用不了了，现在不可以这样。他们都来向我反映了，必须使用开放查询功能。</br>
 * 哈哈，现在可难不倒我们了，因为我们使用了CGlib。当然最简单的方式是去修改我们的方法拦截器，不过这样会使逻辑变得复杂，且不利于维护。</br>
 * 还好CGlib给我们提供了方法过滤器（CallbackFilter）,CallbackFilte可以明确表明，被代理的类中不同的方法，被哪个拦截器所拦截。下面我们就来做个过滤器用来过滤query方法。
 *
 */
public class Client {
	
	public static void main(String[] args) {
		haveAuthByFilter();
	}
	public static void haveAuthByFilter(){
		TableDAO tDao = TableDAOFactory.getAuthInstanceByFilter(new AuthProxy("张三"));
		tDao.create();
		tDao.query();
		tDao.update();
		tDao.delete();

		tDao = TableDAOFactory.getAuthInstanceByFilter(new AuthProxy("李四"));
		tDao.create();
		tDao.query();
		tDao.update();
		tDao.delete();
	}
}