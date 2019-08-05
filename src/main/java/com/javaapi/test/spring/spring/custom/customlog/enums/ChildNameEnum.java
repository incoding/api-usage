package com.javaapi.test.spring.spring.custom.customlog.enums;

public enum ChildNameEnum {

    DEFAULT(ServiceNameEnum.COMMON.name(), "DEFAULT", "默认处理"),

    BOOK_PRE(ServiceNameEnum.BOOK.name(), "BOOK", "下单");

    private String serviceName;
    private String childName;
    private String desc;

    ChildNameEnum(String serviceName, String childName, String desc) {
        this.serviceName = serviceName;
        this.childName = childName;
        this.desc = desc;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getChildName() {
        return childName;
    }

    public String getDesc() {
        return desc;
    }
}
