package com.javaapi.test.buisness.dataTrans.json.fastjson.pojo.enumPkg;

import java.io.Serializable;

/**
 * Created by user on 17/6/16.
 */
public class RefundCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    private CheckInStatus checkInStatus;

    public CheckInStatus getCheckInStatus() {
        return checkInStatus;
    }

    public void setCheckInStatus(CheckInStatus checkInStatus) {
        this.checkInStatus = checkInStatus;
    }

    @Override
    public String toString() {
        return "RefundCondition{" +
                "checkInStatus=" + checkInStatus +
                '}';
    }
}
