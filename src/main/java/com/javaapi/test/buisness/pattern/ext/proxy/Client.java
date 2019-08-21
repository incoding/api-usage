package com.javaapi.test.buisness.pattern.ext.proxy;

/**
 * https://blog.csdn.net/carson_ho/article/details/54910472
 * 这个是静态代理。真实角色必须是事先已经存在的，并将其作为代理对象的内部属性。但是实际使用时，一个真实角色必须对应一个代理角色，如果大量使用会导致类的急剧膨胀；此外，如果事先并不知道真实角色，该如何使用代理呢？这个问题可以通过Java的动态代理类来解决。
 * https://blog.csdn.net/liangbinny/article/details/18656791
 */
public class Client {

    public static void main(String[] args){

        Subject proxy = new ProxySubject();
        proxy.buyMac();
    }

}