package com.javaapi.test.spring.spring.aop.springaop1ProxyFactoryBean3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring这种可以对指定类,或者指定接口的所有方法进行拦截.</br>
 * <strong>但是如果我想拦截指定的类得指定方法应该怎么样那?</strong></br>
 * 答:
 * ﻿在上面的示例中，Advice会代理目标类的所有方法。如果要代理目标类的指定方法，则需要使用Spring提供的 org.springframework.aop.support.RegexpMethodPointcutAdvisor类
 *
 * 
 *自己猜想: 应该想 interceptorNames中添加切面(包含advice和pointcut),就可以对指定方法进行拦截
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	@Qualifier("greetingProxy")
    Greeting greeting;

	@Test
	public void test() {
		greeting.sayHello("Jack");
		greeting.goodMorning("kk");
		greeting.goodNight("kk");
	}
}