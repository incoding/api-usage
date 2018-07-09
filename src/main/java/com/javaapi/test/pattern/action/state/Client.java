package com.javaapi.test.pattern.action.state;
//很容易让人想到的一种使用方式.
/**
 * 本例子中得状态模式，有点不对:
 * 1 状态模式，状态得变换要在context或者state中,而不世客户端转变
 * @project apiTest
 * @author kk
 * @date 2015年2月13日
 */
public class Client {

	public static void main(String[] args) {
		// 创建状态
		State state = new ConcreteStateB();
		// 创建环境
		Context context = new Context();
		// 将状态设置到环境中
		context.setState(state);
		// 请求
		context.request("test");
	}
}