package com.javaapi.test.spring.ioc.xml.xmlioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.MediaType;


/**
 *测试spring注入默认对象 
 * @project apiTest
 * @author kk
 * @date 2014年8月15日
 */
public class SpringTest {
	@Test
	public void test() {
		String path=SpringTest.class.getResource("").getPath();
		String filename = path+"applicationContext.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
        HtmlPage htmlPage = (HtmlPage) app.getBean("htmlPage");
        System.out.println(htmlPage.toString());
        System.out.println(htmlPage.getList().get(0).getType());
        System.out.println(htmlPage.getList().get(1).getType());
        System.out.println(htmlPage.getPeoplelist().get(0).getName());
        System.out.println(htmlPage.getPeoplelist().get(1).getName());
	}
	@Test
	public void testSingleton() {
		String path=SpringTest.class.getResource("").getPath();
		String filename = path+"applicationContext.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
		HtmlPage htmlPage = (HtmlPage) app.getBean("htmlPage");
		HtmlPage htmlPage2 = (HtmlPage) app.getBean("htmlPage");
		HtmlPage htmlPage3 = (HtmlPage) app.getBean("htmlPage2");
		HtmlPage htmlPage4 = (HtmlPage) app.getBean("htmlPage2");
		System.out.println(htmlPage);
		System.out.println(htmlPage3);
		System.out.println(htmlPage == htmlPage3);
		System.out.println(htmlPage == htmlPage2);
		System.out.println(htmlPage3 == htmlPage4);
	}
	@Test
	public void testPrototype() {
		String path=SpringTest.class.getResource("").getPath();
		String filename = path+"applicationContext_prototype.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
		HtmlPage htmlPage = (HtmlPage) app.getBean("htmlPage");
		HtmlPage htmlPage2 = (HtmlPage) app.getBean("htmlPage");
		HtmlPage htmlPage3 = (HtmlPage) app.getBean("htmlPage2");
		HtmlPage htmlPage4 = (HtmlPage) app.getBean("htmlPage2");
		System.out.println(htmlPage);
		System.out.println(htmlPage3);
		System.out.println(htmlPage == htmlPage3);
		System.out.println(htmlPage == htmlPage2);
		System.out.println(htmlPage3 == htmlPage4);
	}
	/**
	 * 在不同文件中定义相同id得bean,后定义得会完全覆盖先前定义的bean.(注意是完全覆盖,不是合并)
	 */
	@Test
	public void testIfMerge() {
		String path = SpringTest.class.getResource("").getPath();
		String filename = path + "applicationContext_merge.xml";
		ApplicationContext app = new FileSystemXmlApplicationContext("file:"
				+ filename);
		HtmlPage htmlPage = (HtmlPage) app.getBean("htmlPage");
		System.out.println(htmlPage.toString());
		for (MediaType iterable_element : htmlPage.getList()) {
			String type = iterable_element.getType();

			String name = iterable_element.getCharSet().name();
			System.out.println(type+"==>"+name);
		}
		for (People iterable_element : htmlPage.getPeoplelist()) {
			String name = iterable_element.getName();
			String age  = iterable_element.getAge();
			System.out.println(name+"==>"+age);
		}
	}
}
