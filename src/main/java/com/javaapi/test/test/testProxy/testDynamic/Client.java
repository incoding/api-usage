package com.javaapi.test.test.testProxy.testDynamic;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.javaapi.test.test.testProxy.testDynamic.helloImp.HelloI;
import com.javaapi.test.test.testProxy.testDynamic.helloImp.HelloImpl;
import com.javaapi.test.test.testProxy.testDynamic.worldImp.WorldI;
import com.javaapi.test.test.testProxy.testDynamic.worldImp.WorldImp;

public class Client {
	@Test
    public  void test() {
        HelloI hello = new HelloImpl();
        WorldI world = new WorldImp();
        DynamicProxy helloDynamicProxy = new DynamicProxy(hello);
        DynamicProxy worldDynamicProxy = new DynamicProxy(world);
        HelloI helloProxy = (HelloI) Proxy.newProxyInstance(hello.getClass()
                .getClassLoader(), hello.getClass().getInterfaces(),
                helloDynamicProxy);
        helloProxy.say("Jack");
        WorldI worldProxy = (WorldI) Proxy.newProxyInstance(world.getClass()
                .getClassLoader(), world.getClass().getInterfaces(),
                worldDynamicProxy);
        worldProxy.speak("jack");
    }
	/**解决一个aop代理得问题
	 * http://my.oschina.net/mushui/blog/161387
	 */
	@Test
	public void test2() {
		HelloI hello = new HelloImpl();
		DynamicProxy helloDynamicProxy = new DynamicProxy(hello);
		HelloI helloProxy = (HelloI) Proxy.newProxyInstance(hello.getClass()
				.getClassLoader(), hello.getClass().getInterfaces(),
				helloDynamicProxy);
		helloProxy.say("Jack");
		System.out.println("----------");
		helloProxy.sayHello("Jack");
	}
}
