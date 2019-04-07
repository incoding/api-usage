package com.javaapi.test.test.javafeature.version8.functionInterface;

import org.junit.Test;

import java.util.function.BiFunction;

/**
 * (好)
 * http://colobu.com/2014/10/28/secrets-of-java-8-functional-interface/#JDK_8之前已有的函数式接口
 * JDK 8之前已有的函数式接口
 * <p>
 * java.lang.Runnable
 * java.util.concurrent.Callable
 * java.security.PrivilegedAction
 * java.util.Comparator
 * java.io.FileFilter
 * java.nio.file.PathMatcher
 * java.lang.reflect.InvocationHandler
 * java.beans.PropertyChangeListener
 * java.awt.event.ActionListener
 * javax.swing.event.ChangeListener
 * 新定义的函数式接口
 * <p>
 * java.util.function中定义了几组类型的函数式接口以及针对基本数据类型的子接口。
 * <p>
 * 用于提供数据
 * Supplier -- 无参数传入，返回一个结果，方法为T get()
 * 用于过滤
 * Predicate -- 传入一个参数，返回一个bool结果， 方法为boolean test(T t)
 * <p>
 * 用于处理流程
 *    不同种
 * Function -- 传入一个参数，返回一个结果，方法为R apply(T t)
 * BiFunction -- 传入俩种不同参数,返回第三种类型参数
 *
 *      同种
 * UnaryOperator -- 一元操作符， 继承Function,传入参数的类型和返回类型相同。
 * BinaryOperator -- 二元操作符， 传入的两个参数的类型和返回类型相同， 继承BiFunction
 * <p>
 * 用于最终消费
 * Consumer -- 传入一个参数，无返回值，纯消费。 方法为void accept(T t)
 */
public class Client2 {
    @Test
    public void test() {
        BiFunction<Integer, Double, String> d = (a, b) -> String.valueOf(b) + "nihao";
        String apply = d.apply(new Integer(1), new Double(2));
        System.out.println("apply = " + apply);


    }
}
