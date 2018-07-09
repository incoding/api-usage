package com.javaapi.test.test.testReflect;

public class ReflectUtil {
	/**
	 * 1 范型得处理</br> 2 传入class,获取该class空构造函数得实例</br>
	 * 
	 * @param <T>
	 * 
	 * @param fqn
	 * @param t
	 * @return
	 */
	public static <T> T getInstance(Class<T> t) {
		T instance = null;
		try {
			instance = t.newInstance();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return instance;
	}
}
