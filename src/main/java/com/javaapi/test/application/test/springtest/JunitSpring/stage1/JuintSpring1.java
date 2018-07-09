package com.javaapi.test.application.test.springtest.JunitSpring.stage1;

import com.javaapi.test.application.test.springtest.JunitSpring.School;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 *   AbstractJUnit4SpringContextTests</br>
 *   1 避免硬编码getBean</br>
 *   2 不会进行多次spring容器初始化-速度加快</br>
 *
 */
@ContextConfiguration("applicationContext.xml")
public class JuintSpring1 extends AbstractJUnit4SpringContextTests{
	@Autowired
	public School school;
	
	@Test
	public void test(){
		school.haveClass();
	}
}
