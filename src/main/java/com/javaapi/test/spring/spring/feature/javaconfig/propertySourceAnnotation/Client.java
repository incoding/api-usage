package com.javaapi.test.spring.spring.feature.javaconfig.propertySourceAnnotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * http://www.mkyong.com/spring/spring-propertysources-example/
 * 注意要配置 PropertySourcesPlaceholderConfigurer
 * http://www.mkyong.com/spring/spring-is-not-working-in-value/
 * http://blog.jamesdbloom.com/UsingPropertySourceAndEnvironment.html

    注意 在spring3.2 中想要使用@Value,  读取properties 里的数据,需要一个PropertySourcesPlaceholderConfigurer实例
 To resolve ${} in Spring @Value, you need to declare a STATIC PropertySourcesPlaceholderConfigurer bean manually. For example :


 http://www.baeldung.com/2012/02/06/properties-with-spring/

 */
public class Client {
    @Test
    public void testValueAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = applicationContext.getBean(AppConfig.class);
        //下面俩个都可以用
        bean.print();
        bean.printEnv();
        bean.printXml();
    }

    @Test
    public void testEnv() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigEnv.class);
        AppConfigEnv bean = applicationContext.getBean(AppConfigEnv.class);
        // 不可用
        bean.print();
        // 可以用
        bean.printEnv();
    }
}
