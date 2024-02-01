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

    /**
     * 有校验注解
     * 嵌套注解
     */
    @Test
    public void test2(){
        Article bean = new Article();
        bean.setArticleInner(new ArticleInner());
        Set<ConstraintViolation<Article>> validate = cn.hutool.extra.validation.ValidationUtil.validate(bean);
        for (ConstraintViolation<Article> articleConstraintViolation : validate) {
            System.out.println("articleConstraintViolation = " + articleConstraintViolation.getMessage());
        }
    }

    /**
     * 无校验注解
     */
    @Test
    public void test3(){
        Set<ConstraintViolation<ArticleRaw>> validate = cn.hutool.extra.validation.ValidationUtil.validate(new ArticleRaw());
        for (ConstraintViolation<ArticleRaw> articleConstraintViolation : validate) {
            System.out.println("articleConstraintViolation = " + articleConstraintViolation.getMessage());
        }
    }

}