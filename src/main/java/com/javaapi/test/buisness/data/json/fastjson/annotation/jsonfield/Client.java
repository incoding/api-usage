package com.javaapi.test.buisness.data.json.fastjson.annotation.jsonfield;

import com.javaapi.test.buisness.data.json.fastjson.util.JsonUtil;
import org.junit.Test;

/**
 * JsonField 只是定义输入,输出的key
 * 输入,输出的具体value 是根据  setter和getter方法 获取的
 *
 *
 *http://www.cnblogs.com/Sinte-Beuve/p/7270782.html
 * 在序列化的时候，先利用反射找到对象类的所有get方法，接下来去get，然后小写化，作为json的每个key值，而get方法的返回值作为value。接下来再反射field，添加到json中。
 *
 *
 */
public class Client {
    /**
     * FastJson在进行操作时，是根据getter和setter的方法进行的，并不是依据Field进行。
     */
    @Test
    public void testGetter(){
        Student student = new Student();
        student.setName("set origin name");
        student.setAge(18);
        String json = JsonUtil.jsonWithType(student);
        System.out.println("json = " + json);
    }

    /**
     * FastJson在进行操作时，是根据getter和setter的方法进行的，并不是依据Field进行。
     */
    @Test
    public void testSetter(){
        String s = "{\"@type\":\"com.javaapi.test.buisness.dataTrans.json.fastjson.annotation.jsonfield.Student\",\"NAME\":\"nihao\",\"age\":18}";
        Student object = JsonUtil.getObject(s);
        System.out.println("object = " + object);
    }

}
