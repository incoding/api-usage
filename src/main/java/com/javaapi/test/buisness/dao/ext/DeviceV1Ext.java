package com.javaapi.test.buisness.dao.ext;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@EqualsAndHashCode
public class DeviceV1Ext implements Serializable {


    private static final long serialVersionUID = 1L;

    public DeviceV1Ext() {
    }

    public DeviceV1Ext(String deviceCode, String settingKey, String settingValue) {
        this.deviceCode = deviceCode;
        this.settingKey = settingKey;
        this.settingValue = settingValue;
    }

    /**
     * 主键id
     */
    private Long id;

    /**
     * 设备编号
     */
    private String deviceCode;

    /**
     * 属性
     */
    private String settingKey;

    /**
     * Value
     */
    private String settingValue;

    /**
     * 创建人id
     */
    private String creatorId;

    /**
     * 修改人id
     */
    private String modifierId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;


}
