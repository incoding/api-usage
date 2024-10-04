package com.javaapi.test.application.spel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MyType {
    W(1, "F"),
    X(2, "X");

    public static Integer getByName(String name) {
        for (MyType value : MyType.values()) {
            if (value.getName().equals(name)) {
                return value.getCode();
            }
        }
        return null;
    }

    private final Integer code;
    private final String name;

}
