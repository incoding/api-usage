package com.javaapi.test.spring.spring.pattern.template.exception;


import com.javaapi.test.spring.spring.pattern.template.error.AbstractErrorFactory;
import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 * 基础异常，所有的异常定义都应继承该异常
 */
public class BaseException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 错误描述
     */
    private String message;

    /**
     * 错误消息对象
     */
    private BaseError i18nError;

    /**
     * 构造方法
     *
     * @param error 错误实例
     */
    public BaseException(BaseError error) {
        super();
        setError(error);
    }

    /**
     * 构造方法
     *
     * @param error 错误实例
     * @param cause 异常
     */
    public BaseException(BaseError error, Throwable cause) {
        super(ExceptionHelper.unwrap(cause));
        setError(error);
    }

    /**
     * 构造方法
     *
     * @param cause 异常
     */
    public BaseException(Throwable cause) {
        super(ExceptionHelper.unwrap(cause));
        if (cause != null) {
            setError(AbstractErrorFactory.createStaticError(cause.getMessage() + " (" + cause.getClass().getName() + ")", BaseError.DEFAULT_ERROR_CODE));
        }
    }

    /**
     * 获取该异常的错误消息
     *
     * @return 错误消息
     */
    public BaseError getError() {
        return i18nError;
    }

    /**
     * 获取错误消息的错误码
     *
     * @return
     */
    public String getErrorCode() {
        return i18nError == null ? BaseError.DEFAULT_ERROR_CODE : i18nError.getCode();
    }

    /**
     * @return
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 在原错误信息基础上，添加额外错误描述
     *
     * @param s
     */
    protected void appendMessage(String s) {
        message += s;
    }

    /**
     * 预处理消息
     *
     * @param s
     */
    protected void prependMessage(String s) {
        message = message + ". " + s;
    }

    /**
     * 设置异常的错误消息
     * <p>
     * 一般来说，一条错误消息针对资源文件中的一条配置记录
     * 错误码＝错误描述
     *
     * @param error 资源文件描述的错误消息
     */
    protected void setError(BaseError error) {
        this.message = error.getMessage();
        this.i18nError = error;
    }

}