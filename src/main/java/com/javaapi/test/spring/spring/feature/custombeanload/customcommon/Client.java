package com.javaapi.test.spring.spring.feature.custombeanload.customcommon;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
refer https://www.jianshu.com/p/7c2948f64b1c
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Slf4j
public class Client {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test() {
        InjectClass bean = applicationContext.getBean(InjectClass.class);
        log.info("bean ={}",bean);
    }

}
