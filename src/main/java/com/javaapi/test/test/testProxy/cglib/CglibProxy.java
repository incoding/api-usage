package com.javaapi.test.test.testProxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
  
/**
 * cglib is a powerful, high performance and quality Code Generation Library, It is used to extend JAVA classes and implements interfaces at runtime</br>
 *@see http://cglib.sourceforge.net/
 */
public class CglibProxy implements MethodInterceptor {  
  
    private Object srcTarget;  
  
    private CglibProxy(Object o) {  
        this.srcTarget = o;  
    }  
  
    @SuppressWarnings("unchecked")  
    public static <T> T proxyTarget(T t) {  
        Enhancer en = new Enhancer();  
        en.setSuperclass(t.getClass());  
        en.setCallback(new CglibProxy(t));  
        T tt = (T) en.create();  
        return tt;  
    }  
  
    @Override  
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
    	  System.out.println("方法调用前");
        Object o = method.invoke(srcTarget, args);  
        System.out.println("方法调用后");
        return o;  
    }  
  
    public static void main(String[] args) {  
        // 未实现接口的类的代理  
        Person person = CglibProxy.proxyTarget(new Person());  
        person.active("Tom speaking ........");  
        // 实现接口的类的代理  
        IAnimal dog = CglibProxy.proxyTarget(new Dog());  
        dog.active("Dog is running.........");  
    }  
  
}  