package com.javaapi.test.buisness.dataTrans.json.fastjson.feature.writeclassname;

import com.javaapi.test.buisness.dataTrans.json.fastjson.feature.pojo.Book;
import com.javaapi.test.buisness.dataTrans.json.fastjson.feature.pojo.Student;
import com.javaapi.test.buisness.dataTrans.json.fastjson.util.JsonUtil;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * fastjson的自省
 * http://wenshao.iteye.com/blog/1177410
 * 1 fastjson 在写的使用使用 SerializerFeature.WriteClassName   ,会将类型信息写在顶层json里 ,(新版本只写顶层类信息,就可以确定顶层类下field的类型信息)
 * 2 则在读的时候 使用 JSON.parse(json);  就可以省去确定类型
 */
public class Client {

    @Test
    public void test() {
        String json = getJson();

        Student newStudent= JsonUtil.getObject(json);
        System.out.println("newStudent = " + newStudent);
    }

    private String getJson() {
        Student student = new Student();
        student.setName("hello jsontype");
        student.setAge(30);
        Book book = new Book();
        book.setName("thinking in java");
        book.setPrice(BigDecimal.TEN);
        student.setBook(book);
        String json = JsonUtil.jsonWithType(student);
        System.out.println("json = " + json);
        return json;
    }


}
