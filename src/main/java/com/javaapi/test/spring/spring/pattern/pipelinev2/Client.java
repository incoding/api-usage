package com.javaapi.test.spring.spring.pattern.pipelinev2;

import com.javaapi.test.spring.spring.pattern.pipelinev2.pipeline.PipelineProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Deprecated
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Resource
    private PipelineProxy<OrderContext> pipelineProxy;
    @Resource
    private PipelineProxy<OrderContextV2> pipelineProxyV2;

    @Test
    public void test() {
        OrderContext orderContext = new OrderContext();
        orderContext.setTraceId("traceV1");
        pipelineProxy.execute(orderContext, pipelineProxy);
    }

    @Test
    public void test2() {
        OrderContextV2 orderContextv2 = new OrderContextV2();
        orderContextv2.setTraceId("traceV2");
        pipelineProxyV2.execute(orderContextv2, pipelineProxyV2);
    }

    @Test
    public void test3() {
        OrderContext orderContext = new OrderContext();
        orderContext.setTraceId("traceV1");
        pipelineProxy.execute(orderContext, pipelineProxy);

        OrderContextV2 orderContextv2 = new OrderContextV2();
        orderContextv2.setTraceId("traceV2");
        pipelineProxyV2.execute(orderContextv2, pipelineProxyV2);
    }

}
