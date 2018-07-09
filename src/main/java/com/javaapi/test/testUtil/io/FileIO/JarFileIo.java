package com.javaapi.test.testUtil.io.FileIO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.Test;


/**
 * 测试从jar中读取资源文件和类
 * 1 这主要是因为jar包是一个单独的文件而非文件夹，绝对不可能通过"file:/e:/.../ResourceJar.jar/resource /res.txt"这种形式的文件URL来定位res.txt。</br>
 * 所以即使是相对路径，也无法定位到jar文件内的txt文件(读者也许对这段原因解释有些费解，在下面我们会用一段代码运行的结果来进一步阐述)。</br>
 * 2 向项目中加入任意jar,http://marionette.iteye.com/blog/1721369
 *
 */

public class JarFileIo {
	/**
	 * 用于命令行下的测试
	 */
	public static void main(String[] args) {
		readResource();
	}
	/**
	 * 测试读取资源文件
	 */
	@Test
	public void testRead() {
		readResource();
		readClass();
	}
	private static void readClass() {
//		ClassLoader cl = ClassLoader.getSystemClassLoader();
//		try {
//			Class peopleClass = (Class) cl
//					.loadClass("jarfile.com.jarfile.People");
//			People people = (People) peopleClass.newInstance();
//			people.setName("kk");
//			people.setAge("26");
//			System.out.println(people.getName());
//			System.out.println(people.getAge());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 在classpath下的jar,直接读取里面的内容就可以</br>
	 * 		1 不重要的小细节----如果将jarFile-1.0.jar 加入类加载路径,源码中会隐藏.
			2 然后JarFileIo.class.getResourceAsStream 这段代码会生效(如果不加入类加载路径,则这段代码不生效)
	 */
	/**
	 * 从这段文字表述中我们不难发现，getResourceAsStream()在查找资源时跟JVM所用的OS毫无关系，甚至跟资源所在文件系统的路径也是无关的，它是基于类路径进行查找的</br>
	 * 也就是说，当jar包或*.class文件加载之后，JVM会根据jar包或*.class文件所在的classpath属性去查找指定的资源，而这个classpath是在jar包的MANIFEST.MF文件中指定的</br>
	 * @see http://zorro.blog.51cto.com/2139862/869765   好</br>
	 * 
	 */
	private static void readResource() {
		
				InputStream jarIn=JarFileIo.class.getResourceAsStream("/jarfile/jarfile.txt");
				System.out.println(JarFileIo.class.getResource("").getPath());
				InputStreamReader reader=new InputStreamReader(jarIn);
				 char[] data = new char[100];
				 try {
					reader.read(data);
					System.out.println(new String(data));
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	/**
	 * 对于不在ClassPath下的Jar包的读取，当作一个本地文件用JarFile读取即可。</br>
	 * 路径可使用绝对路径。或者用上面的url.getConnection也可以处理。这里不再实现。</br>
	 * @throws IOException 
	 */
	@Test
	public void readJarLocal() throws IOException {
		 File file = new  File("jar:/C:\\Users\\hncw\\Desktop\\jario\\jarfile-1.0.jar!/");
		 JarURLConnection jarCon = (JarURLConnection)  file.toURL().openConnection();
		 JarFile jarFile = jarCon.getJarFile();
		 Enumeration<JarEntry> jarEntrys = jarFile.entries();
		 while (jarEntrys.hasMoreElements()) {
		 JarEntry entry = jarEntrys.nextElement();
		 // 简单的判断路径，如果想做到想Spring，Ant-Style格式的路径匹配需要用到正则。
		 String name = entry.getName();
		 System.out.println(name);
		 }
	}
	@Test
	public void testProtocal() throws IOException {
		   String host = "www.java2s.com"; 
           String file = "/index.html"; 
           String[] schemes = {"http", "https", "ftp", "mailto", "telnet", "file", "ldap", "gopher", 
                           "jdbc", "rmi", "jndi", "jar", "doc", "netdoc", "nfs", "verbatim", "finger", "daytime", 
                           "systemresource"}; 

           for (int i = 0; i < schemes.length; i++) { 
                   try { 
                           URL u = new URL(schemes[i], host, file); 
                           System.out.println(schemes[i] + " is supported\r\n"); 
                   } catch (Exception ex) { 
                           System.out.println(schemes[i] + " is not supported\r\n"); 
                   } 
           } 
	}

}
