package com.javaapi.test.businessdesign.howtoextend.proxy;

import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/11/30
 */
@Component
public class BValidator implements Validator {
    /**
     * @param context
     */
    @Override
    public void validate(ValidationContext context) {
        System.out.println("BValidator = " + context);
    }
}
