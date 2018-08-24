package com.javaapi.test.spring.feature.javaconfig.enableAnnotation.Service.importAnnotation;

import com.javaapi.test.spring.feature.javaconfig.enableAnnotation.Service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试自定义注解
 * http://www.jianshu.com/p/c67b29152180
 */
public class Client {
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(
                OtherClass.class);
        CustomerService bean1 = (CustomerService) context.getBean("service1");
        bean1.print();


        CustomerService bean2 = (CustomerService) context.getBean("service2");
        bean2.print();
    }
}
