package com.javaapi.test.spring.feature.config.propertyplaceholder.namespaceUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	@Qualifier("selfPro")
	private Properties properties;

    @Value("#{selfPro[nihao]}")
    private String name;

	@Test
	public void testName() throws Exception {
		String property = properties.getProperty("nihao");
		System.err.println(property);
	}

    @Test
    public void test(){
        System.out.println("name===>"+name);

    }

}
