package com.javaapi.test.spring.feature.javaconfig.configurationAnnotataion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * java config 与xml可以等价
 * 所谓的java config 和注解还是有点不同
 *
 * 用@Configuration注解该类，等价 与XML中配置beans；用@Bean标注方法等价于XML中配置bean。

 */
public class SpringTest {
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/bean.xml");// 读取bean.xml中的内容
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Counter c = annotationContext.getBean(Counter.class);// 创建bean的引用对象
        System.out.println(c.getMultiplier());
    }
}