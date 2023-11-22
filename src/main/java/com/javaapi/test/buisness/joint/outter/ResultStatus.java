package com.javaapi.test.buisness.joint.outter;

import java.util.HashSet;

/**
 */
public enum ResultStatus {
    SERVICE_SUCCESS("200", "成功"),
    ERROR("500", "服务器异常"),
    /**参数部分****/
    PARAM_ERROR("093000", "参数错误"),
    /**数据库部分****/
    SERVER_ERROR("094000", "服务器错误"),
    DATA_EXCEPTION("094010","数据库异常"),
    MIDDLEWARE_ERROR("094100", "中间件错误"),
    /**系统部分****/
    NETWORK_ERROR("095000", "网络异常"),
    UNKNOWN_ERROR("095100", "未知错误"),
    SERVICE_ERROR("095200", "接口调用错误"),
    PARTITION_ERROR("095300", "部分操作错误"),
    PENDING("095400", "请求处理中，请稍后"),

    /**业务部分****/
    @Deprecated
    DEVICE_NOT_EXIST("095401", "设备不存在"),
    @Deprecated
    DEVICE_NOT_DOOR("095402", "设备无法开门，或有人使用"),
    @Deprecated
    CABINET_NOT_EXIST("095403", "货柜不存在"),
    ;

    private final String code;
    private final String msg;

    private ResultStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    public String getMsg4Log() {
        return "ERROR_CODE:" + code + "\t" + msg + "\t";
    }

    private static HashSet<String> hashSet;

    static {
        hashSet = new HashSet<String>();
        hashSet.clear();
        for (ResultStatus returnStatus : ResultStatus.values()) {
            hashSet.add(returnStatus.getCode());
        }
    }

    public static boolean isDefined(String code) {
        if (hashSet.contains(code)) {
            return true;
        }
        return false;
    }

    public static ResultStatus get(String code) {
        for (ResultStatus o : ResultStatus.values()) {
            if (code.equals(o.getCode())) {
                return o;
            }
        }
        return null;
    }
}
