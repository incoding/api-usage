package com.javaapi.test.spring.spring.pattern.event.custom;

import org.springframework.context.ApplicationEvent;

/**
 * 子定义事件
 */
public class CustomEvent extends ApplicationEvent {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomEvent(Object source) {
        super(source);
    }

    public CustomEvent(Object source, String data) {
        super(source);
        this.data = data;
    }
}
