package com.javaapi.test.util.math.datastruct.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Map;

public class Test {

    /**
     * 示例：
     * {
     * "a":"1",
     * "b": {
     * "c":"2",
     * "d": {
     * "e": "3"
     * }
     * }
     * }
     * <p>
     * 输出：
     * a = 1
     * b.c=2
     * b.d.e=3
     */
    @org.junit.Test
    public void test() {

        String json = "{\n" +
                "  \"a\":\"1\",\n" +
                "  \"b\": {\n" +
                "     \"c\":\"2\",\n" +
                "     \"d\": {\n" +
                "       \"e\": \"3\"\n" +
                "     }\n" +
                "  }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(json);
        scanJSon(jsonObject, null, 1);
    }


    /**
     * 打印 a
     * 打印 b
     * 打印 c
     * 打印 d
     * 打印e
     *
     * @param jsonObject
     * @param keys
     * @param level
     */
    public void scanJSon(JSONObject jsonObject, List<String> keys, int level) {
        for (Map.Entry<String, Object> stringObjectEntry : jsonObject.entrySet()) {
            String key = stringObjectEntry.getKey();
            Object value = stringObjectEntry.getValue();
            List<String> result = null;
            if (level == 1) {
                result = Lists.newArrayList();
            }
            if (CollectionUtils.isNotEmpty(keys)) {
                result = Lists.newArrayList();
                result.addAll(keys);
            }
            result.add(key);

            if (value instanceof JSONObject) {

                // 中间节点
                scanJSon((JSONObject) value, result, ++level);
            }
            if (value instanceof String) {
                // 最后节点
                System.out.println("value = " + Joiner.on(".").join(result) + "=" + value);
            }
        }

    }
}
