package com.javaapi.test.util.io;

import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class TestCharSet {
    @Test
    public void charset() {
        String charset = StandardCharsets.UTF_8.displayName();
        System.out.println(charset);
    }
}
