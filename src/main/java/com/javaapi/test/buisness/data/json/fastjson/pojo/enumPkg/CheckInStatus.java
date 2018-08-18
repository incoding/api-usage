package com.javaapi.test.buisness.data.json.fastjson.pojo.enumPkg;

/**
 * Created by user on 17/6/16.
 */
public enum CheckInStatus {
    UnCheck(0, "未值机"),//未值机

    CheckIn(6, "已值机"),//已值机
    CheckIning(7, "值机中"),//值机中
    Fail(8, "值机失败");//值机失败


    private int code;
    private String name;

    CheckInStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CheckInStatus parse(int code) {
        for (CheckInStatus cert : values()) {
            if (cert.getCode() == code) {
                return cert;
            }
        }
        return null;
    }
}
