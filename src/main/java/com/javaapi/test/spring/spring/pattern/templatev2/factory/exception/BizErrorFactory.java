package com.javaapi.test.spring.spring.pattern.templatev2.factory.exception;


import com.javaapi.test.spring.spring.pattern.template.error.AbstractErrorFactory;
import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 * Integration模块错误工厂
 */
public class BizErrorFactory extends AbstractErrorFactory {

    /**
     * 获取ErrorFactory单例
     *
     * @return instance instance
     */
    public static BizErrorFactory getInstance() {
        return BizErrorFactoryHolder.INSTANCE;
    }

    /**
     * Provide ERROR bundle name string.
     *
     * @return the string
     */
    @Override
    protected String provideErrorBundleName() {
        return "paymentcore-biz";
    }

    /**
     * 系统异常
     * message: 系统异常，异常信息:{0}
     *
     * @param obj
     * @return
     */
    public BaseError systemError(Object obj) {
        return AbstractErrorFactory.createStaticError(String.valueOf(obj), "XX0510300000");
    }

    /**
     * {0}参数无效
     *
     * @return
     */
    public BaseError paramNull(Object obj) {
        return createError("XX0510300001", obj);
    }

    /**
     * 重复交易
     *
     * @return
     */
    public BaseError repeatTrade() {
        return createError("XX0510300002");
    }


    /**
     * 单例实现
     */
    private static final class BizErrorFactoryHolder {
        /**
         * instance
         */
        private static final BizErrorFactory INSTANCE = new BizErrorFactory();
    }

}
