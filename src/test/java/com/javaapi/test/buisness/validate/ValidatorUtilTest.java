package com.javaapi.test.buisness.validate;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidatorUtilTest {

    @Test
    public void test(){
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(new Article());
        System.out.println("validate = " + JSON.toJSONString(validResult));
    }
    @Test
    public void test2(){
        Set<ConstraintViolation<Article>> validate = cn.hutool.extra.validation.ValidationUtil.validate(new Article());
        for (ConstraintViolation<Article> articleConstraintViolation : validate) {
            System.out.println("articleConstraintViolation = " + articleConstraintViolation.getMessage());
        }

    }




}