package com.javaapi.test.spring.spring.aop.aspectj.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**spring aop 得annotation方式貌似只能用这个aspectj注解
 * aspectj +spring  ,annotation
 * Spring + AspectJ（基于注解）
 * 神一样的老罗总算认识到了这一点，接受了网友们的建议，集成了 AspectJ，同时也保留了以上提到的切面与代理配置方式（为了兼容老的项目，更为了维护自己的面子）。</br>
 * 将 Spring 与 AspectJ 集成与直接使用 AspectJ 是不同的，我们不需要定义 AspectJ 类（它是扩展了 Java 语法的一种新的语言，还需要特定的编译器），只需要使用 AspectJ 切点表达式即可（它是比正则表达式更加友好的表现形式）。
 *
 *
 *
 *  提前扫描所有的advisor,
 *  然后获取bean的时候,使用advisor,看是否能应用自动代理的条件,
 *  如果符合自动代理的条件就用proxyfactory 组装一个代理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	CustomerBo customerBo;

	@Test
	public void test(){
		customerBo.addCustomer();
	}
}
