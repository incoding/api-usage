package com.javaapi.test.buisness.joint.result.rpc;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.buisness.joint.result.base.BaseError;
import com.javaapi.test.buisness.joint.result.base.ResultModel;
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
        RpcResult<ResultModel> result = methodRemoteServiceReadServerSide();
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




    private RpcResult<ResultModel> methodRemoteServiceReadServerSide() {
        // service code
        String param = "";
        RpcResult<ResultModel> result = RpcResult.ok();
        // mock error
        if (true) {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                result.errorListAdd(BaseError.NEED_LOGIN).setParam(param).setDetailStack(e);
                return result;
            }
        }
        result.setData(new ResultModel());
        return result;

    }

//    private RpcResult<ResultModel> methodRemoteServiceReadServerSide() {
//        // service code
//        String param = "";
//        boolean isError = true;
//        RpcResult<ResultModel> result = RpcResult.<ResultModel>ok();
//        try {
//            throw new RuntimeException();
//        } catch (RuntimeException e) {
//            result.errorListAdd(BaseError.NEED_LOGIN).setParam(param).setDetailStack(e);
//            return inputParam;
//        }
//RpcResult<ResultModel> inputParam = RpcResult.<ResultModel>error(BaseError.NEED_LOGIN).setParam(param).setDetailStack(e);
    //        return resultModelRpcResult;
//
//    }
}