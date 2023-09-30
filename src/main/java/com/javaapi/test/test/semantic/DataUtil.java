package com.javaapi.test.test.semantic;

public class DataUtil {
    public static Double add(String one, String two) {
        return Double.parseDouble(one) + Double.parseDouble(two);

    }

    public static Double subtract(String one, String two) {
        return Double.parseDouble(one) - Double.parseDouble(two);
    }

    public static Double multiply(String one, String two) {
        return Double.parseDouble(one) * Double.parseDouble(two);
    }

    public static Double divide(String one, String two) {
        return Double.parseDouble(one) / Double.parseDouble(two);
    }
}
