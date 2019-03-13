package com.javaapi.test.buisness.joint.result.extension;

import com.javaapi.test.buisness.joint.result.base.BaseResult;

/**
 * Created by user on 2019/3/2
 */
public class ExtensionResult<T, E> extends BaseResult<T> {

    private E extension;

    public E getExtension() {
        return extension;
    }

    public void setExtension(E extension) {
        this.extension = extension;
    }
}
