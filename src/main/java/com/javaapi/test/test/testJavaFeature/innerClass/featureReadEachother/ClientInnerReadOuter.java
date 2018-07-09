package com.javaapi.test.test.testJavaFeature.innerClass.featureReadEachother;

/**
 * 测试内部读取外部类属性</br>1 内部类总是可以访问外部类得属性</br>
 * 
 */
public class ClientInnerReadOuter {
	private static String	staticname;
	private static String	staticage;

	private String			instancename;
	private String			instanceage;
	{
		instancename = "instancename";
		instanceage = "instanceage";
	}
	static {
		staticname = "staticName";
		staticage = "staticage";
	}

	public class ClientInner {
//		 private static String innername; compile error!
		public void testReadOuterProperty(String[] args) {
			System.out.println(instanceage);
			System.out.println(instancename);
		}
	}

	public static class ClientInnerStatic {
		public static void main(String[] args) {
			System.out.println(staticname);
			System.out.println(staticage);
		}
	}

	public String getInstancename() {
		return instancename;
	}

	public void setInstancename(String name) {
		this.instancename = name;
	}

	public String getInstanceage() {
		return instanceage;
	}

	public void setInstanceage(String age) {
		this.instanceage = age;
	}

}
