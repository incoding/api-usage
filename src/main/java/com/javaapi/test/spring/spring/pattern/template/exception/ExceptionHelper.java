package com.javaapi.test.spring.spring.pattern.template.exception;

import java.lang.reflect.InvocationTargetException;

public class ExceptionHelper {
    private ExceptionHelper() {
    }

    public static <T extends Throwable> T unwrap(T t) {
        return t instanceof InvocationTargetException ? (T) ((InvocationTargetException) t).getTargetException() : t;
    }
}
