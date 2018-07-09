package com.javaapi.test.test.testProxy.cglib.cglibaop;

import java.util.ArrayList;
import java.util.List;

import com.javaapi.test.test.testProxy.cglib.Dog;
import com.javaapi.test.test.testProxy.cglib.IAnimal;
import com.javaapi.test.test.testProxy.cglib.Person;

/**
 * 这种方式的功能能与jdk动态代理一样,既可以不限定类,也可以不限定方法得生成代理
 *
 */
public class Client {
	  
    public static void main(String[] args) {  
    	List<Aop> list=new ArrayList<Aop>();
    	list.add(new AopImp());
    	list.add(new MyAopEg());
        // 未实现接口的类的代理  
        Person person = CglibProxy.proxyTarget(new Person(),list);  
        person.active("Tom speaking ........");  
        // 实现接口的类的代理  
        IAnimal dog = CglibProxy.proxyTarget(new Dog(),list);  
        dog.active("Dog is running.........");  
    }  
}
