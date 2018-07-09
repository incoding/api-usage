package com.javaapi.test.buisness.dataTrans.json.fastjson.web.listerner;

import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * -------------------------------------------
 * |   @author      |                |
 * -------------------------------------------
 * |    @date       |18/3/18 下午2:35          |
 * -------------------------------------------
 * |   @version     | V1.0                    |
 * -------------------------------------------
 *  解决  fastjson 高版本 autotype is not support 问题
 */
@Component
public class FastJsonApplicationListener implements ApplicationListener {

    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

    }
}
