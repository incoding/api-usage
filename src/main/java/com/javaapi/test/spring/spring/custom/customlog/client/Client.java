package com.javaapi.test.spring.spring.custom.customlog.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 自定义注解,可以整合调用链,标识场景具体业务.
 * 比如说下单场景,低下分数据库落单和调用第三方资源,
 * 举例:
 * serviceName可以写BOOK, 然后数据库落单可以写childName为BOOK_DB,第三方资源可以写BOOK_REMOTE
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Autowired
    private BookService bookService;

    @Test
    public void test(){
        BookParam bookParam = new BookParam();
        bookParam.setId("1");
        BookResponse book = bookService.book(bookParam);

    }
}
