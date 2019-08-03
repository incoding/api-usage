package com.javaapi.test.buisness.pattern.action.chain2.case6io.filterImp;

import com.javaapi.test.buisness.pattern.action.chain2.case6io.Filter;
import com.javaapi.test.buisness.pattern.action.chain2.case6io.Request;
import com.javaapi.test.buisness.pattern.action.chain2.case6io.Response;

/**
 * Created by user on 2019/1/18
 */
public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response) {
        String requestFilterStr = request.getRequestStr()
                                         .replace("敏感1", "flg")
                                         .replace("敏感2", "zf");
        request.setRequestStr(requestFilterStr);

        String responseFilterStr = response.getResponseStr()
                                           .replace("敏感1", "---")
                                           .replace("敏感2", "--");
        response.setResponseStr(responseFilterStr + "|SensitiveFilter");
    }
}