package com.javaapi.test.util.opensource.failsafe.sample;

import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by user on 18/2/3.
 */
public class TestRetrySelf {

    public static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    private static Integer i = 0;


    @Test
    public void functionTest(){
        RetryPolicy retryPolicy = new RetryPolicy();
        RetryPolicy retryPolicy1 = retryPolicy.retryOn(RuntimeException.class);
        Function<String, String> bar = value -> Failsafe.with(retryPolicy1).get(() -> {
            System.out.println("进入"+i);
            i++;
            if (i < 3) {
                throw new RuntimeException();
            }
            return value + "bar";
        });
        String nihao = bar.apply("nihao");
        System.out.println("nihao = " + nihao);
    }

    @Test
    public void retryTest(){
        RetryPolicy retryPolicy = new RetryPolicy();
        // Create a retryable runnable Stream
        Failsafe.with(retryPolicy).run(() -> Stream.of("foo").map(value -> value + "bar").forEach(System.out::println));

    }
    @Test
    public void callableTest(){
        RetryPolicy retryPolicy = new RetryPolicy();
        // Create a retryable callable Stream
        List<String> foo = Failsafe.with(retryPolicy).get(() -> Stream.of("foo")
                .map(value -> Failsafe.with(retryPolicy).get(() -> value + "bar"))
                .collect(Collectors.toList()));
        System.out.println("foo = " + foo);

    }
    @Test
    public void streamTest(){
        RetryPolicy retryPolicy = new RetryPolicy();
        // Create a individual retryable Stream operation
        Stream.of("foo").map(value -> Failsafe.with(retryPolicy).get(() -> value + "bar")).forEach(System.out::println);
    }

    @Test
    public void completableFutureTest(){
        RetryPolicy retryPolicy = new RetryPolicy();
        // Create a retryable CompletableFuture
        Failsafe.with(retryPolicy).with(executor).future(() -> CompletableFuture.supplyAsync(() -> "foo")
                .thenApplyAsync(value -> value + "bar")
                .thenAccept(System.out::println));
    }


    @Test
    public void test() {
        RetryPolicy retryPolicy = new RetryPolicy();
        // Create an individual retryable CompletableFuture stages
        CompletableFuture.supplyAsync(() -> Failsafe.with(retryPolicy).get(() -> "foo"))
                .thenApplyAsync(value -> Failsafe.with(retryPolicy).get(() -> value + "bar"))
                .thenAccept(System.out::println);

    }


}
