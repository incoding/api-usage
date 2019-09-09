package com.javaapi.test.test.testJdk.language.dispatch.people;

import com.javaapi.test.test.testJdk.language.dispatch.fruit.Apple;
import com.javaapi.test.test.testJdk.language.dispatch.fruit.Banana;
import com.javaapi.test.test.testJdk.language.dispatch.fruit.Fruit;

/**
 * Created by user on 2019/9/7
 */
public class Boy extends People {
    public void eat(Fruit f) {
        System.out.println("boy eats fruit");
    }

    public void eat(Apple f) {
        System.out.println("boy eats apple");
    }

    public void eat(Banana f) {
        System.out.println("boy eats banana");
    }
}
