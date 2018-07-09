package com.javaapi.test.spring.aop.springaop1ProxyFactoryBean1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring这种可以对指定类,或者指定接口的所有方法进行拦截.</br>
 * <strong>但是如果我想拦截指定的类得指定方法应该怎么样那?</strong></br>
 *细粒度得控制,只对具体接口生成代理</br>
 *如果配置事务等,将导致 每个接口都要配置一个代理,非常麻烦
 * 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class ClientSpring {
	@Autowired
	@Qualifier("greetingProxy")
	Greeting greeting;

	@Test
	public void test() {
		greeting.sayHello("Jack");
        //		greeting.sayGoodBy("Jack");
	}
}