package com.javaapi.test.spring.spring.feature.javaconfig.featureQuality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.lang.annotation.*;
import java.util.Collections;
import java.util.List;


/**
 *
 */
@Configuration
public class TestLoadBalance {

    @LoadBalanced
    @Autowired(required = false)
    private List<RestTemplate> restTemplates = Collections.emptyList();

    @LoadBalanced
    @Autowired(required = false)
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @PostConstruct
    public void qualifyTheTweets() {
        System.out.println("restTemplate:" + this.restTemplate);
        System.out.println("restTemplate:" + this.restTemplates == null ? null : restTemplates.size());
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(TestLoadBalance.class);
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Inherited
    @Qualifier
    public @interface LoadBalanced {
    }

}
