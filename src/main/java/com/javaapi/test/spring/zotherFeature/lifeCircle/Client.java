package com.javaapi.test.spring.zotherFeature.lifeCircle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**Spring中bean注入前后的一些操作：
 方式三：使用java注解：@PostConstruct @PreDestroy</br>
    方式二: 使用spring提供的2个接口：InitializingBean,DisposableBean</br>
 *方式一：使用springXML配置中的init-method="init" destroy-method="destory" 这个两个配置，可以实现两个时间点插入定制的操作。</br>
 三种方式执行的优先顺序是：注解>接口>XML配置</br>
 @PostConstruct ,以及@PreDestroy 可以定义多个方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	People people;
	@Autowired
	Teacher teacher;
	@Autowired
	Worker worker;

	@Test
	public void test() {
		System.out.println(people.getName());
	}
}
