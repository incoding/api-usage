package com.javaapi.test.buisness.exception.bussiness.exception.exception;

/**
 * 异常错误,根据不同得错误码进行不同操作
 *
 */
public class ErrorCode {
	
	//  commonError 无法处理，提供给用户看，并且调用方程序员打日志
	public static final ErrorCode commonError = new ErrorCode(10000,"一般错误,错误信息是给用户看得");
	// programError 无法处理，供调用方程序员打日志
	public static final ErrorCode programError = new ErrorCode(10001,"程序错误,错误信息是给调用端程序员看得");
	
	
	//根据错误码，做相应处理
	public static final ErrorCode needRetry3 = new ErrorCode(20000,"因乐观锁导致重试3次");
	
	
	public static final ErrorCode doNotRetry = new ErrorCode(20001,"因乐观锁或其他异常,不需要重试");

	private int index;
	private String msg;
	public static ErrorCode commonError(String msg) {
		ErrorCode errorCode = new ErrorCode(commonError.getIndex(), msg);
		return errorCode;
	}
	public ErrorCode(int index, String msg) {
		super();
		this.index = index;
		this.msg = msg;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorCode{");
        sb.append("index=").append(index);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
