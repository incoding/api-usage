package com.javaapi.test.buisness.exception.bussiness.exception_v3.enums;

import com.javaapi.test.buisness.exception.bussiness.exception_v3.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResponseEnum implements BusinessExceptionAssert {
    SERVER_ERROR(500, "服务异常"),
    /**
     * Bad licence type
     */
    BAD_LICENCE_TYPE(7001, "Bad licence type."),
    /**
     * Licence not found
     */
    LICENCE_NOT_FOUND(7002, "Licence not found."),
    ;
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}