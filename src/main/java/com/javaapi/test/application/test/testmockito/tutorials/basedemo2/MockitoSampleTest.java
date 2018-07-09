package com.javaapi.test.application.test.testmockito.tutorials.basedemo2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/** 1 入门
 * http://stamen.iteye.com/blog/1470066</br>
 * <p>
 * Stub对象用来提供测试时所需要的测试数据，可以对各种交互设置相应的回应。例如我们可以设置方法调用的返回值等。Mockito中
 * when(…).thenReturn(…) 这样的语法便是设置方法调用的返回值。另外也可以设置方法在何时调用会抛出异常等。
 * </p>
 * <p>
 * Mock对象用来验证测试中所依赖对象间的交互是否能够达到预期。Mockito中用 verify(…).methodXxx(…) 语法来验证
 * methodXxx方法是否按照预期进行了调用
 * </p>
 */
public class MockitoSampleTest {

	// ① 对接口进行模拟
	UserService		mockUserService	= mock(UserService.class);
	// ② 对类进行模拟
	UserServiceImpl	mockServiceImpl	= mock(UserServiceImpl.class);
	// ③ 基于注解模拟类
	@Mock
	User			mockUser;

	@Before
	public void initMocks() {
		// ④ 初始化当前测试类所有@Mock注解模拟对象
		MockitoAnnotations.initMocks(this);
	}

	// ① 模拟接口UserService测试
	@Test
	public void testMockInterface() {
		// ①-1 对方法设定返回值
		when(mockUserService.findUserByUserName("tom")).thenReturn(
				new User("tom", "1234"));
		// ①-2 对方法设定返回值
		doReturn(true).when(mockServiceImpl).hasMatchUser("tom", "1234");
		// ①-3 对void方法进行方法预期设定
		User u = new User("John", "1234");
		doNothing().when(mockUserService).registerUser(u);

		// ①-4 执行方法调用
		User user = mockUserService.findUserByUserName("tom");
		boolean isMatch = mockUserService.hasMatchUser("tom", "1234");
		mockUserService.registerUser(u);

		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(false, isMatch);
	}

	// ② 模拟实现类UserServiceImpl测试
	@Test
	public void testMockClass() {
		// 对方法设定返回值
		when(mockServiceImpl.findUserByUserName("tom")).thenReturn(
				new User("tom", "1234"));
		doReturn(true).when(mockServiceImpl).hasMatchUser("tom", "1234");

		User user = mockServiceImpl.findUserByUserName("tom");
		boolean isMatch = mockServiceImpl.hasMatchUser("tom", "1234");
		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);
	}

	// ③ 模拟User类测试
	@Test
	public void testMockUser() {
		when(mockUser.getUserId()).thenReturn(String.valueOf(1));
		when(mockUser.getUserName()).thenReturn("tom");
		assertEquals(mockUser.getUserId(), String.valueOf(1));
		assertEquals(mockUser.getUserName(), "tom");
	}
}  