package com.javaapi.test.spring.advance.strategy.sample1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by user on 2018/8/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
    @Resource
    private ContextStrategyFactory strategyFactory;

    @Test
    public void testStrategy(){
        IContextStrategy doStrategy = strategyFactory.doStrategy("1");
        doStrategy.say("张三");
    }

}
