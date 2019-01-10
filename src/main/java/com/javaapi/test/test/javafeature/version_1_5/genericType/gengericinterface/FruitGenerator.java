package com.javaapi.test.test.javafeature.version_1_5.genericType.gengericinterface;

/**
 * refer https://blog.csdn.net/s10461/article/details/53941091
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class FruitGenerator<T> implements Generator<T>{
 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 */
public class FruitGenerator<T> implements Generator<T>{
    @Override
    public T next() {
        return null;
    }
}