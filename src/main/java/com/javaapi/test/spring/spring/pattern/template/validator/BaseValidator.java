
package com.javaapi.test.spring.spring.pattern.template.validator;

import com.javaapi.test.spring.spring.pattern.template.exception.ValidationException;
import com.javaapi.test.spring.spring.pattern.template.exception.error.TradeBizErrorFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 校验器
 *
 * @param <Request> the type parameter
 * @author jyl25609
 * @version Id : BaseValidator, v 0.1 17-8-15 下午4:01 jyl25609 Exp $
 */
public abstract class BaseValidator<Request extends Serializable> implements Validator<Request> {
    /**
     * ERROR FACTORY
     */
    protected static final TradeBizErrorFactory ERROR = TradeBizErrorFactory.getInstance();

    /**
     * 非null判断
     *
     * @param param 属性值
     * @param msg   异常提示信息
     * @throws ValidationException 参数校验异常
     */
    protected void notNull(Object param, String msg) throws ValidationException {
        if (param == null) {
            throw new ValidationException(ERROR.paramInvalid(msg));
        }
    }

    /**
     * 字符串非空白
     *
     * @param param 属性值
     * @param msg   异常提示信息
     * @throws ValidationException 参数校验异常
     */
    protected void stringIsNotBlank(String param, String msg) throws ValidationException {
        if (StringUtils.isBlank(param)) {
            throw new ValidationException(ERROR.paramInvalid(msg));
        }
    }


}
