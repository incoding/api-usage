package com.javaapi.test.test.testReflect.serializable.ser2;

public class AbstractSerializeDemo {
    private int x, y;

    public void init(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void printXY() {
        System.out.println("x:" + x + ";y:" + y);
    }
}