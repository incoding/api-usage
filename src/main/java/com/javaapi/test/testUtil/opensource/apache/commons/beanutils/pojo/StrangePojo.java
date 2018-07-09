package com.javaapi.test.testUtil.opensource.apache.commons.beanutils.pojo;

/**
 * Created by user on 18/3/25
 */
public class StrangePojo {
    private String D;
    private String DD;
//    private String d;
//    private String Dd;

//    public String getd() {
//        return d;
//    }
//
//    public void setd(String d) {
//        this.d = d;
//    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

//    public String getDd() {
//        return Dd;
//    }
//
//    public void setDd(String dd) {
//        Dd = dd;
//    }

    public String getDD() {
        return DD;
    }

    public void setDD(String DD) {
        this.DD = DD;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StrangePojo{");
        sb.append("D='").append(D).append('\'');
        sb.append(", DD='").append(DD).append('\'');
//        sb.append(", d='").append(d).append('\'');
//        sb.append(", Dd='").append(Dd).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
