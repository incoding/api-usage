package com.javaapi.test.spring.spring.pattern.statemachinesquirrel;

/**
 * Created by user on 2021/6/1.
 */
public enum DeviceStatusEnum {

    /**
     * 待绑定
     */
    INITIALIZE("待绑定"),

    /**
     * 运行中
     */
    RUNNING("运行中"),

    /**
     * 待维保
     */
    TO_BE_MAINTAINED("待维保"),

    /**
     * 待报废
     */
    TO_BE_SCRAPPED("待报废"),

    /**
     * 已解绑
     */
    UNBOUND("已解绑");

    private String desc;

    private DeviceStatusEnum(final String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
}
