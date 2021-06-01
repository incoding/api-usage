package com.javaapi.test.spring.spring.pattern.statemachinesquirrel;

/**
 * Created by user on 2021/6/1.
 */
public enum DeviceEvent {
    ASSIGN, //分配 待绑定->运行中
    BEYOND_MAINTENANCE, //超期维保 运行中->维保
    SCRAP, //报废 运行中->待报废
    CHECK_IN, //维保登记 维保->运行中
    UNBIND, //解绑 运行中/待维保/待报废 -> 已解绑
}
