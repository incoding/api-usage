package com.javaapi.test.spring.feature.bug;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * spring这种可以对指定类,或者指定接口的所有方法进行拦截.</br>
 * <strong>但是如果我想拦截指定的类得指定方法应该怎么样那?</strong></br>
 * 
 * 1 应该想 interceptorNames中添加切面(包含advice和pointcut)
 * 就可以对指定方法进行拦截</br>
 * 1.2 解决:http://jinnianshilongnian.iteye.com/blog/1894973</br>??? 好像这种情况不适用将proxyfactorybean 设置为prototype的情况
 *2  解决Spring中singleton的Bean依赖于prototype的Bean的问题???
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContextBug.xml")
public class ClientBug {
//	 @Autowired
//	 UserClient userClient;
	@Autowired
	@Qualifier("greetingProxy")
	Greeting	greeting;
	
	@Test
	public void test() {
//		userClient.say();
	}
	@Test
	public void test2() {
		greeting.goodMorning("kk");
	}
}