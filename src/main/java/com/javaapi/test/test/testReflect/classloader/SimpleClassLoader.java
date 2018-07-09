package com.javaapi.test.test.testReflect.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 1 一般覆写findClass方法 </br> 2 loadClass里面包含了父类委托机制,以及缓存机制
 * 
 */
public class SimpleClassLoader extends ClassLoader {
	String[] dirs;

	public String[] getDirs() {
		return dirs;
	}

	public void setDirs(String[] dirs) {
		this.dirs = dirs;
	}

	public SimpleClassLoader(String path) {
		dirs = path.split(System.getProperty("path.separator"));
		String[] _dirs = dirs.clone();
		for (String dir : _dirs) {
			extendClasspath(dir);
		}
	}

	public void extendClasspath(String path) {
		String[] segments = path.split("/");
		String[] exDirs = new String[segments.length];
		for (int i = 0; i < (segments.length); i++) {
			exDirs[i] = popd(segments, i);
		}

		String[] newDirs = new String[dirs.length + exDirs.length];
		System.arraycopy(dirs, 0, newDirs, 0, dirs.length);
		System.arraycopy(exDirs, 0, newDirs, dirs.length, exDirs.length);
		dirs = newDirs;
	}

	private String popd(String[] pathSegments, int level) {
		StringBuffer path = new StringBuffer();
		for (int i = 0; i < level; i++) {
			path.append(pathSegments[i]).append("/");
		}
		return path.toString();
	}

	/**
	 * 覆写findclass </br>1 获取类路径</br> 2 将类路径下的.class文件转成二进制数组</br>3
	 * 将二进制数组传入defineClass获取Class类
	 */
	public synchronized Class findClass(String name)
			throws ClassNotFoundException {

		for (String dir : dirs) {
			byte[] buf = getClassData(dir, name);
			if (buf != null)
				System.out.println("Loaded '" + name + "' from: " + dir);
			return defineClass(name, buf, 0, buf.length);
		}
		throw new ClassNotFoundException();
	}

	protected byte[] getClassData(String directory, String name) {
		String[] tokens = name.split("\\.");
		String classFile = directory + "/" + tokens[tokens.length - 1]
				+ ".class";
		File f = (new File(classFile));
		int classSize = (new Long(f.length())).intValue();
		byte[] buf = new byte[classSize];
		try {
			FileInputStream filein = new FileInputStream(classFile);
			classSize = filein.read(buf);
			filein.close();
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return buf;
	}

	public static void main(String[] args) {
		SimpleClassLoader cl = new SimpleClassLoader(
				"/Users/weli/projs/java-snippets/target/classes");
		for (String dir : cl.getDirs()) {
			System.out.println(dir);
		}
	}
}
