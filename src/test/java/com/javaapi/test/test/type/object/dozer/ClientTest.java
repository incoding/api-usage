package com.javaapi.test.test.type.object.dozer;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.javaapi.test.test.type.object.sample.spring.bean.FromBean;
import com.javaapi.test.test.type.object.sample.spring.bean.ToBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

@Slf4j
public class ClientTest {

    @Test
    public void test(){
        FromBean fromBean = new FromBean();
        fromBean.setAmount(12.123d);
        log.info("fromBean = " + fromBean);
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        ToBean target = mapper.map(fromBean, ToBean.class);
        log.info("target = " + target);
    }

    @Test
    public void testXml(){
        String path1 = ClientTest.class.getResource("one2oneMapping.xml").getPath();
        log.info(path1);
        String path = ClientTest.class.getResource("one2oneMapping.xml").getPath();
        Mapper mapper = DozerBeanMapperBuilder.create()
                                              .withMappingFiles("file:"+path)
                                              .build();
        FromBean fromBean = new FromBean();
        fromBean.setAmount(12.123d);
        ToBean toBean = new ToBean();
        mapper.map(fromBean,toBean);
        log.info("target:{}",toBean);
    }

    /**
     * 可以实时加载
     */
    @Test
    public void testXmlload(){
        Mapper mapper = DozerBeanMapperBuilder.create().withXmlMapping(new Supplier<InputStream>() {
            @Override
            public InputStream get() {
                return IOUtils.toInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<mappings xmlns=\"http://dozermapper.github.io/schema/bean-mapping\"\n" +
                        "          xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                        "          xsi:schemaLocation=\"http://dozermapper.github.io/schema/bean-mapping http://dozermapper.github.io/schema/bean-mapping.xsd\">\n" +
                        "    <mapping>\n" +
                        "        <class-a>com.javaapi.test.test.type.object.sample.spring.bean.FromBean</class-a>\n" +
                        "        <class-b>com.javaapi.test.test.type.object.sample.spring.bean.ToBean</class-b>\n" +
                        "        <field>\n" +
                        "            <a>amount</a>\n" +
                        "            <b>bigDecimal</b>\n" +
                        "        </field>\n" +
                        "    </mapping>\n" +
                        "</mappings>", StandardCharsets.UTF_8);
            }
        }).build();
        FromBean fromBean = new FromBean();
        fromBean.setAmount(12.123d);
        ToBean toBean = new ToBean();
        mapper.map(fromBean,toBean);
        log.info("target:{}",toBean);
    }

}