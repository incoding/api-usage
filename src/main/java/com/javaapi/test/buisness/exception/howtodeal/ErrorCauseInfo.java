package com.javaapi.test.buisness.exception.howtodeal;


/**
 * 错误信息
 *
 */
public class ErrorCauseInfo {

	private boolean success = false;
	
	private int errorCode;
	
	private String errorMsg;
	
	public ErrorCauseInfo(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public ErrorCauseInfo(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public ErrorCauseInfo(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
		
}
