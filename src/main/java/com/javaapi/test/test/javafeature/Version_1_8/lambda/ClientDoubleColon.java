package com.javaapi.test.test.javafeature.Version_1_8.lambda;

import com.javaapi.test.test.javafeature.Version_1_8.streams.Person;
import org.junit.Test;
import org.testng.collections.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * 双冒号
 * https://blog.csdn.net/lsmsrc/article/details/41747159
 * 方法引用
 * http://zh.lucida.me/blog/java-8-lambdas-insideout-language-features/
 * 简单来讲，就是构造一个该方法的闭包。

 https://www.zhihu.com/question/28565691
 */
public class ClientDoubleColon {

    @Test
    public void test() {
//        我们知道使用lambda表达式可以让代码非常简洁。举例，创建比较器，使用下面语法：
//        Comparator c = (Person c1, Person c2) -> c1.getAge().compareTo(c2.getAge());
        //使用类型推断，可以简写为：
        Comparator<Person> comparator = (c1, c2) -> {
            return c1.getAge().compareTo(c2.getAge());
        };
        // 进一步我们可简写为
        List<Person> result = Lists.newArrayList();
        result.stream().sorted(comparator);


        Comparator<Person> comparing = Comparator.comparing(Person::getAge);

    }
}
