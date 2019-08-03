package com.javaapi.test.spring.spring.feature.function.init;

public class D extends C {

	protected static String sd;// 由Spring容器依据配置文件赋初始值

	static {
		System.out.println("执行D的static块(D继承C)");
	}
	{
		System.out.println("执行D实例的普通初始化块");
	}
	protected String sd1;// 由Spring容器依据配置文件赋初始值

	D() {
		System.out.println("执行D的构造函数(D继承C);父类B的实例成员变量sb的值为：" + sb
				+ ";本类D的static成员变量sd的值为：" + sd + ";本类D的实例成员变量sd1的值是：" + sd1);
	}

	public void methodOfD() {
		System.out.println("运行D中的方法methodOfD");
	}

	public void setSd(String sdtmp) {
		sd = sdtmp;
		System.out.println("已初始化D的static成员变量sd");
	}

	public void setSd1(String sd1tmp) {
		sd1 = sd1tmp;
		System.out.println("已初始化D的实例成员变量sd1");

	}
}