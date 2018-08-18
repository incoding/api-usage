package com.javaapi.test.buisness.data.json.fastjson.SerDeser.serialize.date;

import java.util.Date;

/**
 * -------------------------------------------
 * |   @author      |                |
 * -------------------------------------------
 * |    @date       |18/3/18 上午11:28          |
 * -------------------------------------------
 * |   @version     | V1.0                    |
 * -------------------------------------------
 */
public class StudentForSer {
    private String name;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Video{");
        sb.append("name='").append(name).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
