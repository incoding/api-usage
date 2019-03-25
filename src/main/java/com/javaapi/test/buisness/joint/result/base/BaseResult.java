package com.javaapi.test.buisness.joint.result.base;

import com.javaapi.test.buisness.joint.error.BaseError;
import com.javaapi.test.buisness.joint.error.BaseErrorConstant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/2/21.
 */
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -1;
    /**
     * code 为success时候是业务处理成功,此时取result 为具体需要得数据,msg固定为"成功"
     * 其他数字则为有问题,此时取msg是单个错误说明
     * 前端根据不同数字,制定行为标准,比如 common 为直接显示错误信息即可
     * 其他code码需要自己定制,ps:建议  code码可以使用英语单词,则此时code应该使用string类型
     */
    private Boolean ok;
    private String code;
    private String msg;
    private T data;
    /**
     * 需要批量错误的场景 再用errorList
     */
    private List<BaseError> errorList;

    /**
     * 是否从缓存读取
     */
    private Boolean fromCache;

    /**
     * 是否使用后端返回的错误
     */
    private Boolean useError;

    public BaseResult() {
    }

    public BaseResult(BaseError baseError) {
        this.ok = false;
        this.code = baseError.getCode();
        this.msg = baseError.getMsg();
    }

    public BaseResult(boolean ok, String code, String msg, T data) {
        this.ok = ok;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(boolean ok, String code, String msg, T data, List<BaseError> errorList) {
        this.ok = ok;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.errorList = errorList;
    }
    /***************************************/

    public static <T> BaseResult<T> ok() {
        return new BaseResult<>(true, BaseErrorConstant.G_SUCCESS_CODE, BaseErrorConstant.G_SUCCESS_MSG, null);
    }

    public static <T> BaseResult<T> ok(T result) {
        return new BaseResult<>(true, BaseErrorConstant.G_SUCCESS_CODE, BaseErrorConstant.G_SUCCESS_MSG, result);
    }

    /**
     * easy to display
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> displayError(String msg) {
        return new BaseResult<>(false, BaseErrorConstant.G_ERROR_DISPLAY_CODE, msg, null);
    }

    public static <T> BaseResult<T> newError(String code, String msg) {
        return new BaseResult<>(false, code, msg, null);
    }

    public static <T> BaseResult<T> newError(BaseError baseError) {
        return new BaseResult<>(baseError);
    }

    public static <T> BaseResult<T> newError(String code, String msg, T result) {
        return new BaseResult<>(false, code, msg, result);
    }

    public static <T> BaseResult<T> newErrorList() {
        BaseResult<T> objectBaseResult = new BaseResult<>(false, BaseErrorConstant.G_ERROR_LIST, null, null, new ArrayList<>());
        return objectBaseResult;
    }

    public static <T> BaseResult<T> newErrorList(BaseError error) {
        BaseResult<T> objectBaseResult = new BaseResult<>(false, BaseErrorConstant.G_ERROR_LIST, null, null, new ArrayList<>());
        objectBaseResult.errorListAdd(error);
        return objectBaseResult;
    }

    public static <T> BaseResult<T> newErrorList(String code, String msg) {
        BaseResult<T> objectBaseResult = new BaseResult<>(false, BaseErrorConstant.G_ERROR_LIST, null, null, new ArrayList<>());
        objectBaseResult.errorListAdd(new BaseError(code, msg));
        return objectBaseResult;
    }


    public BaseResult<T> errorListAdd(BaseError error) {
        if (this.getErrorList() == null) {
            this.code = BaseErrorConstant.G_ERROR_LIST;
            this.errorList = new ArrayList<>();
        }
        this.getErrorList().add(error);
        return this;
    }

    public BaseResult<T> errorListAdd(String code, String msg) {

        if (this.getErrorList() == null) {
            this.ok = false;
            this.code = BaseErrorConstant.G_ERROR_LIST;
            this.errorList = new ArrayList<>();
        }
        this.getErrorList().add(new BaseError(code, msg));
        return this;
    }

    public BaseResult<T> beError(BaseError baseError) {
        this.setOk(false);
        this.setCode(baseError.getCode());
        this.setMsg(baseError.getMsg());
        return this;
    }

    public BaseResult<T> beError(String code, String msg) {
        this.setOk(false);
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }


    /***************************************/



    /**
     *  easy to read
     */
    public boolean failed() {
        return !getOk();
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HttpResult{");
        sb.append("ok=").append(ok);
        sb.append(", code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append(", newErrorList=").append(errorList);
        sb.append('}');
        return sb.toString();
    }



    /********************* getter and setter *******************/

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
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

    public List<BaseError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<BaseError> errorList) {
        this.errorList = errorList;
    }



    public Boolean getFromCache() {
        return fromCache;
    }

    public void setFromCache(Boolean fromCache) {
        this.fromCache = fromCache;
    }


    public Boolean getUseError() {
        return useError;
    }

    public void setUseError(Boolean useError) {
        this.useError = useError;
    }
}
