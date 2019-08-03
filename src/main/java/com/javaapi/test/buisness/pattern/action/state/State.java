package com.javaapi.test.buisness.pattern.action.state;

public interface State {
	/**
	 * 状态对应的处理
	 */
	public void handle(String sampleParameter);
}
