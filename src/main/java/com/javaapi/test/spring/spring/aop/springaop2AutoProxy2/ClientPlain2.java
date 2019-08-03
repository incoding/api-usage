package com.javaapi.test.spring.spring.aop.springaop2AutoProxy2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 测试混合情况
 * 多个动态代理可以对一个bean进行多次包装而互不影响
 * 同时进行jdk代理和cglib代理是可以的,不过注意,
 * 1 如果是用了jdk代理,则不能赋值给实现类,要赋值给接口
 * http://blog.csdn.net/u012377333/article/details/50018265
 * 2 如果是用了cglib,可以赋值给实现类,也可以赋值给接口
 */
public class ClientPlain2 {


    @Test
    public void test1() {
        String path = ClientPlain2.class.getResource("").getPath();
        String apppath = "file:" + path + "applicationContext2.xml";
        ApplicationContext app = new FileSystemXmlApplicationContext(apppath);
//         如果是用了jdk代理,则不能赋值给实现类
//        GreetingImpl bean = (GreetingImpl) app.getBean("greetingImpl");
        Greeting bean = (Greeting) app.getBean("greetingImpl");
        bean.goodMorning("kk");
        System.out.println("----------------");

    }


}