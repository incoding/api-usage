package com.javaapi.test.arithmetic.quchong.digui.feibonaqie;

public class Xangjia {
    public static int xiangjia(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return n + xiangjia(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(xiangjia(6));
    }
}