package com.javaapi.test.test.genericType;

/**
 * 1Java中的泛型是在编译期间有效的,在运行期间将会被删除,也就是所有泛型参数类型在编译后都会被清除掉.请看以下例子 编译器会报错
 * 2在编译后泛型类型是会被擦除的
 * ,所以无论是List<Integer>或List<String>都会变成List<E>,所以参数相同,重载不成立,无法编译通过
 * ,而且读者可以尝试将不同泛型的类getClass()看看,他们的Class是一样的
 * 
 * @author hncw
 * 
 */
public class TestGeneric1_1 {
	// public static void test(List<Integer> testParameter) {
	//
	// }
	//
	// public static void test(List<String> testParameter) {
	//
	// }

}
