package com.javaapi.test.buisness.exception.bussiness.exception.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCode error;

	private Object ext;

	public <T> T getExt() {
		return (T)ext;
	}

	public void setExt(Object ext) {
		this.ext = ext;
	}



	public BusinessException(ErrorCode error) {
		super();
		this.error = error;
	}
	public BusinessException(ErrorCode error,Object ext) {
		super();
		this.error = error;
		this.ext = ext;
	}


	public BusinessException(String message, Throwable cause,ErrorCode error) {
		super(message, cause);
		this.error = error;
	}

	public ErrorCode getError() {
		return error;
	}

	public void setError(ErrorCode error) {
		this.error = error;
	}

    /**
     * 重写异常提高性能
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
