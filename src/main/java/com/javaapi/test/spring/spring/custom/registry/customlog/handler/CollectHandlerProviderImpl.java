package com.javaapi.test.spring.spring.custom.registry.customlog.handler;

import com.google.common.collect.Maps;
import com.javaapi.test.spring.spring.custom.registry.customlog.aop.CustomLog;
import com.javaapi.test.spring.spring.custom.registry.customlog.constants.Constants;
import com.javaapi.test.spring.spring.custom.registry.customlog.enums.ChildNameEnum;
import com.javaapi.test.spring.spring.custom.registry.customlog.enums.ServiceNameEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CollectHandlerProviderImpl implements ApplicationContextAware, CollectHandlerProvider {

    private final Map<String, DataCollectHandler> dataCollectHandlers = Maps.newConcurrentMap();
    private static final Map<String, List<String>> HANDLER_NAME_GROUP_MAP = Maps.newConcurrentMap();

    private static final Logger logger = LoggerFactory.getLogger(CollectHandlerProviderImpl.class);

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public DataCollectHandler queryCollectHandler(CustomLog dataGalaxy) {
        String handlerTag = generateHandlerTag(dataGalaxy.serviceName(), dataGalaxy.childName());
        return dataCollectHandlers.get(handlerTag) == null ? dataCollectHandlers.get(Constants.DEFAULT_HANDLER_TAG) : dataCollectHandlers.get(handlerTag);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, List<String>> getHandlerNameGroupMap() {
        return HANDLER_NAME_GROUP_MAP;
    }


    /**
     * 容器初始化时注册所有handler
     */
    private void registerDataCollectHandlers() {
        Map<String, DataCollectHandler> handlers = applicationContext.getBeansOfType(DataCollectHandler.class, false, true);
        for (DataCollectHandler handler : handlers.values()) {
            CustomLogHandler anno = handler.getClass().getDeclaredAnnotation(CustomLogHandler.class);
            if (anno == null) {
                throw new IllegalStateException(
                        "Cannot register Validator, please make sure place annotation @DataGalaxyHandler on dataCollectHandler: " + handler.getClass().getName());
            }
            String handlerTag = generateHandlerTag(anno.serviceName(), anno.childName());
            DataCollectHandler h = dataCollectHandlers.get(handlerTag);
            if (h != null) {
                throw new IllegalStateException(
                        "Cannot register handler, the service name has been register by other DataGalaxyHandler handler, handler: " + handler.getClass().getName());
            }
            dataCollectHandlers.put(handlerTag, handler);
            logger.info("Register DataCollectHandler: {} - {}", handlerTag, handler.getClass().getName());
        }
    }

    /**
     * 初始化handler分组，用于分组删除lockkey
     */
    private void initHandlerNameGroupMap() {
        for (DataCollectHandler handler : dataCollectHandlers.values()) {
            CustomLogHandler anno = handler.getClass().getDeclaredAnnotation(CustomLogHandler.class);
            String serviceName = anno.serviceName().name();
            List<String> handlerNameList = HANDLER_NAME_GROUP_MAP.get(serviceName);
            if (handlerNameList == null) {
                handlerNameList = new ArrayList<>();
            }
            handlerNameList.add(handler.getClass().getName());
            HANDLER_NAME_GROUP_MAP.put(serviceName, handlerNameList);
        }
    }

    private String generateHandlerTag(ServiceNameEnum serviceName, ChildNameEnum childName) {
        return serviceName.name() + Constants.SERVICE_ID_SEPARATOR + childName.name();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("CollectHandlerProviderImpl startup");
        registerDataCollectHandlers();
        initHandlerNameGroupMap();
        logger.info("CollectHandlerProviderImpl finish");

    }
}
