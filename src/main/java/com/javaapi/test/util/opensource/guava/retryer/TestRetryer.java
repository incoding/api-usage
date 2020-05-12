package com.javaapi.test.util.opensource.guava.retryer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2020/4/17
 */
public class TestRetryer {

    private static Logger logger = LoggerFactory.getLogger(TestRetryer.class);

    private static Callable<Boolean> updateReimAgentsCall = () -> {
        String result = "['a','b']";
        if (StringUtils.isEmpty(result)) {
            throw new RemoteException("获取远程响应失败");
        }
        JSONArray jsonArray = JSON.parseArray(result);
        if (CollectionUtils.isNotEmpty(jsonArray)) {
            return true;
        }
        return false;
    };

    private static Callable<Boolean> updateReimAgentsCallException = () -> {
        logger.info("远程调用发起");
        if (true) {
            throw new RuntimeException();
        }
        logger.info("远程调用返回");
        return true;
    };

    private static Callable<Boolean> updateReimAgentsCallResult = () -> {
        logger.info("远程调用发起");

        logger.info("远程调用返回");
        return false;
    };
    //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
//返回false也需要重试
//重调策略
//尝试次数
    private Retryer<Boolean> retryer = RetryerBuilder
            .<Boolean>newBuilder()
            //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
            .retryIfException()
            //返回false也需要重试
            .retryIfResult(Predicates.equalTo(false))
            //重调策略
            .withWaitStrategy(WaitStrategies.fixedWait(3, TimeUnit.SECONDS))
            //尝试次数
            .withStopStrategy(StopStrategies.stopAfterAttempt(3))
            .build();


    @Test
    public void test() {
        try {
            Boolean call = retryer.call(updateReimAgentsCall);
            System.out.println("call = " + call);
        } catch (ExecutionException e) {
//            e.printStackTrace();
        } catch (RetryException e) {
            logger.error("更新可代理报销人异常,需要发送提醒邮件");
        }
    }

    @Test
    public void testException() {
        try {
            Boolean call = retryer.call(updateReimAgentsCallException);
            System.out.println("call = " + call);
        } catch (ExecutionException e) {
//            e.printStackTrace();
        } catch (RetryException e) {
            logger.error("更新可代理报销人异常,需要发送提醒邮件");
        }
    }

    @Test
    public void testResult() {
        try {
            Boolean call = retryer.call(updateReimAgentsCallResult);
            System.out.println("call = " + call);
        } catch (ExecutionException e) {
//            e.printStackTrace();
        } catch (RetryException e) {
            logger.error("更新可代理报销人异常,需要发送提醒邮件");
        }
    }

    @Test
    public void testRetryBuild() {
        RetryerBuilder.newBuilder();
    }

    @Test
    public void testRetryListener() {

    }

    @Test
    public void testBlock() {
//        RetryerBuilder.newBuilder().withBlockStrategy(BlockStrategies.threadSleepStrategy());

    }
}

