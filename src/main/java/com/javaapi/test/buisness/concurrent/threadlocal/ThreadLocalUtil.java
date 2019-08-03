package com.javaapi.test.buisness.concurrent.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil {
    private static ThreadLocal<Map<String, Object>> local = new ThreadLocal<Map<String, Object>>();
    static {
        local.set(new HashMap<String, Object>());
    }
    public static Map<String, Object> getLocal() {
        if (local.get() == null) {
            HashMap<String, Object> map = new HashMap<>();
            local.set(map);
        }
        return local.get();
    }

    public static void setLocal(HashMap<String, Object> map) {
        local.set(map);
    }

    public static <T> void set(String key, T value) {
        if (local.get() == null) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            local.set(map);
        }
        local.get().put(key, (T) value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        if (local.get() == null) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            local.set(map);
        }
        return (T) local.get().get(key);
    }
    public static void remove(){
        local.remove();
    }

}
