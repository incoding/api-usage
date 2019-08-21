package com.javaapi.test.buisness.pattern.ext.proxy;

/**
 * Created by user on 2019/8/21
 */
public class ProxySubject  implements Subject{


    @Override
    public void buyMac() {
        //引用并创建真实对象实例，即”我“
        RealSubject realSubject = new RealSubject();

        //调用真实对象的方法，进行代理购买Mac
        realSubject.buyMac();
        //代理对象额外做的操作
        this.WrapMac();
    }

    public void WrapMac(){
        System.out.println("用盒子包装好Mac");
    }

}