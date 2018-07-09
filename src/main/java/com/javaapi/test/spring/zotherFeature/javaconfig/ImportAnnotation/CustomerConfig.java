package com.javaapi.test.spring.zotherFeature.javaconfig.ImportAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean(name = "customer")
    public CustomerBo customerBo() {

        return new CustomerBo();

    }

    /**
     * 内部类会自动加载
     */
    @Configuration
    public static class CustomerConfigInner {
        public CustomerConfigInner() {
        }

        @Bean
        public CustomerBo desck() {
            System.out.println("自动加载CustomerConfigInner");
            return new CustomerBo();
        }

    }
}