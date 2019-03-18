package com.javaapi.test.spring.feature.config.propertyplaceholder.contextplaceholder;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by user on 2019/3/18
 */
public class PropertiesPojo {

    @Value("${nihao}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
