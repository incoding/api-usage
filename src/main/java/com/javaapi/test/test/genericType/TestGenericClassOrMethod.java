package com.javaapi.test.test.genericType;

import java.util.Collection;

/**
 * 泛型函数 :泛型函数允许类型参数被用来表示方法的一个或多个参数之间的依赖关系，或者参数与其返回值的依赖关系。如果没有这样的依赖关系，不应该使用泛型方法。
 *
 */
public class TestGenericClassOrMethod<E> {
//	 boolean containsAll(Collection<?> c) {
//		return false;
//	}
//
//	    boolean addAll(Collection<? extends E> c) {
//			return false;
//		}
	
	// 下面这俩个方法可以代替上面俩个方法,但是参数与参数,参数与返回值之间没什么关系,最好不用下面俩个泛型方法
        <T> boolean containsAll(Collection<T> c) {
			return false;
		}

        <T extends E> boolean addAll(Collection<T> c) {
			return false;
		}


}
