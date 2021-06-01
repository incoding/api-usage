package com.javaapi.test.spring.spring.pattern.statemachinesquirrel;

/**
 * Created by user on 2021/6/1.
 */
public class DeviceContext {
    public DeviceContext() {
    }

    public DeviceContext(Device dto) {
        this.model = dto;
    }

    private Device model;

    public Device getModel() {
        return model;
    }

    public void setModel(Device model) {
        this.model = model;
    }
}
