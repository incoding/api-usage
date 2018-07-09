package com.javaapi.test.spring.zotherFeature.javaconfig.javaconfig_v2;


import org.springframework.stereotype.Component;

@Component
public class TeacherImp implements WorkerI {
	// 直接写,不要通过annotation注入基础类型,不然会很麻烦
	private String name="wk-init will be overide";
	
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

}
