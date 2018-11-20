package com.javaapi.test.spring.advance.strategy.sample2;

import com.javaapi.test.spring.advance.strategy.sample1.strategy.IContextStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by user on 2018/8/25
 * refer
 * https://blog.csdn.net/nethackatschool/article/details/69293531
 * getClass().isAssignableFrom(baseObj.getClass())
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
    @Autowired
    private Map<String,IContextStrategy> map ;

    @Test
    public void test(){
        System.out.println("map = " + map);
    }
}
