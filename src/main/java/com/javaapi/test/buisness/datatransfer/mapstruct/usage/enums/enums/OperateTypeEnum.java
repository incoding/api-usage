package com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.enums;


public enum OperateTypeEnum {

    CREATE(1, "新建"),
    UPDATE(2, "更改"),
    DELETE(3, "删除"),;

    /**
     * 枚举编码
     */
    private int code;

    /**
     * 枚举描述
     */
    private String text;

    /**
     * 私有构造方法
     *
     * @param code
     * @param text
     */
    OperateTypeEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    /**
     * 获取枚举类型
     *
     * @param code 枚举码
     * @return BizTypeEnum
     */
    public static OperateTypeEnum getEnumByCode(int code) {
        for (OperateTypeEnum e : OperateTypeEnum.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}