package com.javaapi.test.buisness.pattern.ext.builder.builder;

/**
 * Created by user on 2019/9/1
 */
public interface Builder2<T, T2, E> {
    E build(T t, T2 t2);
}