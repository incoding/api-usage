package com.javaapi.test.buisness.dataTrans.json.fastjson.pojo.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.io.IOException;

/**
 * 1 如果不对json字符串本身做任何处理的话是获取不到任何类型信息的.  需要使用typeReference 来处理泛型
 * 2 对json字符串加了类型信息就不需要使用typeReference
 */
public class Client {
    /**
     * 处理带范型参数
     */
    @Test
    public void deserialize() throws IOException {
        String s = getWithdrawString();
        WithdrawVo<Withdraw> withdrawVo = JSON.parseObject(s, new TypeReference<WithdrawVo<Withdraw>>(){});
        System.out.println("withdrawVo = " + withdrawVo);
        Object data = withdrawVo.getDATA();
        System.out.println("withdrawVo class is " + data.getClass());
    }


    /**
     * 处理带范型参数,  如果不用TypeReference,则会出现  获取不到泛型的情况
     * 会报错
     */
    @Test
    public void deserializeNoGeneric() throws IOException {
        String s = getWithdrawString();
        System.out.println("s = " + s);
        WithdrawVo<Withdraw> withdrawVo = JSON.parseObject(s, WithdrawVo.class);
        System.out.println("withdrawVo = " + withdrawVo);
//        Object data = withdrawVo.getDATA();
//        System.out.println("withdrawVo class is " + data.getClass());
        Withdraw data = withdrawVo.getDATA();

        System.out.println("data = " + data);
    }


    /**
     * 解析带有类型参数的json 字符串
     * @throws IOException
     */
    @Test
    public void deserializeWithTypeStr() throws IOException {
//        如果在 1.2.25之后的版本不进行设置,则无法反序列化 带类型的json串
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String s = "{\"@type\":\"com.javaapi.test.buisness.dataTrans.json.fastjson.pojo.generic.WithdrawVo\",\"dATA\":{\"@type\":\"com.javaapi.test.buisness.dataTrans.json.fastjson.pojo.generic.Withdraw\",\"desc\":\"nihao\",\"index\":\"1\"}}";
        WithdrawVo<Withdraw> withdrawVo = JSON.parseObject(s, WithdrawVo.class);
        System.out.println("withdrawVo = " + withdrawVo);
        Withdraw data = withdrawVo.getDATA();
        System.out.println("data = " + data);
    }



    private String getWithdrawString() {
        WithdrawVo<Withdraw> drawVo = new WithdrawVo<>();
        Withdraw data = new Withdraw();
        data.setDesc("nihao");
        data.setIndex_index("1");
        drawVo.setDATA(data);
        return JSON.toJSONString(drawVo);
    }
}
