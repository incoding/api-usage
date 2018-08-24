package com.javaapi.test.spring.advance.strategy.sample1;

import org.springframework.stereotype.Component;

@Component
public class ALIContextStrategy implements IContextStrategy {

    @Override
    public void say(String name) {
        System.out.println("阿里巴巴集团欢迎你："+name);
    }
}
