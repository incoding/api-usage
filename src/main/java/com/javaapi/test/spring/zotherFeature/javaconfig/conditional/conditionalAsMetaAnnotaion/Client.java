package com.javaapi.test.spring.zotherFeature.javaconfig.conditional.conditionalAsMetaAnnotaion;

import com.javaapi.test.spring.zotherFeature.javaconfig.conditional.conditionalAsMetaAnnotaion.Service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * https://www.javacodegeeks.com/2013/10/spring-4-conditional.html
 *
 * http://nezhazheng.com/2014/01/06/spring-conditional-annotation.html
 */
public class Client {



    @Test
    public void testYes() {
        String servicedefault = System.setProperty("servicedefault", "1");
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ContextConfig.class);
        CustomerService bean1 = context.getBean(CustomerService.class);
        bean1.print();


    }
    @Test
      public void testNo() {
//        String servicedefault = System.setProperty("servicedefault", "1");
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ContextConfig.class);
        CustomerService bean1 = context.getBean(CustomerService.class);
        bean1.print();
    }

    @Test
    public void testService1() {
        System.setProperty("servicedefault", "1");
        System.out.println("System.getProperty() = " + System.getProperty("servicedefault"));
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ContextConfig.class);
        CustomerService bean1 = (CustomerService) context.getBean("service1");
        bean1.print();



        CustomerService bean2 = (CustomerService) context.getBean("service2");
        bean2.print();
    }

    @Test
    public void testService2() {
        System.out.println("System.getProperty() = " + System.getProperty("servicedefault"));
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ContextConfig.class);



        CustomerService bean2 = (CustomerService) context.getBean("service2");
        bean2.print();

        CustomerService bean1 = (CustomerService) context.getBean("service1");
        bean1.print();
    }
}
