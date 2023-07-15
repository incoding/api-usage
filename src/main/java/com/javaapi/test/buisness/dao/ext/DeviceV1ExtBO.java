package com.javaapi.test.buisness.dao.ext;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class DeviceV1ExtBO {
    private String deviceCode;
    private Map<String, DeviceV1Ext> extMap = new HashMap<>();
    private DeviceV1Ext field1;
    private DeviceV1Ext field2;


    public void setField1(DeviceV1Ext field1) {
        this.field1 = field1;
        this.extMap.put(field1.getSettingKey(), field1);
    }

    /**
     * 外部调用请使用静态类初始化
     */
    private DeviceV1ExtBO() {
    }


    public static Map<String, DeviceV1ExtBO> groupByDeviceCodes(Collection<DeviceV1Ext> exts) {
        if (exts == null || exts.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, List<DeviceV1Ext>> collect = exts.stream().collect(Collectors.groupingBy(DeviceV1Ext::getDeviceCode, Collectors.toList()));
        Map<String, DeviceV1ExtBO> result = Maps.newHashMap();
        for (String deviceCode : collect.keySet()) {
            List<DeviceV1Ext> deviceV1Exts = collect.get(deviceCode);
            result.put(deviceCode, DeviceV1ExtBO.create(deviceCode, deviceV1Exts));
        }
        return result;
    }

    public DeviceV1Ext get(String key) {
        return extMap.get(key);
    }

    public DeviceV1Ext getOrDefault(String key, DeviceV1Ext defaultExt) {
        return extMap.getOrDefault(key, defaultExt);
    }

    public DeviceV1Ext getOrDefaultExt(String key, String value) {
        return extMap.getOrDefault(key, new DeviceV1Ext(this.getDeviceCode(), key, value));
    }

    public String getOrDefaultValue(String key, String value) {
        if (extMap.containsKey(key)) {
            return extMap.get(key).getSettingValue();
        } else {
            return value;
        }
    }


    /**
     * 保证给的默认值,下次get能取出来
     *
     * @param key
     * @return
     */
    public boolean put(String key, String value) {
        DeviceExtKeyEnum extKeyEnum = DeviceExtKeyEnum.of(key);
        if (extKeyEnum == null) {
            return false;
        }
        DeviceV1Ext valueObj = new DeviceV1Ext(deviceCode, key, value);
        extMap.put(key, valueObj);
        BiConsumer<DeviceV1ExtBO, DeviceV1Ext> biConsumer = extKeyEnum.getBiConsumer();
        if (biConsumer != null) {
            biConsumer.accept(this, valueObj);
        }
        return true;
    }


    /**
     * 保证给的默认值,下次get能取出来
     *
     * @param key
     * @param defaultExt
     * @return
     */
    public DeviceV1Ext setIfAbsent(String key, DeviceV1Ext defaultExt) {
        if (extMap.containsKey(key)) {
            return extMap.get(key);
        } else {
            extMap.put(key, defaultExt);
            return defaultExt;
        }
    }


    public static DeviceV1ExtBO create(String deviceCode, List<DeviceV1Ext> exts) {
        DeviceV1ExtBO deviceV1ExtBO = new DeviceV1ExtBO();
        deviceV1ExtBO.setDeviceCode(deviceCode);
        Map<String, DeviceV1Ext> extMap = Optional.ofNullable(exts).orElse(Lists.newArrayList()).stream().collect(Collectors.toMap(DeviceV1Ext::getSettingKey, Function.identity(), (existing, replacement) -> existing));
        deviceV1ExtBO.setExtMap(extMap);
        return deviceV1ExtBO;
    }

}
