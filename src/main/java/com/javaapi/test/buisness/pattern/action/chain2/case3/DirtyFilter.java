package com.javaapi.test.buisness.pattern.action.chain2.case3;

/**
 * refer https://www.jianshu.com/p/8a157cb73434
 */
public class DirtyFilter implements Filter {
    @Override
    public String doFilter(String content) {
        return content.replace("粗口1", "xx1")
                      .replace("粗口2", "xx2");
    }
}