package com.javaapi.test.buisness.result.extension;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Created by user on 2019/3/4
 */
public class ExtensionResultTest {
    @Test
    public void test() {
        ExtensionResult<String, String> stringExtensionResult = new ExtensionResult<>();
//        stringExtensionResult.setFromCache(true);
        stringExtensionResult.setExtension("this is extensionField");
        System.out.println(JSON.toJSONString(stringExtensionResult));
    }

}