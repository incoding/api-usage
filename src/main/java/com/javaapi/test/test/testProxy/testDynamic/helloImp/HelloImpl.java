package com.javaapi.test.test.testProxy.testDynamic.helloImp;

public class HelloImpl implements HelloI {

    @Override
    public void say(String name) {
        System.out.println("Hello! " + name);
    }

	@Override
	public void sayHello(String name) {
		this.say("kk");
	}
}