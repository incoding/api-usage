package com.javaapi.test.buisness.pattern.action.chain2.case4;

import com.javaapi.test.buisness.pattern.action.chain2.case3.DirtyFilter;
import com.javaapi.test.buisness.pattern.action.chain2.case3.SensitiveFilter;
import org.junit.Test;

/**
 * refer https://www.jianshu.com/p/8a157cb73434
 * 普通过滤链,只过滤请求,过滤链 加 过滤链
 */
public class Client {
    @Test
    public void test() {
        //要被过滤的内容
        String content = "<scrpit> 粗口1,粗口2,敏感1,敏感2";
        //新建一个『过滤链条』
        FilterChain filterChain = new FilterChain();
        //在过滤链条中添加过滤规则
        filterChain.addFilter(new DirtyFilter());

        //在一个过滤链中加上一个过滤链
        FilterChain filterChain1 = new FilterChain();
        filterChain1.addFilter(new SensitiveFilter())
                    .addFilter(filterChain);
        //过滤后的内容
        String filterContent = filterChain1.doFilter(content);
        //输出内容
        System.out.print(filterContent);
    }
}
