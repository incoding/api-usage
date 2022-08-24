package com.javaapi.test.spring.spring.pattern.template.error;


import com.javaapi.test.spring.spring.pattern.template.error.i18n.Message;

/**
 *
 */
public class BaseError extends Message {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 默认错误消息, 应用程序切勿使用该错误信息
     */
    public static final String DEFAULT_ERROR_MSG = "默认错误";

    /**
     * 默认错误码, 应用程序切勿使用该错误码
     */
    public static final String DEFAULT_ERROR_CODE = "defaultCode_0001";

    /**
     * 错误码
     */
    private String code;

    /**
     * @param message    错误文案模板
     * @param messageKey 错误码
     * @param args       错误文案模板占位符参数
     */
    protected BaseError(String errMsg, String code, Object... args) {
        super(errMsg, code, args);
        this.code = code;
    }

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    public String getCode() {
        return code;
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ErrorDTO [code=" + code + ", err=" + getMessage() + "]";
    }
}
