package com.javaapi.test.util.math.datastruct.stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Client {

    @Test
    public void test() {
        boolean valid = new Client().isValid("(()()((())))");
        System.out.println("valid = " + valid);
    }


    @Test
    public void test2() {
        boolean valid = new Client().isValid("(())())(()");
        System.out.println("valid = " + valid);
    }


    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

}
