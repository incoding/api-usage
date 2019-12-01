package com.javaapi.test.businessdesign.howtoextend.extendGeneric;

import com.javaapi.test.businessdesign.howtoextend.extendGeneric.servicedelegate.ServiceDelegator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 2019/12/1
 */
public abstract class AbstractValidator<Request, Response> implements Validator {
    /**
     * logger
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *
     */
    @Override
    public void validate(ValidationContext context) throws BookValidateException {
        try {
            doInvokeBefore(context);
            // 1.发起外部验证接口调用
            Response response;
            try {
                response = doInvoke(context);
            } catch (Exception e) {
                if (needRetry(e)) {
                    doRetryInvokeBefore(context, e);
                    response = retryDoInvoke(context, e);
                    doRetryInvokeAfter(context, e);
                } else {
                    throw e;
                }

            }
            if (response == null) {
                doIfNull(context);
                return;
            }

            // 2.检查响应结果
            checkResponse(context, response);

            // 3.校验前处理
            doBefore(context, response);

            // 4.进行校验
            check(context, response);

            // 5. 校验后处理
            doPost(context, response);
        } catch (BookValidateException e) {
            handleException(context, e);
            throw e;
        } finally {
            try {
                doFinally(context);
            } catch (Exception e) {
                logger.warn("发送消息失败", e);
            }
        }
    }

    /**
     * 针对该异常是否需要重试。默认不重试
     *
     * @param e
     * @return
     */
    protected boolean needRetry(Exception e) {
        return false;
    }

    //发起校验前工作
    protected void doInvokeBefore(ValidationContext context) {

    }

    //重试发起校验前工作
    protected void doRetryInvokeBefore(ValidationContext context, Exception e) {

    }

    protected void doRetryInvokeAfter(ValidationContext context, Exception e) {
    }

    /**
     * 当结果为空的时候需要处理的业务
     *
     * @param context
     */
    protected void doIfNull(ValidationContext context) throws BookValidateException {

    }

    /**
     * 验舱验价整体结果推送
     *
     * @param e
     */
    protected void handleException(ValidationContext context, BookValidateException e) {

    }

    /**
     * 推送验舱，验价信息。只要有结果。不关系整体是否抛异常
     *
     * @param context
     */
    protected void doFinally(ValidationContext context) {
    }

    /**
     * 验证逻辑
     *
     * @param context
     * @param response
     */
    protected abstract void check(ValidationContext context, Response response) throws BookValidateException;

    /**
     * 获取验证的请求服务代理对象
     *
     * @return
     */
    protected abstract ServiceDelegator<Response> getServiceDelegator();

    /**
     * 校验前处理
     *
     * @param context
     * @param response
     */
    protected void doBefore(ValidationContext context, Response response) throws BookValidateException {
        // no-op
    }

    /**
     * 验证响应体是否符合后续流程
     *
     * @param context
     * @param response
     */
    protected void checkResponse(ValidationContext context, Response response) throws BookValidateException {
        // no-op
    }

    /**
     * 验证后处理
     *
     * @param context
     * @param response
     */
    protected void doPost(ValidationContext context, Response response) {
        // no-op
    }

    /**
     * @param context
     * @param e
     */
    protected void handleError(ValidationContext context, BookValidateException e) throws BookValidateException {
        // 默认不进行容错
        throw e;
    }

    /**
     * @param context
     * @param e
     */
    protected void retryHandleError(ValidationContext context, BookValidateException e) throws BookValidateException {
        // 默认不进行容错
        throw e;
    }

    /**
     * @param context
     * @return
     */
    private Response doInvoke(ValidationContext context) throws BookValidateException {
        try {
            Response response = getServiceDelegator().invoke(context);
            return response;
        } catch (BookValidateException e) {
            handleError(context, e);
            return null;
        }
    }

    /**
     * 发起外部验证接口调用
     *
     * @param context
     * @return
     */
    private Response retryDoInvoke(ValidationContext context, Exception e) throws BookValidateException {
        try {
            Response response = getServiceDelegator().invoke(context);
            return response;
        } catch (BookValidateException ex) {
            retryHandleError(context, ex);
            return null;
        }
    }

}