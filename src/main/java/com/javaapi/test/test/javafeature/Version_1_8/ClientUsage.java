package com.javaapi.test.test.javafeature.Version_1_8;

import org.junit.Test;

import java.util.Arrays;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.IntBinaryOperator;

/**
 * http://rensanning.iteye.com/blog/2039106</br>
 * Java 7引入了invokedynamic指令，它是一个JVM指令，允许动态语言在run-time时动态绑定。Java 8的Lambda表达式并不是匿名类的语法糖，它不会在编译的时候生成类似于匿名类的xxx$1.class，而是在运行的时候使用invokeDynamic指令。对于一条Lambda表达式在class里边会包含一个invokedynamic命令和一个静态方法。运行时会使用LambdaMetafactory#metafactory做成一个Lambda$1的内部类再调用该函数式接口的实例。在运行时生成class，就是避免class太多影响加载速度，像Stream那样的到处是Lambda。
 */
public class ClientUsage {
    public static void main(String[] args) {
        new ClientUsage().testThis();
    }
    /** 测试lambda表达式和匿名内部类在this这块的不同 </br>
     * this：匿名类this取得是自己，Lambda取得是所在的外部类。
     */
    @Test
    public void testThis(){ // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !匿名内部类"+this.getClass());
            }
        }).start();

// 1.2使用 lambda expression
        new Thread(() -> System.out.println("Hello world ! lambda"+this.getClass())).start();
    }
    /**用于Lambda的变量不可变**/
    @Test
    public void testVariable(){
//        int portNumber = 1337;
//        Runnable r = () -> System.out.println(portNumber); // 编译不通过 NG
//        portNumber = 1338;
        // 但是通过数组实现变量可以变
        final int[] wrappedNumber = new int[] { 1337 };
        Runnable r = () -> System.out.println(wrappedNumber[0]); // OK
        wrappedNumber[0] = 1338;
    }

    @Test
    public void testException(){
        String[] datas = new String[]{""};
        Arrays.asList(datas).stream().forEach(name -> check(name));
    }
    public static int check(String s) {
        if (s.equals("")) {
            throw new IllegalArgumentException();
        }
        return s.length();
    }
}
