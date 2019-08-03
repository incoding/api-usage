package com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalAnnotaionTest;

import com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalAnnotaionTest.Service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试spring包下的conditional
 */
public class Client {


    /**
     *只有符合条件的情况下,相关类才会被注册
     */
    @Test
    public void testYes() {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                MyConfiguration.class);
        CustomerService bean1 = context.getBean(CustomerService.class);
        bean1.print();


    }

}
