package com.javaapi.test.test.javafeature.Version_1_8.functionInterface;

import org.junit.Test;

/**
 要理解lambda表达式，首先要了解的是函数式接口（functional interface）。
 简单来说，函数式接口是只包含一个抽象方法的接口。
 比如Java标准库中的java.lang.Runnable和java.util.Comparator都是典型的函数式接口。
 对于函数式接口，除了可以使用Java中标准的方法来创建实现对象之外，还可以使用lambda表达式来创建实现对象。这可以在很大程度上简化代码的实现。
 在使用lambda表达式时，只需要提供形式参数和方法体。
 由于函数式接口只有一个抽象方法，所以通过lambda表达式声明的方法体就肯定是这个唯一的抽象方法的实现，而且形式参数的类型可以根据方法的类型声明进行自动推断。
 */
public class Client {

    @Test
    public void test() {
//        每个 Lambda 表达式都能隐式地赋值给函数式接口，
//        例如，我们可以通过 Lambda 表达式创建 Runnable 接口的引用。
        new Thread(
                () -> System.out.println("hello world")
        ).start();
    }

    /**
     * @FunctionalInterface 是 Java 8 新加入的一种接口，
     * 用于指明该接口类型声明是根据 Java 语言规范定义的函数式接口。
     * Java 8 还声明了一些 Lambda 表达式可以使用的函数式接口，
     * 当你注释的接口不是有效的函数式接口时，
     * 可以使用 @FunctionalInterface 解决编译层面的错误。(提前告知错误)

        以下是一种自定义的函数式接口：

        根据定义，函数式接口只能有一个抽象方法，如果你尝试添加第二个抽象方法，将抛出编译时错误。例如

     */
    @FunctionalInterface
    public interface WorkerInterface {

        public void doSomeWork();
//        根据定义，函数式接口只能有一个抽象方法，如果你尝试添加第二个抽象方法，将抛出编译时错误。例如
//        public void doSomeMoreWork();

    }
}
