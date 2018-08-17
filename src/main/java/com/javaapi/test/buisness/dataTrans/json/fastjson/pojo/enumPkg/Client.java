package com.javaapi.test.buisness.dataTrans.json.fastjson.pojo.enumPkg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 *fastjson 反序列化枚举，错误的枚举值是不抛异常
 */
public class Client {
    /**经验
     *目前版本的fastjon默认对enum对象使用WriteEnumUsingName属性，因此会将enum值序列化为其Name。
     使用WriteEnumUsingToString方法可以序列化时将Enum转换为toString()的返回值；同时override toString函数能够将enum值输出需要的形式。但是这样做会带来一个问题，对应的反序列化使用的Enum的静态方法valueof可能无法识别自行生成的toString()，导致反序列化出错。
     */
    @Test
    public void testDeserializeEnum() {
        System.out.println("CheckInStatus = " + CheckInStatus.CheckIn);
        RefundCondition refundCondition = new RefundCondition();
        refundCondition.setCheckInStatus(CheckInStatus.CheckIn);
        String s = JSON.toJSONString(refundCondition);
        System.out.println("s = " + s);
        System.out.println("------------");

        RefundCondition derfund = JSONObject.parseObject(s, RefundCondition.class);
        System.out.println("derfund = " + derfund);
        System.out.println("derfund = " + derfund.getCheckInStatus().getName());
    }

    /**

     */
    @Test
    public void testDeserializeEnum2() {
        String s = "{\"checkInStatus\":\"CheckIn\"}";
        RefundCondition derfund = JSONObject.parseObject(s, RefundCondition.class);
        System.out.println("derfund = " + derfund);
    }


    /**
     * fastjson 反序列化枚举 ,如果不存在则是序列化null
     */
    @Test
    public void testDeserializeEnum3() {
        String s = "{\"checkInStatus\":\"aaa\"}";
        RefundCondition derfund = JSONObject.parseObject(s, RefundCondition.class);
        System.out.println("derfund = " + derfund);
    }

}
