package com.javaapi.test.appframework.resilience.resilience4j;
//
//import com.alibaba.fastjson.JSON;
//import com.javaapi.test.buisness.joint.exception.BusinessException;
//import com.javaapi.test.buisness.joint.result.base.BaseResult;
//import io.github.resilience4j.retry.Retry;
//import io.github.resilience4j.retry.RetryConfig;
//import io.github.resilience4j.retry.RetryRegistry;
//import io.vavr.collection.Seq;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.annotation.Resource;
//import javax.xml.ws.WebServiceException;
//import java.time.Duration;
//import java.util.List;
//import java.util.concurrent.TimeoutException;
//import java.util.function.Predicate;
//
///**
// * Created by user on 2019/11/2
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("applicationContext.xml")
//public class ClientRetry {
//
//    @Resource
//    BackendService backendService;
//
//    @Test
//    public void testRetry() {
//        RetryConfig config = getRetryConfig();
//        Retry customRetry = Retry.of("customRetry", config);
//        BaseResult<String> stringBaseResult = customRetry.executeSupplier(backendService::normalReturn);
//        System.out.println("stringBaseResult = " + JSON.toJSONString(stringBaseResult));
//    }
//
//    /**
//     * 如果重试都不成功则原样抛出异常
//     */
//    @Test
//    public void testException() {
//        RetryConfig config = getRetryConfig();
//        Retry customRetry = Retry.of("customRetry", config);
//        BaseResult<String> exceptionResult = customRetry.executeSupplier(backendService::exceptionReturn);
//        System.out.println("exceptionResult = " + JSON.toJSONString(exceptionResult));
//    }
//
//    /**
//     * 如果重试都不成功则原样抛出异常
//     */
//    @Test
//    public void testWrong() {
//        RetryConfig config = getRetryConfig();
//        Retry customRetry = Retry.of("customRetry", config);
//        BaseResult<String> worngResult = customRetry.executeSupplier(backendService::wrongReturn);
//        System.out.println("worngResult = " + worngResult);
//    }
//
//    @Test
//    public void testInvokeRunnable() {
//        RetryConfig config = getRetryConfig();
//        Retry customRetry = Retry.of("customRetry", config);
//        customRetry.executeRunnable(() -> invoke());
//    }
//
//
//    @Test
//    public void testEvent() {
////        可以通过retryregistry 订阅事件获取当前执行数量
//    }
//
//    private RetryConfig getRetryConfig() {
//        Predicate<BaseResult> objectPredicate = response -> !response.getOk();
//        return RetryConfig.<BaseResult>custom()
//                .maxAttempts(3)
//                .waitDuration(Duration.ofMillis(1000))
//                .retryOnResult(objectPredicate)
//                .retryOnException(e -> e instanceof WebServiceException)
//                .retryExceptions(RuntimeException.class, TimeoutException.class)
//                .ignoreExceptions(BusinessException.class, BusinessException.class)
//                // 可以根据重试次数修改下次执行间隔
////                .intervalFunction()
//                .build();
//    }
//
//    /**
//     * RetryRegistry 是用于管理retry
//     */
//    @Test
//    public void test() {
//        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
//        System.out.println("retryRegistry = " + retryRegistry);
//        Seq<Retry> allRetries = retryRegistry.getAllRetries();
//        List<Retry> retries = allRetries.asJavaMutable();
//        System.out.println("retryRegistry = " + retries);
//    }
//
//    public void invoke() {
//        System.out.println("invoke method");
//    }
//
//}
