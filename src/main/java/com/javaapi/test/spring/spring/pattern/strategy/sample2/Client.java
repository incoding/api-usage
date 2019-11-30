package com.javaapi.test.spring.spring.pattern.strategy.sample2;

import com.javaapi.test.spring.spring.pattern.strategy.sample1.strategy.IContextStrategy;
import com.javaapi.test.spring.spring.pattern.strategy.sample1.strategy.context.ContextStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;
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
    private List<IContextStrategy> list;

    @Autowired
    private Map<String, IContextStrategy> map;

    @Autowired
    private ContextStrategy contextStrategy;

    @Test
    public void testMap() {
        for (Iterator<Map.Entry<String, IContextStrategy>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, IContextStrategy> next = iterator.next();
            String key = next.getKey();
            IContextStrategy value = next.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }
    }

    @Test
    public void testList() {
        System.out.println("list = " + list);
    }

    @Test
    public void testStrategy() {
        IContextStrategy aLIContextStrategy = contextStrategy.doStrategy("ALIContextStrategy");
        aLIContextStrategy.say("nihao");
    }

}
