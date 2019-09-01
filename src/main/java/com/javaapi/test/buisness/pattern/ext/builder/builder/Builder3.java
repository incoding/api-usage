package com.javaapi.test.buisness.pattern.ext.builder.builder;

/**
 * Created by user on 2019/9/1
 */
public interface Builder3<T, T2, T3, E> {
    E build(T t, T2 t2, T3 t3);
}