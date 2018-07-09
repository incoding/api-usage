package com.javaapi.test.test.testProxy.cglib.cglibaop;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 优化封装cglib的使用 cglib is a powerful, high performance and quality Code
 * Generation Library, It is used to extend JAVA classes and implements
 * interfaces at runtime</br>
 * 
 * @see http://cglib.sourceforge.net/
 */
public class CglibProxy implements MethodInterceptor {
	private Object srcTarget;
	private List<Aop> aoplist;
	private CglibProxy(Object o, List<Aop> list) {
		this.srcTarget = o;
		this.aoplist=list;
	}
	
	private CglibProxy(Object o) {
		this.srcTarget = o;
	}
	@SuppressWarnings("unchecked")
	public static <T> T proxyTarget(T t,List<Aop> aoplist) {
		Enhancer en = new Enhancer();
		en.setSuperclass(t.getClass());
		en.setCallback(new CglibProxy(t,aoplist));
		T tt = (T) en.create();
		return tt;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		for(Aop aop: aoplist){
			aop.before();
		}
		System.out.println("方法调用前");
		Object o = method.invoke(srcTarget, args);
		System.out.println("方法调用后");
		for(int i=aoplist.size()-1;i>=0;i--){
			aoplist.get(i).after();
		}
		return o;
	}

}