package com.javaapi.test.buisness.result.experiment;

import java.io.Serializable;

/**
 * Created by user on 2019/3/2
 */
public class AbstractBaseResult<C> implements Serializable{

    private static final long serialVersionUID = -1;

    private C code;

    public C getCode() {
        return code;
    }

    public void setCode(C code) {
        this.code = code;
    }
}
