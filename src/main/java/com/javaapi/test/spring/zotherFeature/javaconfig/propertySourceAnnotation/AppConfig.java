package com.javaapi.test.spring.zotherFeature.javaconfig.propertySourceAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * 注意要配置 PropertySourcesPlaceholderConfigurer
 *
 */
@Configuration
@PropertySource("classpath:com/javaapi/test/spring/zotherFeature/javaconfig/propertySourceAnnotation/db.properties")
@ImportResource("classpath:com/javaapi/test/spring/zotherFeature/javaconfig/propertySourceAnnotation/applicationContext.xml")
public class AppConfig {

    @Value("${db.driver}")
    private String driver;

    @Autowired
    private Environment environment;


    private String xmlProperties;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void print(){
        System.out.println("driver = " + driver);
    }

    public void printEnv(){
        System.out.println("environment = " + environment.getProperty("db.driver"));
    }

    public void printXml(){
        System.out.println("xmlProperties = " + xmlProperties);
    }

    public void setXmlProperties(String xmlProperties) {
        this.xmlProperties = xmlProperties;
    }

    public String getXmlProperties() {
        return xmlProperties;
    }
}