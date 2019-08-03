package com.javaapi.test.spring.spring.aop.springaop2AutoProxy3AspectJAnnotataion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext2.xml")
public class Client2 {

    @Autowired
    private ApplicationContext context;

    // 获取book得名字的bean为原bean
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
    // 获取bookProxy得名字的bean为代理bean
    @Test
    public void testBookProxy() throws Exception {
        Book book = (Book) context.getBean("bookProxy");

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
