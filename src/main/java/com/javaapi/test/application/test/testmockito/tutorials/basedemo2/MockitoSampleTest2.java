package com.javaapi.test.application.test.testmockito.tutorials.basedemo2;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * http://mockito.github.io/mockito/docs/current/org/mockito/Mockito.html<br>
 * 如何与Spring整合:https://bitbucket.org/kubek2k/springockito/wiki/Home</br>
 *
 *
 * 2 spring 与mock
 * spring中mock任何容器内对象
 * http://www.cnblogs.com/syxchina/p/4150879.html
 * 把我们mock的testApiService放到apiService中，这样apiService调用就是我们mock的对象了；但是默认spring中apiService对象是代理对象，不能直接把值设置到属性上，所以我们自己写个小的工具类，在最后如下：

 ReflectionTestUtils.setField(AopTargetUtils.getTarget(apiService), "testApiService", spyTestApiService);
 * 
 */
public class MockitoSampleTest2 {

	@SuppressWarnings("unchecked")
	@Test
	public void test(){
		//mock creation
		List<String> mockedList = mock(List.class);
		//using mock object
		mockedList.add("one");
		mockedList.clear();
		//verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
}
