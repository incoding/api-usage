package com.javaapi.test.test.testReflect;

import java.lang.reflect.Field;
import java.util.Arrays;

public class PrintUtil {
	public static void print(People p) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		// People p = new People();
		Class<?> c = p.getClass();
		// -------------------------------
		Field Id = c.getDeclaredField("id");
		System.out.println("id原来的值:" + p.id);
		Id.setInt(p, 2);
		System.out.println("id改动后的值:" + p.id);
		// ---------------------------------
		Field gender = c.getDeclaredField("sex");
		System.out.println("sex原来的值:" + p.sex);
		gender.set(p, Sex.FEMALE);
		System.out.println("sex改动后的值:" + p.sex);
		// ----------------------------------
		Field fri = c.getDeclaredField("friends");
		System.out.println("friends原来的值:" + Arrays.asList(p.friends));
		String[] newFriends = { "赵六", "小七" };
		fri.set(p, newFriends);
		System.out.println("friends改动后的值:" + Arrays.asList(p.friends));

	}
}
