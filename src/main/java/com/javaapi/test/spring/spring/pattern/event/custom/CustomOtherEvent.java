
package com.javaapi.test.spring.spring.pattern.event.custom;

import org.springframework.context.ApplicationEvent;

/**
 * 子定义事件
 */
public class CustomOtherEvent extends ApplicationEvent {

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
    public CustomOtherEvent(Object source) {
        super(source);
    }

    public CustomOtherEvent(Object source, String data) {
        super(source);
        this.data = data;
    }
}
