package com.javaapi.test.test.testProxy.cglib.cglibaop;

import java.lang.reflect.Method;

import com.javaapi.test.test.testProxy.cglib.Dog;
import com.javaapi.test.test.testProxy.cglib.IAnimal;
import com.javaapi.test.test.testProxy.cglib.Person;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
  
public class CglibObjectProxy {  
  
    @SuppressWarnings("rawtypes")  
    public static Object ceateProxtObject(final Object object,Class clazz) {  
        // 声明增加类实例  
        Enhancer en = new Enhancer();  
        // 设置被代理类字节码，CGLIB根据字节码生成被代理类的子类  
        en.setSuperclass(clazz);  
        // 设置回调函数，即一个方法拦截  
        en.setCallback(new MethodInterceptor() {  
  
            @Override  
            public Object intercept(Object arg0, Method method, Object[] args,  
                    MethodProxy arg3) throws Throwable {  
                  System.out.println("方法调用前");
                // 注意参数object,仍然为外部声明的源对象，且Method为JDK的Method反射  
                Object o = method.invoke(object, args);  
                System.out.println("方法调用后");
                return o;  
            }  
        });  
        return en.create();  
    }  
      
    public static void main(String[] args) {  
        // 未实现接口的类的代理  
        Person proxyPerson=(Person) CglibObjectProxy.ceateProxtObject(new Person(),Person.class);  
        proxyPerson.active("Talk with sb.");  
        // 实现接口的类的代理  
        IAnimal proxyDog=(IAnimal) CglibObjectProxy.ceateProxtObject(new Dog(),Dog.class);  
        proxyDog.active("Dog lying ...........");  
          
    }  
  
}  