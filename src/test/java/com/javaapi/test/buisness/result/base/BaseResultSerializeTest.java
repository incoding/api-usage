package com.javaapi.test.buisness.result.base;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by user on 2019/3/5
 */
public class BaseResultSerializeTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * test baseresult serialize one model
     * @throws Exception
     */
    @Test
    public void testOne() throws Exception {
        ResultModel result = new ResultModel("hello world");
        BaseResult<ResultModel> ok = BaseResult.ok(result);
        String s = JSON.toJSONString(ok);
        logger.info(s);
    }

    /**
     * test baseresult serialize model list
     * @throws Exception
     */
    @Test
    public void testSerializeList() throws Exception {
        ResultModel result = new ResultModel("hello world");
        BaseResult<List<ResultModel>> ok = BaseResult.ok(Lists.newArrayList(result));
        String s = JSON.toJSONString(ok);
        logger.info(s);
    }

}
