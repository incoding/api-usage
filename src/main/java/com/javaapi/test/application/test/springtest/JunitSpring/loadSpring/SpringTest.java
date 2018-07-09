package com.javaapi.test.application.test.springtest.JunitSpring.loadSpring;

import com.javaapi.test.application.test.springtest.JunitSpring.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * http://pingping0524.iteye.com/blog/262482
 *
 */
public class SpringTest {
	@Test
	public void test() {
		String path=SpringTest.class.getResource("").getPath();
		String filename = path+"applicationContext.xml";
        System.out.println(filename);
        ApplicationContext app = new FileSystemXmlApplicationContext("file:" + filename);
		School school=(School)app.getBean("school");
		school.haveClass();//上课
	}
}
