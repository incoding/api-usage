package com.javaapi.test.buisness.httpresult;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class AppResultViewResovler implements HandlerMethodReturnValueHandler {
    public AppResultViewResovler() {
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        Class type = returnType.getParameterType();
        return HttpResult.class.equals(type);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        final HttpResult result = (HttpResult)returnValue;
        mavContainer.setView(new View() {
            @Override
            public String getContentType() {
                return null;
            }
            @Override
            public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
                JSON.toJSONString(result);
            }
        });
    }
}