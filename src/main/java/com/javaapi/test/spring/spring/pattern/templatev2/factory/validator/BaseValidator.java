package com.javaapi.test.spring.spring.pattern.templatev2.factory.validator;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.BizErrorFactory;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.ValidatorException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

/**
 *
 */
public class BaseValidator {

    @Resource
    private DefaultHibernateValidator defaultHibernateValidator;

    /**
     * The Error factory
     */
    protected static final BizErrorFactory ERROR_FACTORY = BizErrorFactory.getInstance();

    /**
     * 通过hibernateValidation实现通用验证2017-11-22
     *
     * @param obj
     * @return
     * @throws ValidatorException
     */
    public void baseValidate(Object obj) throws ValidatorException {
        if (obj == null) {
            throw new ValidatorException(ERROR_FACTORY.paramNull("请求对象不能为空"), "请求对象为空");
        }
        Map<String, String> map = defaultHibernateValidator.validate(obj);
        if (map != null && map.size() > 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Map.Entry<String, String> en : map.entrySet()) {
                if (i++ != 0) {
                    sb.append(",");
                }
                sb.append(en.getKey()).append(":").append(en.getValue());
            }
            throw new ValidatorException(ERROR_FACTORY.paramNull(sb.toString()), "请求参数为空：" + sb.toString());
        }
    }

    /**
     * 参数不为空
     *
     * @param value 入参
     * @throws ValidatorException
     */
    protected void dtoNotNullValidate(Object value, String message) throws ValidatorException {
        if (value == null) {
            throw new ValidatorException(ERROR_FACTORY.paramNull(message));
        }
    }

    /**
     * 字符串不为空或空字符串
     *
     * @param value 入参
     * @throws ValidatorException
     */
    protected void dtoNotStringEmptyValidate(String value, String message) throws ValidatorException {
        if (StringUtils.isBlank(value)) {
            throw new ValidatorException(ERROR_FACTORY.paramNull(message));
        }
    }

    /**
     * 集合不为空或空字符串
     *
     * @param value 入参
     * @throws ValidatorException
     */
    protected void dtoNotCollectionEmptyValidate(Collection<?> value, String message) throws ValidatorException {
        if (CollectionUtils.isEmpty(value)) {
            throw new ValidatorException(ERROR_FACTORY.paramNull(message));
        }
    }

}