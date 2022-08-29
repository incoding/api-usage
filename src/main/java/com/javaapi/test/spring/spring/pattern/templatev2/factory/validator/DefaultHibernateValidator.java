package com.javaapi.test.spring.spring.pattern.templatev2.factory.validator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 普通属性使用hibernate-validator特性验证
 * 嵌套的需要自己取出相关属性
 **/
@Component
public class DefaultHibernateValidator {

    private Validator validator;

    @PostConstruct
    private void init() {
        validator = Validation.byDefaultProvider().configure().messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("apiMessages")))
                              .buildValidatorFactory().getValidator();
    }

    public Map<String, String> validate(Object obj) {
        if (obj != null) {
            Set<ConstraintViolation<Object>> set = validator.validate(obj);
            if (set != null) {
                final Map<String, String> map = new HashMap<>((int) (set.size() * 1.5));
                set.forEach((a) -> {
                    map.put(a.getPropertyPath().toString(), a.getMessage());
                });
                return map;
            }
        }
        return null;
    }

    /**
     * 参数校验
     *
     * @param obj
     * @return
     */
    public String validateObj(Object obj) {
        if (obj == null) {
            return "请求对象不能为空";
        }
        Map<String, String> map = validate(obj);
        if (map != null && map.size() > 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Map.Entry<String, String> en : map.entrySet()) {
                if (i++ != 0) {
                    sb.append(",");
                }
                sb.append(en.getKey() + "" + en.getValue());
            }

            return sb.toString();
        }

        return "";
    }
}
