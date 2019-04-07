package com.javaapi.test.test.javafeature.version5.generictype.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * 测试泛型中的"继承"
 *
 */
public class GenericExtends {
	/**
	 * 将泛型子类传递给通配符
	 */
	@Test
	public void testGeneric1() {
		 Collection<?> collection;
		List<String> d = new ArrayList<String>();
		d.add("1");
		d.add("12");
		d.add("13");
//		那么什么是各种collections的父类呢？它写作： Collection<?>(发音为:"collection of unknown")，就是，一个集合，它的元素类型可以匹配任何类型
//		@1 将一个List<String>传个一个含有Collection<?> 类型参数的方法(传递之后,解开后只能定义为Object类型)
		printCollection(d);
//		@ 2 将一个  List<String>传个一个Collection<?> 类型的变量 (经过上面的测试用例肯定是可以的)
		collection = d;
	}
    /**
     * 1 通配符解开后只能定义为Object类型.</br>
     * 2 但是将任意元素加入到其中不是类型安全的：
     * 3 即使加入Object实例也是不可以的
     * 4 加入null是可以的,实际上对于编程,这没什么用..
     */
	void printCollection(Collection<?> c) {
		// 1
		for (Object a : c) {
			System.out.println(a);
		}
		// 2
//		 c.add("1");
		// 3
		// c.add(new Object());
		// 4
		 c.add(null);
	}

	  /**
     * 1 有限制的通配符可以直接解开为上限(或者下限).</br>
     * 2 但是将任意元素加入到其中不是类型安全的：
     * 3 即使加入Object实例也是不可以的
     * 4 加入null是可以的,实际上对于编程,这没什么用..

     */
	void printCollection2(Collection<? extends Number> c) {
		// 1
		for (Number a : c) {
			System.out.println(a);
		}
		// 2
		// c.add(new Integer(1));
		// 3
		// c.add(new Object());
		// 4
		 c.add(null);
	}
	/**
	 * 刚接触泛型的读者有可能会犯下面错误,
	 * 理解为泛型之间是可以继承的
	 * ,例如声明Object的泛型实际上创建Integer泛型,错误认为泛型之间也存在继承关系,但这是不正确的,泛型是帮助开发者编译期间类型检查安全
	 * .我们可以换种方式实现业务逻辑
	 */
	public void test1() {
//		注意泛型中的继承不是这样继承的
		// // 编译不通过
		// List<Object> list = new ArrayList<Integer>();
		// // or
		// List<Object> list2 = new ArrayList<Double>();
		
		// 应该是下面这样
		// Number 为Integer 和 Double 的公共父类
		List<Number> numberList = new ArrayList<Number>();
		// 使用通配符,代表实际类型是Number类型的子类
		List<? extends Number> numberList2 = new ArrayList<Integer>();
		// or
		List<? extends Number> numberList3 = new ArrayList<Double>();
	}
}
