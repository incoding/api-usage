package com.javaapi.test.spring.spring.feature.javaconfig.enableAnnotation.Service;

import com.javaapi.test.spring.spring.feature.javaconfig.enableAnnotation.Service.impl.CustomerServiceImpl1;
import com.javaapi.test.spring.spring.feature.javaconfig.enableAnnotation.Service.impl.CustomerServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {

    @Bean
    public CustomerService service1() {
        return new CustomerServiceImpl1();
    }

    @Bean
    public CustomerService service2() {
        return new CustomerServiceImpl2();
    }
}
