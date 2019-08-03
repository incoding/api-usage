package com.javaapi.test.spring.spring.ioc.annotation.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherImp extends TeacherSuper implements WorkerI {
	@Autowired
	public TeacherDepend teacherDepend;
	static{
		System.out.println(TeacherImp.class.getSimpleName());
	}
	{
		System.out.println(TeacherImp.class.getSimpleName()+"实例初始化块");
	}
	public TeacherImp(){
		System.out.println(TeacherImp.class.getSimpleName()+"构造函数");
		System.out.println(this);
		System.out.println(TeacherImp.class.getSimpleName()+"现在得直接依赖==>"+teacherDepend);
	}
	
	// 直接写,不要通过annotation注入基础类型,不然会很麻烦
	private String name="wk-annotation";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void work() {
		String x = name+"正在上课";
		System.out.println(x);
	}

	public TeacherDepend getTeacherDepend() {
		return teacherDepend;
	}

	public void setTeacherDepend(TeacherDepend teacherDepend) {
		System.out.println("注入=================");
		this.teacherDepend = teacherDepend;
	}
	
	
	

}
