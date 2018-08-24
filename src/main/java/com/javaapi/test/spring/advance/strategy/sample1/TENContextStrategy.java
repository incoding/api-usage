package com.javaapi.test.spring.advance.strategy.sample1;

import org.springframework.stereotype.Component;

@Component
public class TENContextStrategy implements IContextStrategy {

    @Override
    public void say(String name) {
        // TODO Auto-generated method stub
        System.out.println("腾讯集团欢迎你："+name);
    }

}