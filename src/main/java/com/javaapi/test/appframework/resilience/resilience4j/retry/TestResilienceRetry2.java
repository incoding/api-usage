package com.javaapi.test.appframework.resilience.resilience4j.retry;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.buisness.exception.bussiness.exception.exception.BusinessException;
import com.javaapi.test.buisness.joint.result.base.BaseResult;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.junit.Test;

import javax.xml.ws.WebServiceException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

public class TestResilienceRetry2 {


    @Test
    public void testRetry() {
        RetryConfig config = getRetryConfig();
        Retry customRetry = Retry.of("customRetry", config);
        BaseResult<String> stringBaseResult = customRetry.executeSupplier(() -> {
            System.out.println("execute normal");
            BaseResult<String> result = new BaseResult<>();
            result.setOk(true);
            return result;
        });
        System.out.println("stringBaseResult = " + JSON.toJSONString(stringBaseResult));
    }

    /**
     * 如果重试都不成功则原样抛出异常
     */
    @Test
    public void testException() {
        RetryConfig config = getRetryConfig();
        Retry customRetry = Retry.of("customRetry", config);
        BaseResult<String> exceptionResult = customRetry.executeSupplier(() -> {
            System.out.println("execute exception");
            if (true) {
                throw new RuntimeException("exception return");
            }
            System.out.println("execute normal");
            BaseResult<String> result = new BaseResult<>();
            result.setOk(true);
            return result;
        });
        System.out.println("exceptionResult = " + JSON.toJSONString(exceptionResult));
    }

    /**
     * 如果重试都不成功则原样抛出异常
     */
    @Test
    public void testWrong() {
        RetryConfig config = getRetryConfig();
        Retry customRetry = Retry.of("customRetry", config);
        BaseResult<String> worngResult = customRetry.executeSupplier(() -> {
            System.out.println("execute wrongReturn");
            BaseResult<String> result = new BaseResult<>();
            result.setOk(false);
            result.setCode("10000");
            return result;
        });
        System.out.println("worngResult = " + worngResult);
    }

    @Test
    public void testInvokeRunnable() {
        RetryConfig config = getRetryConfig();
        Retry customRetry = Retry.of("customRetry", config);
        customRetry.executeRunnable(() -> invoke());
    }


    @Test
    public void testEvent() {
//        可以通过retryregistry 订阅事件获取当前执行数量
    }

    private RetryConfig getRetryConfig() {
        Predicate<BaseResult> objectPredicate = response -> !response.getOk();
        return RetryConfig.<BaseResult>custom()
                          .maxAttempts(3)
                          .waitDuration(Duration.ofMillis(1000))
                          .retryOnResult(objectPredicate)
                          .retryOnException(e -> e instanceof WebServiceException)
                          .retryExceptions(RuntimeException.class, TimeoutException.class)
                          .ignoreExceptions(BusinessException.class, BusinessException.class)
                          // 可以根据重试次数修改下次执行间隔
//                .intervalFunction()
                          .build();
    }

    /**
     * RetryRegistry 是用于管理retry
     */
    @Test
    public void test() {
        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
        System.out.println("retryRegistry = " + retryRegistry);
        Set<Retry> allRetries = retryRegistry.getAllRetries();
        System.out.println("retryRegistry = " + allRetries);
    }

    public void invoke() {
        System.out.println("invoke method");
    }
}
