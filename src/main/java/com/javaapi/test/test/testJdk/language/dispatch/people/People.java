package com.javaapi.test.test.testJdk.language.dispatch.people;

import com.javaapi.test.test.testJdk.language.dispatch.fruit.Apple;
import com.javaapi.test.test.testJdk.language.dispatch.fruit.Banana;
import com.javaapi.test.test.testJdk.language.dispatch.fruit.Fruit;

/**
 * Created by user on 2019/9/7
 */
public class People {
    public void eat(Fruit f) {
        System.out.println("People eats fruit");
    }

    public void eat(Apple f) {
        System.out.println("People eats apple");
    }

    public void eat(Banana f) {
        System.out.println("People eats banana");
    }
}
