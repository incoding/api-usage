package com.javaapi.test.pattern.action.chain2.case3;

import org.junit.Test;

/**
 * refer https://www.jianshu.com/p/8a157cb73434
 * 普通过滤链,只过滤请求
 */
public class Client {
    @Test
    public void test() {
        //要被过滤的内容
        String content = "<scrpit> 粗口1,粗口2,敏感1,敏感2";
        //新建一个『过滤链条』
        FilterChain filterChain = new FilterChain();
        //在过滤链条中添加过滤规则
        filterChain.addFilter(new DirtyFilter())
                   .addFilter(new SensitiveFilter());
        //过滤后的内容
        String filterContent = filterChain.doChainFilter(content);
        //输出内容
        System.out.print(filterContent);

    }
}
