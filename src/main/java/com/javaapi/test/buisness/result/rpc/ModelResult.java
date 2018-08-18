package com.javaapi.test.buisness.result.rpc;

import com.javaapi.test.buisness.exception.bussiness.exception_v2.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class ModelResult<T> implements Serializable {
	private static final long	serialVersionUID	= -7587490467224725757L;
	transient Logger logger				= LoggerFactory
															.getLogger(ModelResult.class);
	private T					model;
	private boolean				isSuccess			= true;
	private boolean				isCache				= false;
	/**
	 * 处错误时候,是否由后端人员返回信息给用户,如果为true则返回backResponse
	 */
	private boolean				isBackerResponse	= false;
	// TODO

	/**
	 * 出错误时候,由后端人员返回给用户得信息 TODO 需要区分是业务返回值,还是异常返回值
	 */
	private ErrorCode errorCode;
	/**
	 * 出错误时得输入参数,给开发人员用,对client和server都进行log,帮助发现问题
	 */
	private String				inputParam;

	/**
	 * 出错时候得堆栈,字符串形式.给开发人员用,对client和server都进行log,帮助发现问题
	 */
	private String				detailStack			= "";

	/**
	 * client端开发人员用. 如果需要判断失败的情况,调用isFail(),不要用 !isSuccess()
	 * 
	 * @return success :bolean ,fail : false
	 */
	public boolean isSuccess() {
		return this.isSuccess;
	}

	/**
	 * client端开发人员用. 如果需要判断失败的情况,调用isFail(),不要用 !isSuccess()
	 * 
	 */
	public boolean isFail() {
		return !this.isSuccess;
	}

	public ModelResult<T> withModel(T t) {
		this.model = t;
		return this;
	}

	public ModelResult<T> withError(String string) {
		this.errorCode = ErrorCode.commonError(string);
		this.isSuccess = false;
		return this;
	}

	public ModelResult<T> withError(String string, String inputParam) {
		this.errorCode = ErrorCode.commonError(string);
		this.isSuccess = false;
		this.inputParam = inputParam;
		return this;
	}

	public ModelResult<T> withError(String string, Exception e) {
		this.errorCode = ErrorCode.commonError(string);
		this.isSuccess = false;
		this.detailStack = printStack(e);
		return this;
	}

	public ModelResult<T> withError(String string, String inputParam,
			Exception e) {
		this.errorCode = ErrorCode.commonError(string);
		this.isSuccess = false;
		this.detailStack = printStack(e);
		return this;
	}

	// errorcode
	public ModelResult<T> withError(ErrorCode errorCode, Exception e) {
		this.errorCode = errorCode;
		this.isSuccess = false;
		this.detailStack = printStack(e);
		return this;
	}
	/**
	 * 仅供类内部使用,不要修改为public
	 * 
	 * @param e
	 * @return
	 */
	private String printStack(Throwable e) {
		StringBuilder sb = new StringBuilder(512);
		for (StackTraceElement line : e.getStackTrace()) {
			sb.append("\tat ").append(line).append("\r\n");
		}
		return sb.toString();
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public boolean isBackerResponse() {
		return isBackerResponse;
	}

	public void setBackerResponse(boolean isBackerResponse) {
		this.isBackerResponse = isBackerResponse;
	}

	public boolean isCache() {
		return isCache;
	}

	public void setCache(boolean isCache) {
		this.isCache = isCache;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getInputParam() {
		return inputParam;
	}

	public void setInputParam(String inputParam) {
		this.inputParam = inputParam;
	}

	public String getDetailStack() {
		return detailStack;
	}

	public void setDetailStack(String detailStack) {
		this.detailStack = detailStack;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
