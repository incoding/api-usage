package com.javaapi.test.spring.spring.pattern.template.enums;

public enum OrderSourceEnum {

    /**
     * 不指定
     */
    COMMON(0, "不指定");


    /**
     * 枚举编码
     */
    private int code;
    /**
     * 枚举中文名称
     */
    private String name;

    /**
     * 构造函数
     */
    private OrderSourceEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 获取枚举类型
     *
     * @param code 枚举码
     * @return BizTypeEnum
     */
    public static OrderSourceEnum getEnumByCode(int code) {
        for (OrderSourceEnum e : OrderSourceEnum.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    public static OrderSourceEnum getEnumByName(String pName) {
        for (OrderSourceEnum e : OrderSourceEnum.values()) {
            if (e.name.equals(pName)) {
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
    public int getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getName() {
        return name;
    }

}
