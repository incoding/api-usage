package com.javaapi.test.test.type.object.sample.spring.bean;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * Created by user on 2018/6/19
 */
public class Client {
    @Test
    public void test(){
        FromBean fromBean = new FromBean();
        fromBean.setAmount(12.123d);
        System.out.println("fromBean = " + fromBean);
        ToBean target = new ToBean();
        BeanUtils.copyProperties(fromBean, target);
        System.out.println("target = " + target);
    }

}
