package com.javaapi.test.application.test.springtest.JunitSpringMock;

import org.junit.Test;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 这个例子是生效的
 * 
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
public class TestMockServletContext2 {

    //    @Autowired
    //    TestMock testMock;
    @Test
    public void test() {
		MockServletContext msc = new MockServletContext("file:D:\\program");
        String[] config = { "file:" + TestMockServletContext2.class.getResource("").getPath() + "applicationContext.xml" };
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocations(config);
        context.setServletContext(msc);
        context.refresh();
        msc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
        System.out.println(context.getBean("testMock"));
		TestMock testMock = (TestMock) context.getBean("testMock");
		System.out.println(testMock.getServletContext());
		System.out.println(testMock.getServletContext().getContextPath());
		System.out.println(testMock.getServletContext().getRealPath("/"));
    }

	@Test
    public void test2() {
		String name = "file:"
				+ TestMockServletContext2.class.getResource("").getPath()
				+ "applicationContext.xml";
		MockServletContext msc = new MockServletContext("file:D:\\program");
		msc.setInitParameter("contextConfigLocation", name);
		ContextLoader context = new ContextLoader();
		context.initWebApplicationContext(msc);
		WebApplicationContext currentWebApplicationContext = ContextLoader
				.getCurrentWebApplicationContext();
		System.out.println(currentWebApplicationContext.getServletContext());
		System.out.println(currentWebApplicationContext.getServletContext()
				.getRealPath(""));
    }
}
