package com.javaapi.test.spring.spring.feature.javaconfig.propertySourceAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 注意要配置 PropertySourcesPlaceholderConfigurer
 *
 */
@Configuration
@PropertySource("classpath:com/javaapi/test/spring/spring/feature/javaconfig/propertySourceAnnotation/db.properties")
public class AppConfigEnv {

    @Value("${db.driver}")
    private String driver;

    @Autowired
    private Environment environment;


    public void print(){
        System.out.println("driver = " + driver);
    }

    public void printEnv(){
        System.out.println("environment = " + environment.getProperty("db.driver"));
    }
}