package com.javaapi.test.buisness.dataTrans.json.fastjson.SerDeser.serialize.date;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;

/**
 * -------------------------------------------
 * |   @author      ||
 * -------------------------------------------
 * |    @date       |18/3/25 下午5:29          |
 * -------------------------------------------
 * |   @version     | V1.0                    |
 * -------------------------------------------
 */
public class ClientDeser {
    /**
     * fastjson 反序列化默认可以解析 时间戳
     */
    @Test
    public void timestamp(){
        String time = String.valueOf(System.currentTimeMillis());
        String json = "{\"date\":\"" + time + "\",\"name\":\"nihao\"}";
        StudentForSer studentForSer = JSON.parseObject(json, StudentForSer.class);
        System.out.println("flightSearchParam = " + studentForSer);
    }


    /**
     * fastjson 反序列化默认可以解析 yyyy-MM-dd HH:mm:ss
     */
    @Test
    public void yyyyMMddHHmmss(){
        String json = "{\"date\":\"2018-11-23 14:12:00\",\"name\":\"nihao\"}";
        StudentForSer studentForSer = JSON.parseObject(json, StudentForSer.class);
        System.out.println("flightSearchParam = " + studentForSer);
    }
    /**
     * fastjson 反序列化默认可以解析 yyyy-MM-dd
     */
    @Test
    public void test(){
        String json = "{\"date\":\"2018-11-23\",\"name\":\"nihao\"}";
        StudentForSer studentForSer = JSON.parseObject(json, StudentForSer.class);
        System.out.println("flightSearchParam = " + studentForSer);
    }
}
