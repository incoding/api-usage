package com.javaapi.test.buisness.dao.ext;

import lombok.Getter;

import java.util.Objects;
import java.util.function.BiConsumer;

@Getter
public enum DeviceExtKeyEnum {
    FIELD_FIRST("fieldFirst", "属性1", DeviceV1ExtBO::setField1),
    FIELD_SECOND("fieldSecond", "属性2", DeviceV1ExtBO::setField2),
    THIRD_SECOND("fieldThird", "属性3", null),
    ;


    private final String type;
    private final String desc;
    private final BiConsumer<DeviceV1ExtBO, DeviceV1Ext> biConsumer;

    DeviceExtKeyEnum(String type, String desc, BiConsumer<DeviceV1ExtBO, DeviceV1Ext> biConsumer) {
        this.type = type;
        this.desc = desc;
        this.biConsumer = biConsumer;
    }

    public static DeviceExtKeyEnum of(String type) {
        for (DeviceExtKeyEnum o : DeviceExtKeyEnum.values()) {
            if (Objects.equals(type, o.getType())) {
                return o;
            }
        }
        return null;
    }
}
