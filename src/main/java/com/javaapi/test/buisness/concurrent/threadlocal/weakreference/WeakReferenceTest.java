package com.javaapi.test.buisness.concurrent.threadlocal.weakreference;

import org.junit.Test;
import org.testng.collections.Lists;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * https://www.iteye.com/blog/puretech-2008663
 * gc 使weakreference生效
 * idea 对该类运行配置如下
 * -ea -verbose:gc  -Xms5m -Xmx10m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class WeakReferenceTest {
    /**
     * 注意  new WeakReference<>(new Person("kk", 30)) ,这里的 new Person 是没有暴露引用出去的.这样才可以被gc掉.不然一直到oom也不能产生 weakReference.get() == null 的效果
     */
    @Test
    public void test() {
        WeakReference<Person> weakReference = new WeakReference<>(new Person("kk", 30));
        List<Person> list = Lists.newArrayList(100000);
        while (weakReference.get() != null) {
            list.add(new Person("kk", 30));
        }
        System.out.println("Object has been collected.");
        System.out.println("person1 = " + weakReference.get());
    }

    @Test
    public void testEntry() {
        Person key = new Person("key", 30);
        Entry weakReference = new Entry(key, "value");
        List<Person> list = Lists.newArrayList(100000);
        while (weakReference.get() != null) {
            list.add(new Person("kk", 30));
        }
        System.out.println("Object has been collected.");
        System.out.println("person1 = " + weakReference.get());
    }

    @Test
    public void testEntry2() {
        Entry weakReference = new Entry(new Person("key", 30), "value");
        List<Person> list = Lists.newArrayList(100000);
        int i = 0;
        while (weakReference.get() != null) {
            list.add(new Person("kk", 30));
            System.out.println("list = " + (i += 1));
        }
        System.out.println("Object has been collected.");
        System.out.println("person1 = " + weakReference.get());
    }

}
