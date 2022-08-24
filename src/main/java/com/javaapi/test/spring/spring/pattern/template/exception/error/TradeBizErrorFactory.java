
package com.javaapi.test.spring.spring.pattern.template.exception.error;


import com.javaapi.test.spring.spring.pattern.template.error.AbstractErrorFactory;
import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 *
 */
public class TradeBizErrorFactory extends AbstractErrorFactory {

    /**
     * 获取ErrorFactory单例
     *
     * @return instance instance
     */
    public static TradeBizErrorFactory getInstance() {
        return TradeBizErrorFactoryHolder.INSTANCE;
    }

    /**
     *
     */
    @Override
    protected String provideErrorBundleName() {
        return "template-biz";
    }

    /**
     * 系统异常，异常信息:{0}
     *
     * @param message 异常信息
     * @return ERROR
     */
    public BaseError systemError(String message) {
        return createError("ER0000000001", message);
    }

    /**
     * [{0}]参数无效
     *
     * @param param the param
     */
    public BaseError paramInvalid(String param) {
        return createError("ER0000000002", param);
    }


    /**
     * 单例实现
     * TradeBizErrorFactoryHolder instance keeper
     */
    private static final class TradeBizErrorFactoryHolder {
        /**
         * TradeBizErrorFactoryHolder single instance
         */
        private static final TradeBizErrorFactory INSTANCE = new TradeBizErrorFactory();
    }

}