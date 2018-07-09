package com.javaapi.test.buisness.constant.constant.classconstant.expirement;


import java.util.List;

/**
 * Created by user on 17/7/4.
 *
 * TODO 如何实现 静态 getAll方法
 * TODO 1 通过继承父类是不行了. 因为父类静态方法,子类是进行隐藏 2 尝试通过类似lombok  3 尝试反射
 *
 * TODO 如何实现静态 getDescriptions 方法
 */
    abstract class BaseConstant<T> implements IndexDesc<T> {

    private int index;

    private String desc;

    private List<T> all;

    public BaseConstant(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }


    abstract List<T> getAll();

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
