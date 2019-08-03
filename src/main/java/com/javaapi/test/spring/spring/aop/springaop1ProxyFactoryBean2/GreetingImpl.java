package com.javaapi.test.spring.spring.aop.springaop1ProxyFactoryBean2;

import com.javaapi.test.spring.spring.aop.springaop.Greeting;
import org.springframework.stereotype.Component;

@Component("greetingImpl")
public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }

    @Override
    public void sayGoodBye(String name) {
        this.sayHello("jack");
        System.out.println("GoodBye! " + name);
    }
}