package com.javaapi.test.pattern.action.chain2.case6io.filterImp;

import com.javaapi.test.pattern.action.chain2.case6io.Filter;
import com.javaapi.test.pattern.action.chain2.case6io.Request;
import com.javaapi.test.pattern.action.chain2.case6io.Response;

/**
 * Created by user on 2019/1/18
 */
public class DirtyFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response) {
        String requestFilterStr = request.getRequestStr()
                                         .replace("粗口1", "xx")
                                         .replace("粗口2", "xx");
        request.setRequestStr(requestFilterStr);

        String responseFilterStr = response.getResponseStr()
                                           .replace("粗口1", "++")
                                           .replace("粗口2", "++");
        response.setResponseStr(responseFilterStr + "|DirtyFilter");
    }

}