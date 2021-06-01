package com.javaapi.test.spring.spring.pattern.statemachinesquirrel;

/**
 * Created by user on 2021/6/1.
 */
public class DeviceDTO {

    /**
     * 所属系列no集合（冗余、查询用、从根系列no一直到当前系列no：rootNo/.../currentSeriesNo）
     */


    private String seriesNo;

    /**
     * 所属地区no集合（冗余、查询用、从根地区no一直到当前地区no：rootNo/.../currentDistrictNo）
     */


    private String districtNo;

    /**
     * 设备序列号
     */


    private String sn;

    /**
     * 设备名称
     */


    private String name;

    /**
     * 许可号
     */


    private String licenseNo;

    /**
     * 设备状态
     */


    private DeviceStatusEnum status;
}
