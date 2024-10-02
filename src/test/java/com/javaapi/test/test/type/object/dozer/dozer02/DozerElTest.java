package com.javaapi.test.test.type.object.dozer.dozer02;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.el.DefaultELEngine;
import com.github.dozermapper.core.el.ELEngine;
import com.javaapi.test.test.type.object.dozer.dozer01.DozerKickstartTest;
import com.javaapi.test.test.type.object.sample.spring.bean.FromBean;
import com.javaapi.test.test.type.object.sample.spring.bean.ToBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.el.ExpressionFactory;

@Slf4j
public class DozerElTest {
    @Test
    public void testEl(){

        String path = DozerElTest.class.getResource("one2oneElMapping.xml").getPath();
        Mapper mapper = DozerBeanMapperBuilder.create()
                                              .withMappingFiles("file:"+path)
                                              .withELEngine(new DefaultELEngine(ExpressionFactory.newInstance()))
                                              .build();
        FromBean fromBean = new FromBean();
        fromBean.setAmount(12.123d);
        fromBean.setName("dozer");

        fromBean.setAddress("dozer address");
        ToBean toBean = new ToBean();
        mapper.map(fromBean,toBean);
        log.info("target:{}",toBean);
    }
}