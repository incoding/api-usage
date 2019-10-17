package com.javaapi.test.spring.spring.custom.controllerlog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by user on 2019/8/3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface WebLog {
    /**
     * 打印请求
     *
     * @return
     */
    boolean printReq() default true;

    /**
     * 打印返回
     *
     * @return
     */
    boolean printResp() default true;

    /**
     * 移除数据
     *
     * @return
     */
    boolean isRemove() default true;
}
