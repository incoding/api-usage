package com.javaapi.test.buisness.result.base;

import java.io.Serializable;

/**
 * Created by user on 16/2/21.
 */
public class BaseError implements Serializable{
    private static final long serialVersionUID = -1;

    public static final BaseError NEED_LOGIN = new BaseError("common.biz.needlogin","请先登录");
    public static final BaseError SYS_ERR = new BaseError("common.sys.err","系统内部异常");


    public static final String G_ERROR_LIST = "errorList";
    public static final String G_SUCCESS_CODE = "success";
    public static final String G_SUCCESS_MSG = "成功";
    public static final String G_ERROR_DISPLAY_CODE = "display";



    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseError() {
    }

    public BaseError(String i, String msg) {
        this.code = i;
        this.msg =  msg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HttpError{");
        sb.append("code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
