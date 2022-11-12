package com.javaapi.test.spring.spring.pattern.pipelinev2;


import com.javaapi.test.spring.spring.pattern.pipelinev2.pipeline.AbstracePipeline;
import com.javaapi.test.spring.spring.pattern.pipelinev2.pipeline.PipelineProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Deprecated
@Slf4j
@Component
public class LimiterPipeline extends AbstracePipeline<OrderContext> {

    @Override
    public void execute(OrderContext orderContext, PipelineProxy proxy) {
        log.info("限制前param={}", orderContext.getTraceId());
        proxy.execute(orderContext, proxy);
        log.info("限制后param={}", orderContext.getTraceId());
    }

}
