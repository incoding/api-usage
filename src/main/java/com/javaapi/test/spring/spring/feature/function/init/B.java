package com.javaapi.test.spring.spring.feature.function.init;

public class B {
	protected IE e;// 实现的类和实例由Spring容器注入
	protected static IF f;// f的实现的类和实例由Spring容器注入
	protected String sb;// 初始值由Spring容器依据配置文件给出
	static {
		System.out.println("执行B类的static块(B包含E类的成员变量,包含静态F类成员变量)");
		// f.funcOfF();属性f的注入在构造函数之后，更在此static初始化之后，所以这里不能调用f的函数，调用的话会报初始化异常
	}
	{
		System.out.println("执行B实例的普通初始化块");
	}

	B() {
		System.out.println("执行B类的构造函数(B包含E类的成员变量,包含静态F类成员变量)");
		// e.funcOfE();属性e的注入在此构造函数之后，所以这里不能调用f的函数，调用的话会报初始化异常
	}

	public String getSb() {
		return sb;
	}

	public void setSb(String sb1) {
		this.sb = sb1;
		System.out.println("已给B的成员变量sb赋初值：" + sb1);
	}

	public void setE(IE e1) {
		this.e = e1;
		System.out.println("已将E类实例注入B的引用成员变量e");
	}

	public void setF(IF f1)// 此方法不能加static修饰符，否则Spring注入时报NotWritablePropertyException
	{
		f = f1;
		System.out.println("已将F类实例注入B的static引用成员变量f");
	}
}