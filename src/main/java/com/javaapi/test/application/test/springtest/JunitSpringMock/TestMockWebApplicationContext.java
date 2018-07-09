package com.javaapi.test.application.test.springtest.JunitSpringMock;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 这个例子是生效的,可以设置正确得mockservletcontext进去
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@WebAppConfiguration("file:/home/kk/www/")
public class TestMockWebApplicationContext {

    @Autowired
    TestMock testMock;
    @Test
    public void test() {
        WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        System.out.println(currentWebApplicationContext.getServletContext());

    }

    @Test
    public void testServletContext() {
        ServletContext servletContext = testMock.getServletContext();
        System.out.println(servletContext);
        System.out.println(servletContext.getRealPath("/"));
    }

}
