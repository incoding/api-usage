package com.javaapi.test.buisness.joint.result.rpc;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.buisness.joint.result.base.BaseError;
import com.javaapi.test.buisness.joint.result.base.ResultModel;
import com.javaapi.test.buisness.joint.result.base.ResultModelRequest;
import org.junit.Test;

/**
 * Created by user on 2019/3/13
 */

public class RpcResultTest {


    @Test
    public void testCorrect() throws Exception {
        RpcResult<ResultModel> result = methodRemoteServiceCorrect();
        System.out.println("result = " + JSON.toJSONString(result));
    }

    @Test
    public void testException() throws Exception {
        RpcResult<ResultModel> result = methodRemoteServiceException();
        System.out.println("result = " + JSON.toJSONString(result));
    }

    @Test
    public void testExceptionReadServerSide() throws Exception {
        RpcResult<ResultModel> result = methodRemoteServiceReadServerSideException();
        System.out.println("result = " + JSON.toJSONString(result));
    }

    @Test
    public void testErrorReadServerSide() throws Exception {
        RpcResult<ResultModel> result = methodRemoteServiceReadServerSideError();
        System.out.println("result = " + JSON.toJSONString(result));
    }

    private RpcResult<ResultModel> methodRemoteServiceCorrect() {
        // service code

        ResultModel data = new ResultModel();
        data.setId(1);
        data.setName("name");
        RpcResult<ResultModel> ok = RpcResult.ok(data);
        return ok;
    }

    private RpcResult<ResultModel> methodRemoteServiceException() {
        // service code
        return RpcResult.newError(BaseError.NEED_LOGIN);
    }


    private RpcResult<ResultModel> methodRemoteServiceReadServerSideException() {
        // service code
        ResultModelRequest resultModelRequest = new ResultModelRequest();
        resultModelRequest.setName("param request");
        String param = JSON.toJSONString(resultModelRequest);
        RpcResult<ResultModel> result = RpcResult.ok();
        // mock newError
        if (true) {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                result.beError(BaseError.NEED_LOGIN).setParam(param).setDetailStack(e).readServerSide();
                return result;
            }
        }
        result.setData(new ResultModel());
        return result;

    }

    private RpcResult<ResultModel> methodRemoteServiceReadServerSideError() {
        // service code
        ResultModelRequest resultModelRequest = new ResultModelRequest();
        resultModelRequest.setName("param request");
        String param = JSON.toJSONString(resultModelRequest);
        RpcResult<ResultModel> resultModelRpcResult = RpcResult.<ResultModel>newError(BaseError.NEED_LOGIN).setParam(param).readServerSide();
        return resultModelRpcResult;

    }
}