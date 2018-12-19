package com.javaapi.test.test.reflect.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

import org.junit.Test;

/**
 * 类加载器机制:1 父类委托,2 全盘负责,3缓存机制 </br>类加载路径,注意路径与jar包得不同</br>
 * 非web应用一般都是通过java提供得SystemClassLoader类加载</br>
 * web应用是通过tomcat提供得WebAppClassLoader来加载
 */
public class TestClassloader {
	static {
		// System.out.println(TestClassloader.class.getName());
	}

	/**
	 * 获取classloader得方式
	 */
	@Test
	public void gClassloader() {
		// 获取当前线程得类加载器,当前线程得类加载器可以通过程序员设置,从而摆脱类加载机制得限制
		Thread.currentThread().getContextClassLoader();
		// 通过当前类获取类加载器
		TestClassloader.class.getClassLoader();
		// 使用类调用类得类加载器
		// callingClass.getClassLoader().loadClass(className);
	}

	/**
	 * 获取Class得方式
	 */
	@Test
	public void gClass() throws ClassNotFoundException {
		String loader1 = TestClassloader.class.getClassLoader().getClass()
				.toString();
		String loader2 = new TestClassloader().getClass().getClassLoader()
				.toString();
		String loader3 = Class
				.forName(
                        "com.javaapi.test.test.reflect.classloader.TestClassloader")
				.getClass().getClassLoader().toString();
		System.out.println(loader1);
		System.out.println(loader2);
		System.out.println(loader3);
	}

	/**
	 * 这俩种方式都会将类初始化
	 */
	@Test
	public void testClassloader() {
		try {
			System.out.println("start");
			Class.forName("com.javaapi.test.test.reflect.classloader.Dummy");
			// 用当前类加载器加载当前类,true
			System.out.println("-----------");
			// 不会重复类初始化
			Class.forName("com.javaapi.test.test.reflect.classloader.Dummy",
					true, TestClassloader.class.getClassLoader());
			System.out.println("end");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 不会进行类初始化
	 */
	@Test
	public void testClassloader2() {
		try {
			// 用当前类加载器加载当前类,false
			System.out.println("start");
			Class.forName("com.javaapi.test.test.reflect.classloader.Dummy",
					false, TestClassloader.class.getClassLoader());
			TestClassloader.class.getClassLoader().loadClass(
                    "com.javaapi.test.test.reflect.classloader.Dummy");
			System.out.println("-----------");
			System.out.println("end");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根类加载器,扩展类加载器,系统类加载器
	 */
	@Test
	public void testEveryClassloader() {
		// 系统类加载器,
		// 负责加载java命令-classpath路径或者环境变量CLASSPATH路径
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		// 扩展类加载器
		ClassLoader extClassLoader = systemClassLoader.getParent();
		// 根类加载器,由于根类加载器不是由java写的所以会输出null
		ClassLoader bootstrapClassloader = extClassLoader.getParent();
		System.out.println(systemClassLoader);
		System.out.println(extClassLoader);
		System.out.println(bootstrapClassloader);
	}

	@Test
	public void testEveryClassloaderPath() {
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		try {
			Enumeration<URL> urls = systemClassLoader.getResources("");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				System.out.println(url.getPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 环境变量
	 */
	@Test
	public void testEnv() {
		Map<String, String> env = System.getenv(); // 所有环境变量
		System.out.println(env.get("CLASSPATH"));// key得名字要与环境变量得相同
		System.out.println(env.get("Path")); // key得名字要与环境变量得相同
		System.out.println("-------------------");
	}

	/**
	 * 类加载路径,注意路径与jar包得不同</br> 非web应用一般都是通过java提供得SystemClassLoader类加载</br>
	 * web应用是通过tomcat提供得WebAppClassLoader来加载
	 */
	@Test
	public void testClassPath() {
		Map<String, String> env = System.getenv(); // 所有环境变量
		System.out
				.println("系统加载器得加载路径1 java命令得-classpath 2 -Djava.class.path系统属性 3 CLASSPATH环境变量所指定得JAR和类路径------------------------");
		System.out.println(System.getProperty("java.class.path")); // 所有类加载路径
		System.out.println(env.get("CLASSPATH"));// 通过环境变量设置得类加载路径
		System.out.println("扩展类加载器得加载路径------------------------");
		System.out.println(System.getProperty("java.ext.dirs")); // 扩展类加载器负责加载得路径
		System.out.println("根类加载器加载得路径------------------------");
		System.out.println(System.getProperty("sun.boot.class.path"));
	}
}
