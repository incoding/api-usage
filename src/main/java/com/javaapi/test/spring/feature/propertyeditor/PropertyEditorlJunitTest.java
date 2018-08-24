package com.javaapi.test.spring.feature.propertyeditor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 *  https://my.oschina.net/sugarZone/blog/705169
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "applicationContext.xml")
public class PropertyEditorlJunitTest {

    @Resource
    private PersonEntity personEntity;

    @Test
    public void testPropertyEditor() {
        Telephone telephone = personEntity.getTelephone();
        System.out.printf("区号:%s，号码：%s\n", telephone.getAreaCode(), telephone.getPhone());
    }
}