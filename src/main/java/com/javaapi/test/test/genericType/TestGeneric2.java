package com.javaapi.test.test.genericType;

import java.util.ArrayList;
import java.util.List;

/**
 * Java语言是一门强类型,编译型的安全语言,它需要确保运行期的稳定性和安全性,所以在编译时编译器需要严格的检查我们所声明的类型,
 * 在编译期间编译器需要获取T类型,但泛型在编译期间已经被擦除了,所以new T()和new
 * T[5]都会出现编译错误,而为什么ArrayList却能成功初始化
 * ?这是因为ArrayList表面是泛型,但在编译期间已经由ArrayList内部转型成为了Object
 * ,有兴趣的读者可以看一下ArrayList的源码,源码中容纳元素的是private transient Object[]
 * elementData,是Object类型的数组
 * 
 * @see http://ray-yui.iteye.com/blog/1933127
 * 
 */
/**
 * 在使用泛型时,在大多数情况下应该声明泛型的类型,例如该集合是存放User对象的,就应该使用List<User>来声明,这样可以尽量减少类型的转换,
 * 若只使用List而不声明泛型,则该集合等同于List<Object>
 * 
 * 
 */
public class TestGeneric2<T> {
	// // 编译不通过
	// private T t = new T();
	// // 编译不通过
	// private T[] tArray = new T[5];
	// 编译通过
	private List<T> list = new ArrayList<T>();

}
