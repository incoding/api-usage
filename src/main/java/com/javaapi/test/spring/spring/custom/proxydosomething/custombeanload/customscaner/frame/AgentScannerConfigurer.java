package com.javaapi.test.spring.spring.custom.proxydosomething.custombeanload.customscaner.frame;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 Created by user on 2019/5/3
 */
public class AgentScannerConfigurer implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    private String basePackage;

    private ApplicationContext applicationContext;


    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    @Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    @Override public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ClassPathBeanDefinitionScanner scanner = new AgentScanner(registry);
        scanner.setResourceLoader(this.applicationContext);

        scanner.addIncludeFilter(new AnnotationTypeFilter(AgentService.class));
        scanner.addExcludeFilter(new TypeFilter() {
            @Override public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                String className = metadataReader.getClassMetadata().getClassName();
                return className.endsWith("package-info");
            }
        });
        int incr = scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS));
        System.out.println("agent class count：" + incr);
    }

    public String getBasePackage() {
        return basePackage;
    }
}


