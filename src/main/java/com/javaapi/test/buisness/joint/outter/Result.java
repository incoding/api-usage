package com.javaapi.test.buisness.joint.outter;

import lombok.Data;

import java.io.Serializable;
import java.util.AbstractCollection;

/**
 * 基础返回
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码的值
     */
    private String code = ResultStatus.SERVICE_SUCCESS.getCode();
    /**
     * 返回码的描述
     */
    private String msg = ResultStatus.SERVICE_SUCCESS.getMsg();
    /**
     * 返回的数据
     */
    private T data;
    /**
     * 返回的数据条数，非查询返回-1
     */
    private Integer count = -1;
    /**
     * 耗时
     */
    private Long timeCost;

    public static <T> Result<T> success() {
        return restResult(null, ResultStatus.SERVICE_SUCCESS.getCode(), "成功");
    }

    public static <T> Result<T> success(T data) {
        return restResult(data, ResultStatus.SERVICE_SUCCESS.getCode(), "成功");
    }

    public static <T> Result<T> success(T data, String msg) {
        return restResult(data, ResultStatus.SERVICE_SUCCESS.getCode(), "成功");
    }

    public static <T> Result<T> fail() {
        return restResult(null, ResultStatus.ERROR.getCode(), ResultStatus.ERROR.getMsg());
    }

    public static <T> Result<T> fail(String msg) {
        return restResult(null, ResultStatus.ERROR.getCode(), msg);
    }

    public static <T> Result<T> fail(T data) {
        return restResult(data, ResultStatus.ERROR.getCode(), ResultStatus.ERROR.getMsg());
    }

    public static <T> Result<T> fail(ResultStatus status) {
        return restResult(null, status.getCode(), status.getMsg());
    }

    public static <T> Result<T> fail(String code, String msg) {
        return restResult(null, code, msg);
    }


    public static <T> Result<T> restResult(T data, String code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setCount(data instanceof AbstractCollection ? ((AbstractCollection) data).size() : -1);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> success(Long timeCost) {
        return restResult(null, ResultStatus.SERVICE_SUCCESS.getCode(), "成功", timeCost);
    }

    public static <T> Result<T> success(T data, Long timeCost) {
        return restResult(data, ResultStatus.SERVICE_SUCCESS.getCode(), "成功", timeCost);
    }

    public static <T> Result<T> success(T data, String msg, Long timeCost) {
        return restResult(data, ResultStatus.SERVICE_SUCCESS.getCode(), "成功", timeCost);
    }

    public static <T> Result<T> fail(Long timeCost) {
        return restResult(null, ResultStatus.ERROR.getCode(), ResultStatus.ERROR.getMsg(), timeCost);
    }

    public static <T> Result<T> fail(String msg, Long timeCost) {
        return restResult(null, ResultStatus.ERROR.getCode(), msg, timeCost);
    }

    public static <T> Result<T> fail(T data, Long timeCost) {
        return restResult(data, ResultStatus.ERROR.getCode(), ResultStatus.ERROR.getMsg(), timeCost);
    }

    public static <T> Result<T> fail(String code, String msg, Long timeCost) {
        return restResult(null, code, msg, timeCost);
    }

    private static <T> Result<T> restResult(T data, String code, String msg, Long timeCost) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setCount(data instanceof AbstractCollection ? ((AbstractCollection) data).size() : -1);
        result.setMsg(msg);
        result.setTimeCost(timeCost);
        return result;
    }
    public boolean isSuccess() {
        return ResultStatus.SERVICE_SUCCESS.getCode().equals(code);
    }

    public boolean isFailed() {
        return !isSuccess();
    }
}
