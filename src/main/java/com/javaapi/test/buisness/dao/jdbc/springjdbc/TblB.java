package com.javaapi.test.buisness.dao.jdbc.springjdbc;

import java.util.Objects;

/**
 * Created by user on 15/8/27.
 */
public class TblB {
    private int id;
    private String val;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblB tblB = (TblB) o;
        return Objects.equals(id, tblB.id) &&
                Objects.equals(val, tblB.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, val);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TblB{");
        sb.append("id=").append(id);
        sb.append(", val='").append(val).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
