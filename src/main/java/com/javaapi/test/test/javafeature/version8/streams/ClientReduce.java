package com.javaapi.test.test.javafeature.version8.streams;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * http://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 *
 *
 *
 *   http://jobar.iteye.com/blog/2023477
 * map跟reduce操作是函数式编程的核心，reduce也被称作折叠操作。
 * reduce并不是一种新的操作，在SQL中我们用的一些聚集函数比如sum，avg，count等他们实际上也是reduce操作，
 *
 *
 *
 *
 *
 * 同样，这也是你经常用Java编写的代码，现在这段代码拥有了在函数式编程语言中的名字：Fold或者Reduce。
 * 在函数式编程语言中，Fold操作通常是递归式的，这里不进行深入讨论。
 * 然而，我们可以在一个循环体内，利用可变状态累加每次循环之后的结果，实现类似Fold的操作。
 * 在这种方式中，Fold操作将一个带有内部可变变量并且读取单个参数的函数，
 * 比如someMethod(T)，应用到输入列表list<T>中的每个元素中，
 * 一直到产生最后的Fold操作的结果之后结束。

 典型的Fold操作如累加，逻辑与、逻辑或，List.add()和List.addAll()，StringBuilder.append()，max以及min等。

 Fold的思想与SQL中的聚集函数类似
 */
public class ClientReduce {
    /**
     * reduce
     * 这个方法的主要作用是把 Stream 元素组合起来。它提供一个起始值（种子），然后依照运算规则（BinaryOperator），和前面 Stream 的第一个、第二个、第 n 个元素组合。从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce。例如 Stream 的 sum 就相当于
     * Integer sum = integers.reduce(0, (a, b) -> a+b); 或
     * Integer sum = integers.reduce(0, Integer::sum);
     * 也有没有起始值的情况，这时会把 Stream 的前面两个元素组合起来，返回的是 Optional。
     *
     *
     * 使用初始值的reduce，因为提供了初始值，所以返回值不再是Optional
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    @Test
    public void testAccumulate() {
        String concat;

        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println("sumValue = " + concat);
    }

    @Test
    public void testAccumulate3() {
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println("sumValue = " + sumValue);
    }

    @Test
    public void testAccumulate2() {
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("minValue = " + minValue);
    }

    @Test
    public void testAccumulate1() {
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("1", (s, str) -> s.concat(str));
        System.out.println("concat = " + concat);
    }

    /**
     * 由于可能没有足够的元素，返回的是 Optional，请留意这个区别
     * http://blog.csdn.net/kiwi_coder/article/details/31771475
     * @throws Exception
     */
    @Test
    public void testNoInitParam() throws Exception {
        // 求和，sumValue = 10, 无起始值
        Optional<Integer> sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum);
        System.out.println("sumValue = " + sumValue.get());
        System.out.println("sumValue = " + sumValue.isPresent());
    }

    /**
     * 3.另一种reduce

     上面两种类型的reduce都是争对同类型的操作的，对于类型是T的stream

     <U> U reduce(U identity,
     BiFunction<U, ? super T, U> accumulator,
     BinaryOperator<U> combiner);



     我真的觉得它长的好丑啊，其实可以换成map + reduce就行了
     * @throws Exception
     */
    @Test
    public void testReduce3() throws Exception {
        //TODO
    }
}
