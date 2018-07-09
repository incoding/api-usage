package com.javaapi.test.test.dataStructure;

import java.util.HashSet;
import java.util.Set;

public class TestSample2 {
	public String name;
	public String age;
	public Integer i;

	public TestSample2(String name, String age, Integer i) {
		super();
		this.name = name;
		this.age = age;
		this.i = i;
	}

	public static void main(String[] args) {
		TestSample2 t1 = new TestSample2("kk", "18", 18);
		TestSample2 t2 = new TestSample2("kk", "18", 18);
		// 测试1 应该相等
		System.out.println(t1.equals(t2));
		Set<TestSample2> set = new HashSet<TestSample2>();
		set.add(t1);
		set.add(t2);
		// 测试2 应该集合里只有一个元素
		System.out.println(set);
		System.out.println(set.size());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestSample2 other = (TestSample2) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "TestSample2 [name=" + name + ", age=" + age + ", i=" + i + "]";
	}

}