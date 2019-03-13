package com.javaapi.test.application.rpc.dubbo.facadeImpl.filter;

import com.alibaba.dubbo.rpc.*;

/**
 * refer https://my.oschina.net/u/3039671/blog/833589
 * but not work in main method
 */
@Deprecated
public class DubboContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String var= RpcContext.getContext().getAttachment("key");
        //todo 其他相关处理
        System.out.println("key value={}" + var);
        return invoker.invoke(invocation);
    }
}