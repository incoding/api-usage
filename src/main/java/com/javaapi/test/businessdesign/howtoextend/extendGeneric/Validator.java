package com.javaapi.test.businessdesign.howtoextend.extendGeneric;

public interface Validator {

    /**
     * 强校验接口业务逻辑实现
     *
     * @param context
     */
    void validate(ValidationContext context) throws BookValidateException;

    /**
     * 获取校验类型
     *
     * @return
     */
    ValidateTypeEnum getBizType();

    /**
     * 是否执行
     *
     * @param context
     * @return
     */
    boolean isSupported(ValidationContext context) throws BookValidateException;
}
