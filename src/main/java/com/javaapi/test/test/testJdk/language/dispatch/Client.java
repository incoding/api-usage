package com.javaapi.test.test.testJdk.language.dispatch;

import com.javaapi.test.test.testJdk.language.dispatch.fruit.Apple;
import com.javaapi.test.test.testJdk.language.dispatch.fruit.Banana;
import com.javaapi.test.test.testJdk.language.dispatch.fruit.Fruit;
import com.javaapi.test.test.testJdk.language.dispatch.people.Boy;
import com.javaapi.test.test.testJdk.language.dispatch.people.People;
import org.junit.Test;

/**
 * refer https://www.zhihu.com/question/28462483
 */
public class Client {
    @Test
    public void test() {
        People boy = new Boy();
        Fruit apple = new Apple();
        Fruit banana = new Banana();

        boy.eat(apple);
        boy.eat(banana);

    }
}
