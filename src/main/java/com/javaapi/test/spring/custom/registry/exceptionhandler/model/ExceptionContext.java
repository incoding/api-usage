package com.javaapi.test.spring.custom.registry.exceptionhandler.model;

import com.javaapi.test.buisness.joint.exception.BusinessException;
import com.javaapi.test.buisness.joint.result.base.BaseResult;

/**
 * Created by user on 2019/10/20
 */
public class ExceptionContext {
    private String code;
    private String msg;
    private boolean needContinue;

    private BusinessException exception;

    private BaseResult result;

    public ExceptionContext() {
    }


    public ExceptionContext(BusinessException exception) {
        this.exception = exception;
        this.code = exception.getError().getCode();
        this.msg = exception.getError().getMsg();
    }

    public ExceptionContext(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public boolean getNeedContinue() {
        return needContinue;
    }

    public void setNeedContinue(boolean needContinue) {
        this.needContinue = needContinue;
    }

    public String getCode() {
        if (exception != null) {
            return exception.getCode();
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        if (exception != null) {
            return exception.getMsg();
        }
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException getException() {
        return exception;
    }

    public void setException(BusinessException exception) {
        this.exception = exception;
    }

    public BaseResult getResult() {
        return result;
    }

    public void setResult(BaseResult result) {
        this.result = result;
    }
}
