package com.javaapi.test.spring.feature.function.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class People implements InitializingBean,DisposableBean{
	public String name;
	public String age;
	
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
	
	public void preconstruct(){
		System.out.println("init-method==>"+this.getName());
	}
	public void destroymethod(){
		System.out.println("destroy-method==>"+this.getName());
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean==>"+this.getName());
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean==>"+this.getName());
	}
	@PostConstruct
	public void c(){
		System.out.println("@PostConstrucc==>"+this.getName());
	}
	@PostConstruct
	public void d(){
		System.out.println("@PostConstructd==>"+this.getName());
	}
	@PreDestroy
	public void a(){
		System.out.println("@PreDestroya==>"+this.getName());
	}
	
	@PreDestroy
	public void b(){
		System.out.println("@PreDestroyb==>"+this.getName());
	}
}
