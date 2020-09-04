package com.javaapi.test.spring.custom.controllerlog.annotation;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 实际用Around 就是最好的,配置简单,而且 像 before,after,afterreturning,afterthrowing,都可以实现
 * 这里只能扫描一种注解
 * 这里打日志应该是只有处理ajax情况才需要,响应页面是不需要打日志的
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(value = "execution(* *(..)) && @annotation(webLog)", argNames = "pjp,webLog")
    public Object doAround(final ProceedingJoinPoint pjp, WebLog webLog) throws Throwable {
        Object result = null;
        before(pjp, webLog);
        boolean success = true;
        Throwable ex = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            success = false;
            ex = throwable;
        }
        after(pjp, webLog);
        if (success) {
            afterReturn(pjp, webLog, result);
        } else {
            afterThrow(pjp, webLog, ex, result);
        }
        return result;
    }

    private boolean ajax(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        boolean annotationPresent = signature.getMethod().isAnnotationPresent(ResponseBody.class) || signature.getMethod().isAnnotationPresent(RestController.class);
        Class<?> declaringClass = signature.getMethod().getDeclaringClass();
        boolean classAnnotation = declaringClass.isAnnotationPresent(ResponseBody.class) || declaringClass.isAnnotationPresent(RestController.class);
        return annotationPresent || classAnnotation;
    }

    private void afterReturn(ProceedingJoinPoint pjp, WebLog webLog, Object result) {
        if (!webLog.printResp()) {
        }
        boolean isAjax = ajax(pjp);
        if (isAjax) {
            logger.info("返回参数 response={}", JSON.toJSONString(result));
        }
    }


    private void before(ProceedingJoinPoint pjp, WebLog webLog) {
        if (!webLog.printReq()) {
            return;
        }
        String url = "";
        String method = "";
        String uri = "";
        String queryString = "";
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

        if (ra != null) {
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();

            // 获取请求相关信息
            StringBuffer requestURL = request.getRequestURL();

            url = requestURL.toString();

            method = request.getMethod();

            uri = request.getRequestURI();

            queryString = request.getQueryString();
        }


        Object[] args = pjp.getArgs();
        logger.info("请求参数 url={},method={},uri={},queryString={},requestParam={}", url, method, uri, queryString, JSON.toJSONString(args));
    }


    private void after(ProceedingJoinPoint pjp, WebLog webLog) {

    }

    private void afterThrow(ProceedingJoinPoint pjp, WebLog webLog, Throwable throwable, Object result) {
        logger.info("返回参数,发生异常,异常信息={}", JSON.toJSONString(throwable.getCause()));
    }
}
