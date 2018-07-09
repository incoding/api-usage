package com.javaapi.test.pattern.concrete.singleton.perfect.doublecheckVolatile;

import com.javaapi.test.pattern.concrete.singleton.Singleton;

/**
 * 1 通过双重校验 保证线程安全

 * 2 通过volatile防止指令重排
 * http://blog.csdn.net/glory1234work2115/article/details/50814419
 */
public class Singleton3{

    private static volatile Singleton3 instance;

    private Singleton3(){
    }

    public static  Singleton3 getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance=new Singleton3();
                }
            }
        }
        return instance;
    }

}