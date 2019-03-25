package com.javaapi.test.buisness.joint.error;

import java.io.Serializable;

/**
 * Created by user on 16/2/21.
 */
public class BaseError implements Serializable{
    private static final long serialVersionUID = -1;

    public static final BaseError NEED_LOGIN = new BaseError(BaseErrorConstant.COMMON_BIZ_NEEDLOGIN, BaseErrorConstant.COMMON_BIZ_NEEDLOGIN_MSG);
    public static final BaseError SYS_ERR = new BaseError(BaseErrorConstant.COMMON_SYS_ERR, BaseErrorConstant.COMMON_SYS_ERR_MSG);


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
        final StringBuilder sb = new StringBuilder("BaseError{");
        sb.append("code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
