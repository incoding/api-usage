package com.javaapi.test.spring.spring.pattern.event.custom.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class AsyncSpringEventConfig {

    /**
     * 参考
     * https://www.cnblogs.com/caicz/p/15127904.html
     * kkps:一旦配置所有发布器都会用这个,会导致spring内部用的线程池也用SimpleAsyncTaskExecutor ,
     * 所以为了稳定性,最好是分开线程池,(目前还没研究好怎么分开spring内部用的和业务用的).  ps:通过async +event listener 已经可以实现线程池异步了.
     *
     * @return
     */
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return multicaster;
    }

}