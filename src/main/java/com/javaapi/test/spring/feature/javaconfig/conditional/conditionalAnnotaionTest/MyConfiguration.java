package com.javaapi.test.spring.feature.javaconfig.conditional.conditionalAnnotaionTest;

import com.javaapi.test.spring.feature.javaconfig.conditional.conditionalAnnotaionTest.Service.CustomerService;
import com.javaapi.test.spring.feature.javaconfig.conditional.conditionalAnnotaionTest.Service.impl.CustomerServiceImpl1;
import com.javaapi.test.spring.feature.javaconfig.conditional.conditionalAnnotaionTest.Service.impl.CustomerServiceImpl2;
import com.javaapi.test.spring.feature.javaconfig.conditional.conditionalAnnotaionTest.Service.impl.CustomerServiceImpl3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 *只有符合条件的情况下,相关类才会被注册
 *
 * conditional
 * 1 在类级别,对直接或间接标注了@Component,@Configuration
 * 2 参见 @KKConditionalOnSystemProperty,也就是 当做一个meta-annotation,(所谓的meta-annotataion的实例比如说@Retention,@Target,就是了)
 * 3 在方法级别,标注了@Bean
 * 会进行判断
 */
@Configuration
public class MyConfiguration {

    @Bean
    @Conditional(WindowsCondition.class)
    public CustomerService service1() {
        return new CustomerServiceImpl1();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public CustomerService service2() {
        return new CustomerServiceImpl2();
    }

    @Bean
    @Conditional(MacOsCondition.class)
    public CustomerService service3() {
        return new CustomerServiceImpl3();
    }
}