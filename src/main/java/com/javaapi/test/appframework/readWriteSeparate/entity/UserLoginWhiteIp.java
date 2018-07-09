package com.javaapi.test.appframework.readWriteSeparate.entity;

import java.util.Objects;

/**
 * Created by user on 17/2/19.
 */
public class UserLoginWhiteIp {

    private Integer id;

    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginWhiteIp that = (UserLoginWhiteIp) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserLoginWhiteIp{");
        sb.append("id=").append(id);
        sb.append(", ip='").append(ip).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
