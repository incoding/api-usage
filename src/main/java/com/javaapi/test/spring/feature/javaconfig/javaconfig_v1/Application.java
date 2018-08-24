package com.javaapi.test.spring.feature.javaconfig.javaconfig_v1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


//http://projects.spring.io/spring-framework/
//http://www.oschina.net/translate/consider-replacing-spring-xml-configuration-with-javaconfig
//http://blog.csdn.net/tanksyg/article/details/8556769
/**
 * @Configuration
 @Bean
 @DependsOn
 @Primary
 http://www.yihaomen.com/article/java/581.htm
 @Lazy
 @Import    导入   java-config
 @ImportResource 导入xml-config
 @Value
 */
@ComponentScan
public class Application {
    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }




    @Test
    public void test(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

    }
    @Test
    public void testSchool(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        School bean = context.getBean(School.class);
        bean.haveClass();
    }

}
