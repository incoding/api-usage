package com.javaapi.test.businessdesign.howtoextend.proxy;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by user on 2019/11/30
 */
@Component
public class ValidatorProxy implements Validator {
    @Resource
    AValidator aValidator;

    @Resource
    BValidator bValidator;


    /**
     * @param context
     */
    @Override
    public void validate(ValidationContext context) {
        Validator validator = getValidator(context);
        validator.validate(context);
    }

    private Validator getValidator(ValidationContext context) {
        if (context.getType().equals("A")) {
            return aValidator;
        } else if (context.getType().equals("B")) {
            return bValidator;
        }
        throw new RuntimeException();
    }
}
