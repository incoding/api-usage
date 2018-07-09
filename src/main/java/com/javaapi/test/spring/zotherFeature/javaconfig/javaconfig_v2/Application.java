package com.javaapi.test.spring.zotherFeature.javaconfig.javaconfig_v2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


//http://projects.spring.io/spring-framework/

/**
 * @Configuration
 @Bean
 @DependsOn
 @Primary
 @Lazy
 @Import
 @ImportResource
 @Value
 */
//https://www.ibm.com/developerworks/cn/webservices/ws-springjava/
// javaconfig 使用AnnotationConfigApplicationContext
@ComponentScan
public class Application {

    @Bean
    public School school() {
        return new School(worker());
    }


    @Bean
    public WorkerI worker() {
        TeacherImp teacherImp = new TeacherImp();
        teacherImp.setName("nihao java config");
        return teacherImp;
    }


    @Test
    public void testSchool(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
//        School bean = context.getBean(School.class);
//        bean.haveClass();
        School school = (School) context.getBean("school");
        school.haveClass();

    }

}
