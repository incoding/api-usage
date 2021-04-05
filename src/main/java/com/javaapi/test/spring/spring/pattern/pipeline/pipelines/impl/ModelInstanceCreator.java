package com.javaapi.test.spring.spring.pattern.pipeline.pipelines.impl;

import com.javaapi.test.spring.spring.pattern.pipeline.context.impl.InstanceBuildContext;
import com.javaapi.test.spring.spring.pattern.pipeline.pipelines.ContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2021/4/4.
 */
@Component
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handle(InstanceBuildContext context) {
        logger.info("--根据输入数据创建模型实例--");

        // 假装创建模型实例

        return true;
    }
}