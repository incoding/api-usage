package com.javaapi.test.test.path;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;

import org.junit.Test;

public class TestPath {
	private static final String L = System.lineSeparator();
	static {
		// 静态代码块中如何获得,Object.class更通用一些,但是好像有些问题
		// String path = Object.class.getResource("").getPath();
		// 写自身得类不会报错，在junit下不会报错
//		String path = TestPath.class.getResource("").getPath();
//		System.out.println("static ==>" + path);
	}

	@Test
	public void getPath() {
		ClassLoader cls = ClassLoader.getSystemClassLoader();
		ClassLoader classCls = TestPath.class.getClassLoader();
		ClassLoader threadCls = Thread.currentThread().getContextClassLoader();
		System.out.println(ClassLoader.getSystemResource("").getPath());
		System.out.println(TestPath.class.getClassLoader().getResource("")
				.getPath());
		System.out.println(Thread.currentThread().getContextClassLoader()
				.getResource("").getPath());
		System.out.println(cls == classCls);
		System.out.println(cls == threadCls);
	}

	/**
	 * 带/,是表示类加载路径得跟路径</br>
	 *不带/,是相对路径,相对于当前类</br>
	 * http://www.cnblogs.com/yejg1212/p/3270152.html</br>
	 * http://swiftlet.net/archives/868</br>
	 */
	@Test
	public void getDiffResourcePath() {
		// 输出编译文件夹根目录
		File f = new File(this.getClass().getResource("/").getPath());
		System.out.println(f);
		// 输出编译文件夹根路径+包路径
		File f2 = new File(this.getClass().getResource("").getPath());
		System.out.println(f2);
	}
	/**
	 * 测试classloader 获取类加载路径</br>
	 * classloader 获取path时候,直接写相对路径即可</br>
	 * 前面加 / 是会报错的(返回的url对象是null).</br>
	 * 需要将该包下的text.txt，放到根路径下测试</br>
	 * http://www.cnblogs.com/yejg1212/p/3270152.html</br>
	 * http://swiftlet.net/archives/868</br>
	 * 
	 */
	@Test
	public void getDiffClassloaderResourcePath() {
		// 类加载路径的根路径下
	    URL resourcePath = TestPath.class.getClassLoader().getResource("");
	    URL resourceFile = TestPath.class.getClassLoader().getResource("test.txt");
	    URL resWrongPath = TestPath.class.getClassLoader().getResource("/");
	    URL resWrongFile = TestPath.class.getClassLoader().getResource("/test.txt");
	    System.out.println(resourcePath);
	    System.out.println(resWrongPath);
	    System.out.println(resourceFile);
	    System.out.println(resWrongFile);
	}


	@Test
	public void getSymbol() throws IOException {
		//分隔符   在win下是 \ 
		System.out.println(File.separator);
		System.out.println(File.separatorChar);

		System.out.println("跨系统的分隔符↓");
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);

		/*
		 * You use separator when you are building a file path. So in unix the
		 * separator is /. So if you wanted to build the unix path /var/temp you
		 * would do it like this:
		 * 
		 * String path = File.separator + "var"+ File.separator + "temp"
		 * 
		 * You use the pathSeparator when you are dealing with a list of files
		 * like in a classpath. For example, if your app took a list of jars as
		 * argument the standard way to format that list on unix is:
		 * /path/to/jar1.jar:/path/to/jar2.jar:/path/to/jar3.jar
		 * 
		 * So given a list of files you would do something like this:
		 * 
		 * String listOfFiles = ... String[] filePaths =
		 * listOfFiles.split(File.pathSeparator);
		 */
		// 获得跨系统的换行符 4种方法,
		System.out.println("跨系统的换行符==>" + System.lineSeparator()); // java7以上才支持
		System.out.println("------------");
		System.out.println("跨系统的换行符==>" + System.getProperty("line.separator"));
		System.out.println("------------");
		System.out.println("跨系统的换行符==>" + String.format("%n"));
		System.out.println("------------");
		// 第4种是BufferedWriter 的newline方法
		OutputStream is = null;
		Writer w = null;
		BufferedWriter bw = null;
		try {
			is = new FileOutputStream(new File("path"));
			w = new OutputStreamWriter(is);
			bw = new BufferedWriter(w);
			bw.write("hello world");
			bw.newLine();
			bw.write("hello world");
			bw.newLine();
			bw.write("hello world");
			bw.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close();
			}
			if (w != null) {
				w.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}

	// public void getPath2() throws IOException{
	// File directory = new File("");//参数为空
	// String courseFile = directory.getCanonicalPath() ;
	// System.out.println(courseFile);
	// }
	public static void main(String[] args) {
		String path = Object.class.getResource("").getPath();
		System.out.println(path);
	}
	@Test
	public void testPath() throws Exception {
		File file = new File("test.txt");
		System.out.println(file.getAbsolutePath());
	}
}
