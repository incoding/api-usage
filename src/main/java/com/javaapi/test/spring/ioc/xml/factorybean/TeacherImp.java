package com.javaapi.test.spring.ioc.xml.factorybean;


public class TeacherImp implements WorkerI {
	private String name;
	private Student	student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void work() {
		String x = name + "正在上课,学生是:" + getStudent().getName()+",年龄是:"+getStudent().getAge();
		System.out.println(x);
	}

}
