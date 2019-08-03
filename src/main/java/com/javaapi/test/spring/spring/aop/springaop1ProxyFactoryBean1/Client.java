package com.javaapi.test.spring.spring.aop.springaop1ProxyFactoryBean1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * http://pingping0524.iteye.com/blog/262482
 *
 */
/**
 * @author wk
 *
 * 利用拦截器实现aop
 *
 */
public class Client {


    @Test
    public void test() {
        String path=Client.class.getResource("").getPath();
        String filename = path+"applicationContext.xml";
        ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
        Greeting school = (Greeting) app.getBean("greetingProxy");
        school.sayHello("kk");
        System.out.println("=======");
        school.sayGoodBy("ll");
    }

    @Test
    public void test2() {
        String path=Client.class.getResource("").getPath();
        String filename = path+"applicationContext.xml";
        ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
        Greeting school = (Greeting) app.getBean("greetingProxy2");
        school.sayHello("kk");
        System.out.println("=======");
        school.sayGoodBy("ll");
    }


    @Test
    public void test3() {
        String path=Client.class.getResource("").getPath();
        String filename = path+"applicationContext.xml";
        ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
        Greeting school = (Greeting) app.getBean("greetingProxy3");
        school.sayHello("kk");
        System.out.println("=======");
        school.sayGoodBy("ll");
    }

    /**
     * @TODO 貌似不生效
     */
	@Test
	public void testÎCommonInteceptorPerformence() {
		String path=Client.class.getResource("").getPath();
		String filename = path+"applicationContext.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
		Greeting school = (Greeting) app.getBean("commonInteceptorPerformence");
		school.sayHello("kk");
        System.out.println("=======");
        school.sayGoodBy("ll");
	}
}
