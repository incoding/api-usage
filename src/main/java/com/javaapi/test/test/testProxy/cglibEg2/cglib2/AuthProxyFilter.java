package com.javaapi.test.test.testProxy.cglibEg2.cglib2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * 看到了吗，setCallbacks() 中定义了所使用的拦截器，其中 NoOp.INSTANCE 是 CGlib 所提供的实际是一个没有任何操作的拦截器，他们是有序的。</br>
 * 一定要和 CallbackFilter 里面的顺序一致。明白了吗？上面return返回的就是返回的顺序。也就是说如果调用 query 方法就使用 NoOp.INSTANCE 进行拦截。 
 *
 */
public class AuthProxyFilter implements CallbackFilter{
	public int accept(Method arg0) {
		if(!"query".equalsIgnoreCase(arg0.getName()))
			return 0;
		return 1;
	}

}