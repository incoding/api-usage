package com.javaapi.test.spring.spring.pattern.templatev3;

import com.alibaba.fastjson.JSONObject;
import com.javaapi.test.spring.spring.pattern.templatev3.annotation.ExportTypeStrategy;
import com.javaapi.test.spring.spring.pattern.templatev3.annotation.ExportTypeStrategyHandler;
import com.javaapi.test.spring.spring.pattern.templatev3.enums.ExportTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


@Configuration
@Slf4j
public class IExportStrategyConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Bean
    public IExportExcelRunner exportExcelRunner() {
        Map<String, Object> strategyClass = applicationContext.getBeansWithAnnotation(ExportTypeStrategy.class);
        Map<String, BiFunction<HttpServletResponse, CommonExportReqVO, Void>> stringFunctionMap = new HashMap<>();

        for (Object value : strategyClass.values()) {
            //获取导出类型模板
            ExportTypeEnum exportType = value.getClass().getAnnotation(ExportTypeStrategy.class).exportType();
            for (Method method : value.getClass().getMethods()) {
                //将要执行的方法放入map
                if (method.isAnnotationPresent(ExportTypeStrategyHandler.class)) {
                    stringFunctionMap.put(exportType.getExportTemplate(),
                            (response, exportReqVO) -> {
                                try {
                                    method.invoke(value, response, exportReqVO);
                                    return null;
                                } catch (IllegalAccessException ex) {
                                    log.error("IExportStrategyConfig exportExcelRunner error exportReqVO:{}", JSONObject.toJSONString(exportReqVO), ex);
                                    throw new RuntimeException(ex);
                                } catch (InvocationTargetException ex) {
                                    log.error("IExportStrategyConfig exportExcelRunner error exportReqVO:{}", JSONObject.toJSONString(exportReqVO), ex);
                                    throw new RuntimeException(ex);
                                } catch (Exception e) {
                                    log.error("IExportStrategyConfig exportExcelRunner error exportReqVO:{}", JSONObject.toJSONString(exportReqVO), e);
                                    throw e;
                                }
                            });
                    break;
                }
            }
        }
        return (response, exportReqVO) -> stringFunctionMap.get(ExportTypeEnum.getaClassByExportType(exportReqVO.getExportType()).getExportTemplate())
                .apply(response, exportReqVO);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
