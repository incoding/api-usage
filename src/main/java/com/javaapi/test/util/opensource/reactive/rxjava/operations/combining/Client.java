package com.javaapi.test.util.opensource.reactive.rxjava.operations.combining;

/**
 * merge,concat,zip
 *
 * 1. and() , then() , when()：
 通过模式(And条件)和计划(Then次序)组合两个或多个Observable发射的数据集

 2. combineLatest()：
 当两个Observables中的任何一个发射了一个数据时，通过一个指定的函数组合每个Observable发射的最新数据（一共两个数据），然后发射这个函数的结果

 3. join() , groupJoin()：
 无论何时，如果一个Observable发射了一个数据项，只要在另一个Observable发射的数据项定义的时间窗口内，就将两个Observable发射的数据合并发射

 4. switch()：
 将一个发射Observable序列的Observable转换为这样一个Observable：它逐个发射那些Observable最近发射的数据

 5 switchOnNext()：

 将一个发射Observables的Observable转换成另一个Observable，后者发射这些Observables最近发射的数据

 6. mergeDelayError()：
 合并多个Observables，让没有错误的Observable都完成后再发射错误通知

 https://www.jianshu.com/p/2ad07cbcaca8

 */
public class Client {
}
