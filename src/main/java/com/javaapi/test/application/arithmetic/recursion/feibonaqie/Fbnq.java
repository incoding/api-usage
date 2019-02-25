package com.javaapi.test.application.arithmetic.recursion.feibonaqie;

import java.util.ArrayList;
import java.util.List;

/**
 * 斐波那契数列用递归怎么写？1，1，2，3，5，8，13，21.。。。。。
 * 
 * @author kk
 * 
 */
public class Fbnq {
	List<Integer> list =new ArrayList<>();
	
    public static int fbnq(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fbnq(n - 1) + fbnq(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fbnq(6));
    }
}