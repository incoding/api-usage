package com.javaapi.test.buisness.joint.result.rpc;

import com.javaapi.test.buisness.joint.result.base.BaseError;
import com.javaapi.test.buisness.joint.result.base.BaseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/3/7
 */
public class RpcResult<T> extends BaseResult<T> {


    /**
     * 后端出错误时候,是否由后端人员返回信息给用户,
     * 如果为true则返回后端错误码
     * 如果为false,由前端决定返回给用户的信息
     */
    private Boolean readServerSide;

    /**
     * 出错误时得输入参数,给开发人员用,对client和server都进行log,帮助发现问题
     */
    private String param;

    /**
     * 出错时候得堆栈,字符串形式.给开发人员用,对client和server都进行log,帮助发现问题
     */
    private String detailStack;




    public RpcResult() {
    }

    public RpcResult(BaseError baseError) {
        super(baseError);
    }

    public RpcResult(boolean ok, String code, String msg, T data) {
        super(ok, code, msg, data);
    }

    public RpcResult(boolean ok, String code, String msg, T data, List<BaseError> errorList) {
        super(ok, code, msg, data, errorList);
    }


    private String printStack(Throwable e) {
        StringBuilder sb = new StringBuilder(512);
        for (StackTraceElement line : e.getStackTrace()) {
            sb.append("\tat ").append(line).append("\r\n");
        }
        return sb.toString();
    }


    public static <T> RpcResult<T> ok() {
        return new RpcResult<>(true, BaseError.G_SUCCESS_CODE, BaseError.G_SUCCESS_MSG, null);
    }

    public static <T> RpcResult ok(T result) {
        return new RpcResult<>(true, BaseError.G_SUCCESS_CODE, BaseError.G_SUCCESS_MSG, result);
    }

    /**
     * easy to display
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RpcResult<T> newDisplayError(String msg) {
        return new RpcResult<>(false, BaseError.G_ERROR_DISPLAY_CODE, msg, null);
    }

    public static <T> RpcResult<T> newError(String code, String msg) {
        return new RpcResult<>(false, code, msg, null);
    }

    public static <T> RpcResult<T> newError(BaseError baseError) {
        return new RpcResult<>(baseError);
    }

    public static <T> RpcResult<T> newError(String code, String msg, T result) {
        return new RpcResult<>(false, code, msg, result);
    }

    public static <T> RpcResult<T> newErrorList() {
        RpcResult<T> rpcResult = new RpcResult<>(false, BaseError.G_ERROR_LIST, null, null, new ArrayList<>());
        return rpcResult;
    }

    public static <T> RpcResult<T> newErrorList(BaseError error) {
        RpcResult<T> rpcResult = new RpcResult<>(false, BaseError.G_ERROR_LIST, null, null, new ArrayList<>());
        rpcResult.errorListAdd(error);
        return rpcResult;
    }

    public static <T> RpcResult<T> newErrorList(String code, String msg) {
        RpcResult<T> rpcResult = new RpcResult<>(false, BaseError.G_ERROR_LIST, null, null, new ArrayList<>());
        rpcResult.errorListAdd(new BaseError(code, msg));
        return rpcResult;
    }

    @Override
    public RpcResult<T> errorListAdd(BaseError error) {
        if (this.getErrorList() == null) {
            this.setCode(BaseError.G_ERROR_LIST);
            this.setErrorList(new ArrayList<>());
        }
        this.getErrorList().add(error);
        return this;
    }

    @Override
    public RpcResult<T> errorListAdd(String code, String msg) {
        if (this.getErrorList() == null) {
            this.setOk(false);
            this.setCode(BaseError.G_ERROR_LIST);
            this.setErrorList(new ArrayList<>());
        }
        this.getErrorList().add(new BaseError(code, msg));
        return this;
    }


    @Override
    public RpcResult<T> beError(BaseError baseError) {
        this.setOk(false);
        this.setCode(baseError.getCode());
        this.setMsg(baseError.getMsg());
        return this;
    }

    @Override
    public RpcResult<T> beError(String code, String msg) {
        this.setOk(false);
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public RpcResult<T> readServerSide() {
        this.readServerSide = true;
        return this;
    }


    /********************* getter and setter *******************/

    public Boolean getReadServerSide() {
        return readServerSide;
    }


    public RpcResult<T> setReadServerSide(Boolean readServerSide) {
        this.readServerSide = readServerSide;
        return this;
    }

    public String getParam() {
        return param;
    }

    public  RpcResult<T> setParam(String param) {
        this.param = param;
        return this;
    }

    public String getDetailStack() {
        return detailStack;
    }

    public RpcResult<T> setDetailStack(Throwable e) {
        this.detailStack = printStack(e);
        return this;
    }

    public void setDetailStack(String detailStack) {
        this.detailStack = detailStack;
    }



}
