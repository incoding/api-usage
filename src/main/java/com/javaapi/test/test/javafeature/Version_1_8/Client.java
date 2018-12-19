package com.javaapi.test.test.javafeature.Version_1_8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 15/8/15.
 */
public class Client {

    @Test
    public void test(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

// 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }

// 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));

// 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }

    @Test
    public void testRunnable(){
        // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !匿名内部类");
            }
        }).start();

// 1.2使用 lambda expression
        new Thread(() -> System.out.println("Hello world ! lambda")).start();

// 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world ! 匿名内部类");
            }
        };

// 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("Hello world ! lambda表达式返回runnable");

// 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();
    }

    @Test
    public void testMyself(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
        players.forEach((player)-> System.out.println(player));
    }

}
