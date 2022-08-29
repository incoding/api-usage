package com.javaapi.test.spring.spring.pattern.templatev2.factory;

/**
 * 方法
 */
public enum GatewayMethodEnum {

    /**
     * 方法枚举
     */
    BUYER_TRANSFER("xxx", "xxx"),

    ;

    /**
     * 枚举编码
     */
    private String code;

    private String desc;

    /**
     * 私有构造函数
     */
    GatewayMethodEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Get enum by code
     *
     * @param code
     * @return
     */
    public static GatewayMethodEnum getEnumByCode(String code) {
        for (GatewayMethodEnum e : GatewayMethodEnum.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
