package com.javaapi.test.spring.aop.aspectj.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.javaapi.test.spring.aop.aspectj.CustomerBo;

/**
 * http://pingping0524.iteye.com/blog/262482
 *
 */
public class ClientPlain {
	@Test
	public void test() {
		String path=ClientPlain.class.getResource("").getPath();
		String filename = "file:" +path+"applicationContext.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext(filename);
		CustomerBo customerBo = (CustomerBo) app.getBean("customerBoImp");
		customerBo.addCustomer();
	}

    /**
     * 1 测试jdk的代理能赋值给实现类么
     * 答案:不能,会报错
     * java.lang.ClassCastException: com.sun.proxy.$Proxy10 cannot be cast to com.javaapi.test.spring.aop.aspectj.annotation.CustomerBoImp
       所以jdk得代理只能赋值给接口
       2  cglib的代理既能赋值给接口,又能赋值给实现类 @see com.javaapi.test.spring.aop.springaop2AutoProxy2.ClientPlain2
     */
    @Test
    public void test2() {
        String path=ClientPlain.class.getResource("").getPath();
        String filename = "file:" +path+"applicationContext.xml";
        ApplicationContext app=new FileSystemXmlApplicationContext(filename);
        CustomerBoImp customerBo = (CustomerBoImp) app.getBean("customerBoImp");
        customerBo.addCustomer();
    }
}
