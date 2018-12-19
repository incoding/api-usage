package com.javaapi.test.test.javafeature.innerClass;

import org.junit.Test;

/**
 *
 * 
 */
public class Client {



	/**
	 * 如果方法参数过多,而且不想在外部包写个参数占用位置,可以直接写在类里
	 */
	@Test
	public void testInnerParam() {
		Client client = new Client();
		ClientInnerPrivate clientInnerPrivate = new ClientInnerPrivate();
		clientInnerPrivate.setName("123");
		client.testMethodInnerParam(clientInnerPrivate);
	}

	@Test
	public void testPrivate() {
		ClientInnerPrivate clientInner = new ClientInnerPrivate();
		clientInner.setName("testPrivate");
		System.out.println(clientInner.getName());
		System.out.println(clientInner.name);
	}

	@Test
	public void testProtected() {
		ClientInnerProtected clientInner = new ClientInnerProtected();
		clientInner.setName("testProtected");
		System.out.println(clientInner.getName());
		System.out.println(clientInner.name);
	}

	public void testMethodInnerParam(ClientInnerPrivate innerParam) {
		System.out.println(innerParam.getName());
	}

	private class ClientInnerPrivate {
		private String	name;
		private String	age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

	}

	protected class ClientInnerProtected {
		private String	name;
		private String	age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

	}
}
