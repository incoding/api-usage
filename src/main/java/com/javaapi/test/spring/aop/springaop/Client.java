package com.javaapi.test.spring.aop.springaop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * 利用ProxyFactory , 编程方式实现增强,顺带解释一个bug
 *  http://my.oschina.net/mushui/blog/161387
 *  http://my.oschina.net/huangyong/blog/161338?fromerr=xDAt65so
 *  =======
 *  代理实现aop,
 *  可以将advisor,advice, 整合起来,达到自动生成代理的目的
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();     // 创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());         // 射入目标类对象
        proxyFactory.addAdvice(new GreetingBeforeAdvice()); // 添加前置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());  // 添加后置增强 
        Greeting greeting = (Greeting) proxyFactory.getProxy(); // 从代理工厂中获取代理
        greeting.sayHello("Jack");                              // 调用代理的方法
        System.out.println("-----------");
        greeting.sayGoodBye("kk");
    }
}