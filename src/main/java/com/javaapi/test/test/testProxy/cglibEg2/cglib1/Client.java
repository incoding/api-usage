package com.javaapi.test.test.testProxy.cglibEg2.cglib1;

/**
 * Boss告诉我们这些方法不能开放给用户，只有“张三”才有权使用。怎么办，难道我们要在每个方法上面进行判断吗？好像这么做也太那啥了吧，对了对了，Proxy 可能是最好的解决办法。jdk 的代理就可以解决了。</br>
 * 好了我们来动手改造吧。等等，jdk 的代理需要实现接口，这样，我们的dao类需要改变了。既然不想改动dao 又要使用代理，我们这就请出 cglib。我们只需新增一个权限验证的方法拦截器。
 *
 */
public class Client {
	
	public static void main(String[] args) {
		haveAuth();
		haveNoAuth();
	}
	public static void haveAuth(){
		TableDAO tDao = TableDAOFactory.getAuthInstance(new AuthProxy("张三"));
		tDao.create();
		tDao.query();
		tDao.update();
		tDao.delete();
	}
	public static void haveNoAuth(){
		TableDAO tDao = TableDAOFactory.getAuthInstance(new AuthProxy("李四"));
		tDao.create();
		tDao.query();
		tDao.update();
		tDao.delete();
	}
	
}