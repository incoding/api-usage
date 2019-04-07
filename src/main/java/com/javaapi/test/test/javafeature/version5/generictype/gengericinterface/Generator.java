package com.javaapi.test.test.javafeature.version5.generictype.gengericinterface;

/**
 * refer https://blog.csdn.net/s10461/article/details/53941091
 */
public interface Generator<T> {
    public T next();
}