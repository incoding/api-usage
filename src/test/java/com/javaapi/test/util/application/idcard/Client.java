package com.javaapi.test.util.application.idcard;

import org.junit.Test;

/**
 * Created by user on 2018/12/25
 */
public class Client {

    @Test
    public void test(){
        String idCard = "14072419951227009X";
        System.out.println(IdCardUtils.getGenderByIdCard(idCard));
        System.out.println(IdCardUtils.getBirthByIdCard(idCard));
        System.out.println(IdCardUtils.getMonthByIdCard(idCard));
        System.out.println(IdCardUtils.getDateByIdCard(idCard));
        System.out.println(IdCardUtils.getConstellationById(idCard));
        System.out.println(IdCardUtils.getZodiacById(idCard));
        System.out.println(IdCardUtils.getChineseEraById(idCard));
        System.out.println(IdCardUtils.getProvinceByIdCard(idCard));
        //M 19941115 11 15 天蝎座 狗 甲戌 湖南

    }

}
