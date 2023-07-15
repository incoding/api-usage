package com.javaapi.test.buisness.dao.ext;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Client {

    /**
     * 默认值
     */
    @Test
    public void testGetOrDefaultValue() {
        Client client = new Client();
        List<DeviceV1Ext> fromDb = client.getFromDb();
        DeviceV1ExtBO deviceV1ExtBO = DeviceV1ExtBO.create("111111", fromDb);
        String orDefaultValue = deviceV1ExtBO.getOrDefaultValue(DeviceExtKeyEnum.THIRD_SECOND.getType(), "3");
        System.out.println("orDefaultValue = " + orDefaultValue);
    }

    /**
     * 默认值 通过kv调用
     */
    @Test
    public void testGenericPut() {
        Client client = new Client();
        List<DeviceV1Ext> fromDb = client.getFromDb();
        DeviceV1ExtBO deviceV1ExtBO = DeviceV1ExtBO.create("111111", fromDb);
        deviceV1ExtBO.put(DeviceExtKeyEnum.THIRD_SECOND.getType(), "3");
        deviceV1ExtBO.put(DeviceExtKeyEnum.FIELD_SECOND.getType(), "22");
        deviceV1ExtBO.put(DeviceExtKeyEnum.FIELD_FIRST.getType(), "11");
        System.out.println("deviceV1ExtBO = " + JSON.toJSONString(deviceV1ExtBO, true));
    }

    /**
     * 通过 setter方法调用
     */
    @Test
    public void testSet() {
        Client client = new Client();
        List<DeviceV1Ext> fromDb = client.getFromDb();
        DeviceV1ExtBO deviceV1ExtBO = DeviceV1ExtBO.create("111111", fromDb);
        deviceV1ExtBO.setField1(new DeviceV1Ext("111111", DeviceExtKeyEnum.FIELD_FIRST.getType(), "111"));
        DeviceV1Ext field1 = deviceV1ExtBO.getField1();
        System.out.println("field1 = " + field1);
        DeviceV1Ext deviceV1Ext = deviceV1ExtBO.get(DeviceExtKeyEnum.FIELD_FIRST.getType());
        System.out.println("deviceV1Ext = " + deviceV1Ext);
        System.out.println("deviceV1ExtBO = " + JSON.toJSONString(deviceV1ExtBO, true));
    }


    /**
     * 假设数据库只存在属性1和2
     *
     * @return
     */
    private List<DeviceV1Ext> getFromDb() {
        List<DeviceV1Ext> result = new ArrayList<>();
        result.add(new DeviceV1Ext("111111", DeviceExtKeyEnum.FIELD_FIRST.getType(), "1"));
        result.add(new DeviceV1Ext("111111", DeviceExtKeyEnum.FIELD_SECOND.getType(), "2"));
        return result;
    }
}
