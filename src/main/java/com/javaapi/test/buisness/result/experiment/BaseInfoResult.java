package com.javaapi.test.buisness.result.experiment;

/**
 * Created by user on 2019/3/2
 */
public class BaseInfoResult<D,P> extends BaseIntegerResult<D> {

    private BaseInfo<P> baseInfo;

    public BaseInfo<P> getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo<P> baseInfo) {
        this.baseInfo = baseInfo;
    }
}
