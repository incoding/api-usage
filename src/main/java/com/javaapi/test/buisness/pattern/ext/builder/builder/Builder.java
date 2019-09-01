package com.javaapi.test.buisness.pattern.ext.builder.builder;

/**
 * Created by user on 2019/9/1
 */
public interface Builder<T, E> {
    E build(T e);
}