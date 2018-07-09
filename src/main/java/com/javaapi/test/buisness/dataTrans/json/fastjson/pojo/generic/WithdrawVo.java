package com.javaapi.test.buisness.dataTrans.json.fastjson.pojo.generic;

public class WithdrawVo<T> {

	private String RESULT;
	private T DATA;
	
	public String getRESULT() {
		return RESULT;
	}
	public void setRESULT(String RESULT) {
		this.RESULT = RESULT;
	}
	public T getDATA() {
		return DATA;
	}
	public void setDATA(T DATA) {
		this.DATA = DATA;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("WithdrawVo{");
		sb.append("RESULT='").append(RESULT).append('\'');
		sb.append(", DATA=").append(DATA);
		sb.append('}');
		return sb.toString();
	}
}
