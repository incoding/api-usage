package com.javaapi.test.buisness.pattern.ext.builder;

import com.javaapi.test.buisness.pattern.ext.builder.builder.Builder4;
import com.javaapi.test.buisness.pattern.ext.builder.context.Builder4Context;
import com.javaapi.test.buisness.pattern.ext.builder.mode.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 示范根据泛型注入
 * * 使用spring bean形式的builder可以获得更多能力
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client4 {

    @Autowired
    Builder4<Builder4Context, Person> builder;

    @Test
    public void test() throws Exception {
        Builder4Context context = new Builder4Context();
        context.setFirstName("firstname");
        context.setLastName("lastname");
        context.setAge(30);
        Person build = builder.build(context);
        System.out.println("build = " + build);

    }
}
