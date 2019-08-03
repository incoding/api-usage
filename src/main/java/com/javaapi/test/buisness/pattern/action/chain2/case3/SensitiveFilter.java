package com.javaapi.test.buisness.pattern.action.chain2.case3;

/**
 * Created by user on 2019/1/14
 */
public class SensitiveFilter implements Filter {
    @Override
    public String doFilter(String content) {
        return content
                .replace("敏感1", "xx1")
                .replace("敏感2", "xx2");
    }
}