package com.javaapi.test.buisness.result.abs;

/**
 * Created by user on 2019/3/2
 */
public class BaseIntegerResult<D> extends AbstractBaseResult<Integer> {

    private D data;

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
