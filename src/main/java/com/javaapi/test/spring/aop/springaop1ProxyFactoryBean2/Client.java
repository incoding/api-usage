package com.javaapi.test.spring.aop.springaop1ProxyFactoryBean2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 这个是feature介绍
 * aop引入增强 http://my.oschina.net/huangyong/blog/161338
 *
 *
 * 什么是引入增强:
 *  比如让 GreetingImpl 类无需直接实现 Apology 接口
 */
public class Client {
    public static void main(String[] args) {
    	String path=Client.class.getResource("").getPath();
        ApplicationContext context = new FileSystemXmlApplicationContext("file:"+path+"applicationContext.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy"); // 注意：转型为目标类，而并非它的 Greeting 接口
        greetingImpl.sayHello("Jack");
//        Apology apology = (Apology) greetingImpl; // 将目标类强制向上转型为 Apology 接口（这是引入增强给我们带来的特性，也就是“接口动态实现”功能）
//        apology.saySorry("Jack");
    }
}