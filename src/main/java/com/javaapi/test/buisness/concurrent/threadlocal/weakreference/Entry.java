package com.javaapi.test.buisness.concurrent.threadlocal.weakreference;

import java.lang.ref.WeakReference;

/**
 * Created by user on 2019/12/7
 */
public class Entry extends WeakReference<Person> {
    /**
     * The value associated with this ThreadLocal.
     */
    Object value;

    public Entry(Person person, Object v) {
        super(person);
        value = v;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
