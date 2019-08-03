package com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalMany;

import com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalAsMetaAnnotaion.Service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * https://www.javacodegeeks.com/2013/10/spring-4-conditional.html
 * <p>
 * http://nezhazheng.com/2014/01/06/spring-conditional-annotation.html
 */
public class Client {

    /**
     * 俩个注解里有一个成立就成立
     */
    @Test
    public void testYes() {
        String servicedefault = System.setProperty("servicedefault_1", "1");
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ContextConfig.class);
        CustomerService bean1 = context.getBean(CustomerService.class);
        bean1.print();
    }


    @Test
    public void testYes2() {
        String servicedefault = System.setProperty("servicedefault_1", "1");
        String servicedefault2 = System.setProperty("servicedefault_2", "1");
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ContextConfig.class);
        CustomerService bean1 = context.getBean(CustomerService.class);
        bean1.print();
    }

    /**
     * 一个都不成立就不成立
     */
    @Test
    public void testNo() {
//        String servicedefault = System.setProperty("servicedefault", "1");
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ContextConfig.class);
        CustomerService bean1 = context.getBean(CustomerService.class);
        bean1.print();
    }


}
