package com.javaapi.test.spring.spring.aop.springaop2AutoProxy2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 1 以上这个例子只能匹配目标类，而不能进一步匹配其中指定的方法，要匹配方法，就要考虑使用切面与切点了
 * http://my.oschina.net/huangyong/blog/161402
 * 2 自动找advisor,自动判断是否符合匹配条件,如果符合匹配条件就应用advice
 */
public class ClientPlain {


    @Test
    public void test1() {
        String path = ClientPlain.class.getResource("").getPath();
        String apppath = "file:" + path + "applicationContext.xml";
        ApplicationContext app = new FileSystemXmlApplicationContext(apppath);
        GreetingImpl bean = (GreetingImpl) app.getBean("greetingImpl");
        bean.goodMorning("kk");
        System.out.println("----------------");

    }

    @Test
    public void test() {
        String path = ClientPlain.class.getResource("")
                .getPath();
        System.out.println(path);
        String apppath = "file:" + path + "applicationContext.xml";
        ApplicationContext app = new FileSystemXmlApplicationContext(apppath);
        GreetingImpl bean = (GreetingImpl) app.getBean("greetingImpl");
        bean.goodMorning("kk");
        System.out.println("----------------");
        System.out.println(bean);
        System.out.println("----------------");
        Greeting2Impl bean2 = (Greeting2Impl) app.getBean("greeting2Impl");
        bean2.goodMorning("kk2");
    }
}