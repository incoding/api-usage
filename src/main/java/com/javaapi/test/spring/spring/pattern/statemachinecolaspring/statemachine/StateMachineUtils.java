package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@SuppressWarnings("all")
public class StateMachineUtils {

    /**
     * 根据类型和名字获取枚举实例
     * @param name
     * @param clazz
     * @return
     */
    public static Enum getEnum(String name, Class clazz) {
        Enum anEnum;
        try {
            anEnum = Enum.valueOf(clazz, name);
        } catch (Exception e) {
            log.info("业务暂时不支持,name:{},class:{}",name,clazz);
            throw new IllegalArgumentException("操作暂不支持",e);
        }
        return anEnum;
    }
}
