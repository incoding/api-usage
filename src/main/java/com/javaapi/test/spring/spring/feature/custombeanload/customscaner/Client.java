package com.javaapi.test.spring.spring.feature.custombeanload.customscaner;

import com.javaapi.test.spring.spring.feature.custombeanload.customscaner.agent.CustomServiceInvoker;
import com.javaapi.test.spring.spring.feature.custombeanload.customscaner.frame.AgentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;


/**
    这个注解默认只能扫接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Slf4j
public class Client {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private CustomServiceInvoker customServiceInvoker;

    @Test
    public void test(){
        String[] beanNamesForAnnotation = applicationContext.getBeanNamesForAnnotation(AgentService.class);
        log.info("result = {}",Arrays.toString(beanNamesForAnnotation));

        String s = customServiceInvoker.invokeRemote();
        System.out.println("s = " + s);
    }

}
