package com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalMany;

import com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalAsMetaAnnotaion.Service.CustomerService;
import com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalAsMetaAnnotaion.Service.impl.CustomerServiceImpl1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {

    @Bean
    @KKConditionalOnSystemProperty("servicedefault_1")
    @KKConditionalOnSystem2Property("servicedefault_2")
    public CustomerService service1() {
        return new CustomerServiceImpl1();
    }


}
