package com.javaapi.test.spring.spring.pattern.pipeline.pipelines.impl.common;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.spring.spring.pattern.pipeline.context.PipelineContext;
import com.javaapi.test.spring.spring.pattern.pipeline.pipelines.ContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by user on 2021/4/4.
 */
@Component
public class CommonTailHandler implements ContextHandler<PipelineContext> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(PipelineContext context) {
        // 设置处理结束时间
        context.setEndTime(LocalDateTime.now());

        logger.info("管道执行完毕：context={}", JSON.toJSONString(context));

        return true;
    }
}