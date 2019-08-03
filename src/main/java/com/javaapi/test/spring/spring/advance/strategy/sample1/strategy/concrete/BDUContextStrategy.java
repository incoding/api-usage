package com.javaapi.test.spring.spring.advance.strategy.sample1.strategy.concrete;

import com.javaapi.test.spring.spring.advance.strategy.sample1.strategy.IContextStrategy;
import org.springframework.stereotype.Component;

@Component
public class BDUContextStrategy implements IContextStrategy {

    @Override
    public void say(String name) {
        // TODO Auto-generated method stub
        System.out.println("百度集团欢迎你："+name);
    }
}
