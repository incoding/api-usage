package com.javaapi.test.buisness.constant.constant.enumconstant.enumSerDeser;

public enum State {

//    COMMON(1);
    UNKNOW(2);
    private int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}