package com.javaapi.test.pattern.structure.decorator;

/**
 * 不要纠结于构造器，还是set方法，注入成员变量</br>
 * 装饰模式解决得问题:</br>
 * 1 防止继承情况下的类爆炸</br>
 * 装饰模式的缺点</br>
　　由于使用装饰模式，可以比使用继承关系需要较少数目的类。使用较少的类，当然使设计比较易于进行。但是，在另一方面，使用装饰模式会产生比使用继承关系更多的对象。更多的对象会使得查错变得困难，特别是这些对象看上去都很相像。
   根桥接模式得不同:</br>
   装饰模式，是调用父级方法.
 */
public class Test {

	public static void main(String[] args) {
		Man man = new Man();
		ManDecoratorA mda = new ManDecoratorA();
		ManDecoratorB mdb = new ManDecoratorB();
		ManDecoratorC mdc = new ManDecoratorC();
		ManDecoratorD mdd = new ManDecoratorD();

		mda.setPerson(man);
		mdb.setPerson(mda);
		mdc.setPerson(mdb);
		mdd.setPerson(mdc);
		mdd.eat();
	}
}
