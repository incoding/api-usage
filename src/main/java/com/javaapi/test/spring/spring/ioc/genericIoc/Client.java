package com.javaapi.test.spring.spring.ioc.genericIoc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *refer  https://my.oschina.net/happyBKs/blog/482508
 * https://my.oschina.net/lifany/blog/704417
 * https://clarkdo.js.org/java/spring/2014/07/03/9/
 * http://jinnianshilongnian.iteye.com/blog/1989330
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        userService.add();
    }

}
