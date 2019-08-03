package com.javaapi.test.buisness.pattern.structure.Composite;

import java.util.List;

/**
 * http://blog.csdn.net/jason0539/article/details/22642281</br>
 *3.什么情况下使用组合模式
       引用大话设计模式的片段：“当发现需求中是体现部分与整体层次结构时，以及你希望用户可以忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象时，就应该考虑组合模式了。”
 *
 */
public class Test {

	public static void main(String[] args) {
		Employer pm = new ProjectManager("项目经理");
		Employer pa = new ProjectAssistant("项目助理");
		Employer programmer1 = new Programmer("程序员一");
		Employer programmer2 = new Programmer("程序员二");

		pm.add(pa);// 为项目经理添加项目助理
		pm.add(programmer1);// 为项目经理添加程序员
		pm.add(programmer2);// 为项目经理添加程序员

		List<Employer> ems = pm.getEmployers();
		for (Employer em : ems) {
			System.out.println(em.getName());
		}
	}
}
