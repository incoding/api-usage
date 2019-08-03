package com.javaapi.test.buisness.pattern.concrete.singleton.serializiable;

public class SingletonClassLoader {
	private static final SingletonClassLoader instance = new SingletonClassLoader();

	private SingletonClassLoader() {
	}

	public SingletonClassLoader getInstatnce() {
		return instance;
	}

	/**
	 * 怎么用？
	 * 
	 * @param classname
	 * @return
	 * @throws ClassNotFoundException
	 */
	private static Class getClass(String classname)
			throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		if (classLoader == null)
			classLoader = SingletonClassLoader.class.getClassLoader();

		return (classLoader.loadClass(classname));
	}

	public static void main(String[] args) {
		try {
			ClassLoader
					.getSystemClassLoader()
					.loadClass("com.javaapi.test.buisness.pattern.concrete.singleton.serializiable.SingletonClassLoader");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
