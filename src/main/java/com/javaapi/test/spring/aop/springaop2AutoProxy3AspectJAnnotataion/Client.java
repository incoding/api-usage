package com.javaapi.test.spring.aop.springaop2AutoProxy3AspectJAnnotataion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring 自动代理 ,aspectj
 * 这个不算纯注解的
 * 请看 com.javaapi.test.spring.aop.aspectj.annotation 下的信息
 * 使用 AnnotationAwareAspectJAutoProxyCreator (org.springframework.aop.aspectj.annotation)  自动代理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Autowired
    private ApplicationContext context;

    // 在xml里配置了    <aop:aspectj-autoproxy  proxy-target-class="true"/>,通过AnnotationAwareAspectJAutoProxyCreator自动生成代理对象 ，
    // 通过获取原bean的名字就可以获取到代理对象

    @Test
    public void testNameBook() throws Exception {
        Book book = (Book) context.getBean("book");

        System.out.println("---------------------");

        book.printName();

        System.out.println("---------------------");

        book.printUrl();

        System.out.println("----------------------");

        try {

            book.printThrowException();

        } catch (Exception e) {
            //  e.printStackTrace();
        }


    }


}
