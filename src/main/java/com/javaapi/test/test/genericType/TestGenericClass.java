package com.javaapi.test.test.genericType;

/**
 * 泛型类
 */
public class TestGenericClass<T> {
	private T t;
	private String information;

	public TestGenericClass(T oT) {
		this.t = oT;
	}

	public void setData(String sBrand, String sName, String sPrice) {
		this.information = "This " + sName + " of " + sBrand + " costs "
				+ sPrice + "!";
	}

	public String getClassType() {
		return t.getClass().getName();
	}

	public static void main(String[] args) {
		String string = "aa";
		Integer integer = 0;
		TestGenericClass<String> t = new TestGenericClass<String>(string);
		System.out.println(t.getClassType());
		TestGenericClass<Integer> i = new TestGenericClass<Integer>(integer);
		System.out.println(i.getClassType());
	}
	// 省略了set/get方法
}