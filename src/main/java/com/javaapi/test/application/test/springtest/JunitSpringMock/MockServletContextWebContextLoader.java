package com.javaapi.test.application.test.springtest.JunitSpringMock;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.support.AbstractContextLoader;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 未完成,这个例子是不生效的
 * 
 * @project JavaApiSample
 * @author kk
 * @date 2014年7月4日
 */
@Deprecated
public class MockServletContextWebContextLoader extends AbstractContextLoader {

    @Override
    public final ConfigurableApplicationContext loadContext(String... locations) throws Exception {
        ConfigurableWebApplicationContext context = new XmlWebApplicationContext();
        context.setServletContext(new MockServletContext("/target/classes/", new FileSystemResourceLoader()));
        context.setConfigLocations(locations);
        context.refresh();
        AnnotationConfigUtils.registerAnnotationConfigProcessors((BeanDefinitionRegistry) context.getBeanFactory());
        context.registerShutdownHook();
        return context;
    }

    @Override
    protected String getResourceSuffix() {
        return "-context.xml";
    }

    @Override
    public ApplicationContext loadContext(MergedContextConfiguration mergedConfig) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}