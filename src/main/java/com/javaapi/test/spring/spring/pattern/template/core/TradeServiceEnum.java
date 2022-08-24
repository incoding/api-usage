
package com.javaapi.test.spring.spring.pattern.template.core;

import org.apache.commons.lang3.StringUtils;

/**
 * 交易服务枚举
 */
public enum TradeServiceEnum {
    /**
     * 验证
     */
    VALIDATE("validate", "验证"),


    ;

    /**
     * 枚举编码
     */
    private String code;

    /**
     * 枚举中文名称
     */
    private String name;

    /**
     * 构造函数
     */
    private TradeServiceEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 获取枚举类型
     *
     * @param code 枚举码
     * @return BizTypeEnum
     */
    public static TradeServiceEnum getEnumByCode(String code) {
        for (TradeServiceEnum e : TradeServiceEnum.values()) {
            if (StringUtils.equals(e.getCode(), code)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

}
