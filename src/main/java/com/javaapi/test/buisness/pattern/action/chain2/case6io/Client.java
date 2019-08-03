package com.javaapi.test.buisness.pattern.action.chain2.case6io;

import com.javaapi.test.buisness.pattern.action.chain2.case6io.filterImp.DirtyFilter;
import com.javaapi.test.buisness.pattern.action.chain2.case6io.filterImp.SensitiveFilter;
import org.junit.Test;

/**
 * refer https://www.jianshu.com/p/8a157cb73434
 * 现response的过滤是跟request过滤的顺序一样
 */
public class Client {
    @Test
    public void test() {
        //要被过滤的内容
        String content = "<scrpit> 敏感1 的词语，敏感1，粗口2的。敏感2词语";
        //请求和应答
        Request request = new Request();
        request.setRequestStr(content);
        Response response = new Response();
        response.setResponseStr(content);
        //新建一个『过滤链条』
        FilterChain filterChain = new FilterChain();
        //在过滤链条中添加过滤规则
        filterChain.addFilter(new DirtyFilter())
                   .addFilter(new SensitiveFilter());

        //过滤后的内容
        filterChain.doFilter(request, response);
        //输出内容
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
