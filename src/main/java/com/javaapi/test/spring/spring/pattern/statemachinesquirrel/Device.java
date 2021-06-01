package com.javaapi.test.spring.spring.pattern.statemachinesquirrel;

/**
 * Created by user on 2021/6/1.
 */
public class Device {

    private static final long serialVersionUID = -7530788254197248277L;
    private Long id;

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

    public String getSeriesNo() {
        return seriesNo;
    }

    public void setSeriesNo(String seriesNo) {
        this.seriesNo = seriesNo;
    }

    public String getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(String districtNo) {
        this.districtNo = districtNo;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public DeviceStatusEnum getStatus() {
        return status;
    }

    public void setStatus(DeviceStatusEnum status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
