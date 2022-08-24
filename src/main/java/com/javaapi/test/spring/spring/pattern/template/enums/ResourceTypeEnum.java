package com.javaapi.test.spring.spring.pattern.template.enums;

import org.apache.commons.lang3.StringUtils;

public enum ResourceTypeEnum {
    /**
     * 通用渠道
     */
    COMMON("common", "通用渠道");
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
    private ResourceTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 获取枚举类型
     *
     * @param code 枚举码
     * @return BizTypeEnum
     */
    public static ResourceTypeEnum getEnumByCode(String code) {
        for (ResourceTypeEnum e : ResourceTypeEnum.values()) {
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
