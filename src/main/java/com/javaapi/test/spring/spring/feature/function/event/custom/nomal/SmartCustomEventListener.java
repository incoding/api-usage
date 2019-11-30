package com.javaapi.test.spring.spring.feature.function.event.custom.nomal;

import com.javaapi.test.spring.spring.feature.function.event.custom.CustomEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/11/10
 */
@Component
public class SmartCustomEventListener implements SmartApplicationListener {
    /**
     * Determine whether this listener actually supports the given event type.
     *
     * @param eventType
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType.isAssignableFrom(CustomEvent.class);
    }

    /**
     * Determine whether this listener actually supports the given source type.
     *
     * @param sourceType
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("event = " + event);

    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
