package com.javaapi.test.application.test.springtest.JunitSpringMock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 未完成,这个例子是不生效的
 * 
 * @project JavaApiSample
 * @author kk
 * @date 2014年7月4日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:target/classes/com/javaapi/test/spring/springtest/JunitSpringMock/applicationContext.xml")
@Deprecated
public class TestMockServletContext {

    @Autowired
    TestMock testMock;
    @Test
    public void test() {
        System.out.println(testMock.getMockServlet());
		WebApplicationContext web = ContextLoader
				.getCurrentWebApplicationContext();
    }

}
