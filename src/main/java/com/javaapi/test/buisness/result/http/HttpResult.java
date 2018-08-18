package com.javaapi.test.buisness.result.http;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/2/21.
 */
public class HttpResult<T> implements Serializable {
    private static final long serialVersionUID = -1;
    /**
     *code 为success时候是业务处理成功,此时取result 为具体需要得数据,msg固定为"成功"
     其他数字则为有问题,此时取msg是单个错误说明
     前端根据不同数字,制定行为标准,比如 common 为直接显示错误信息即可
     其他code码需要自己定制,ps:建议  code码可以使用英语单词,则此时code应该使用string类型
     */
    private boolean ok;
    private String code;
    private String msg;
    private T data;
    /**
     *需要批量错误的场景 再用errorList
      */
    private List<HttpError> errorList;
    public HttpResult(HttpError httpError) {
        this.ok = false;
        this.code = httpError.getCode();
        this.msg = httpError.getMsg();
    }

    public HttpResult(boolean ok, String code, String msg, T data) {
        this.ok = ok;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public HttpResult(boolean ok, String code, String msg, T data, List<HttpError> errorList) {
        this.ok = ok;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.errorList = errorList;
    }

    public static <T> HttpResult<T> ok() {
        return new HttpResult<>(true, HttpError.G_SUCCESS_CODE, HttpError.G_SUCCESS_MSG, null);
    }
    public static <T> HttpResult<T> ok(T result) {
        return new HttpResult<>(true, HttpError.G_SUCCESS_CODE, HttpError.G_SUCCESS_MSG, result);
    }

    public static <T> HttpResult<T> displayError(String msg) {
        return new HttpResult<>(false, HttpError.G_ERROR_DISPLAY_CODE, msg, null);
    }

    public static <T> HttpResult<T> error(String code, String msg) {
        return new HttpResult<>(false, code, msg, null);
    }
    public static <T> HttpResult<T> error(HttpError httpError) {
        return new HttpResult<>(httpError);
    }

    public static <T> HttpResult<T> error(String code, String msg, T result) {
        return new HttpResult<>(false, code, msg, result);
    }

    public static <T> HttpResult<T> errorList() {
        HttpResult<T> objectHttpResult = new HttpResult<>(false, HttpError.G_ERROR_LIST, null, null, new ArrayList<HttpError>());
        return objectHttpResult;
    }

    public static <T> HttpResult<T> errorList(HttpError error) {
        HttpResult<T> objectHttpResult = new HttpResult<>(false, HttpError.G_ERROR_LIST, null, null, new ArrayList<HttpError>());
        objectHttpResult.addError(error);
        return objectHttpResult;
    }
    public static <T> HttpResult<T> errorList(String code,String msg) {
        HttpResult<T> objectHttpResult = new HttpResult<>(false, HttpError.G_ERROR_LIST, null, null, new ArrayList<HttpError>());
        objectHttpResult.addError(new HttpError(code,msg));
        return objectHttpResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<HttpError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<HttpError> errorList) {
        this.errorList = errorList;
    }

    public HttpResult<T> addError(HttpError error) {
        if (this.getErrorList() == null) {
            this.code = HttpError.G_ERROR_LIST;
            this.errorList = new ArrayList<>();
        }
        this.getErrorList().add(error);
        return this;
    }

    public HttpResult<T> addError(String code, String msg) {

        if (this.getErrorList() == null) {
            this.ok = false;
            this.code = HttpError.G_ERROR_LIST;
            this.errorList = new ArrayList<>();
        }
        this.getErrorList().add(new HttpError(code, msg));
        return this;
    }


    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    // 人性化方法 易于读取
    @JSONField(serialize = false)
    public boolean isFail() {
        return !isOk();
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HttpResult{");
        sb.append("ok=").append(ok);
        sb.append(", code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append(", errorList=").append(errorList);
        sb.append('}');
        return sb.toString();
    }


}
