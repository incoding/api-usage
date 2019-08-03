package com.javaapi.test.spring.spring.advance.strategy.sample1;

import com.javaapi.test.spring.spring.advance.strategy.sample1.strategy.context.ContextStrategy;
import com.javaapi.test.spring.spring.advance.strategy.sample1.strategy.IContextStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by user on 2018/8/24
 *https://blog.csdn.net/sinat_21184471/article/details/76862808
 * referrence https://blog.csdn.net/zlts000/article/details/54754789
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
    @Resource
    private ContextStrategy strategyFactory;

    @Test
    public void testStrategy(){
        IContextStrategy doStrategy = strategyFactory.doStrategy("1");
        doStrategy.say("张三");
    }

}
