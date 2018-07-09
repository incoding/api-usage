package com.javaapi.test.buisness.constant.constant.classconstant;

import com.alibaba.fastjson.annotation.JSONType;
import com.javaapi.test.buisness.constant.constant.classconstant.jsonSerialize.ConstantGameDeserializer;
import com.javaapi.test.buisness.constant.constant.classconstant.jsonSerialize.ConstantGameSerializer;
import com.javaapi.test.test.testReflect.serializable.ser1.CustomTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kk
 * @project apiTest
 * @date 2014年8月4日
 * @see CustomTest
 */
@JSONType(serializer = ConstantGameSerializer.class ,deserializer = ConstantGameDeserializer.class)
public class ConstantGame implements Serializable, IndexDesc {
    private static final long serialVersionUID = 1L;
    /**
     * 要在实例前定义
     * http://blog.csdn.net/fykhlp/article/details/6236316
     */
    private transient static final List<ConstantGame> all = new ArrayList<>();
    private transient static final Map<Integer, ConstantGame> indexMap = new HashMap<>();
    private transient static final Map<String, ConstantGame> descMap = new HashMap<>();

    public static final ConstantGame SJ = new ConstantGame(1, "射击游戏", null);
    public static final ConstantGame CYHX = new ConstantGame(2, "穿越火线", SJ);
    public static final ConstantGame NZ = new ConstantGame(3, "逆战", SJ);

    public static final ConstantGame SMZH = new ConstantGame(4, "使命召唤", SJ);

    private int index;

    private String description;


    private transient ConstantGame parent;

    private ConstantGame(Integer index, String description, ConstantGame parent) {
        this.index = index;
        this.description = description;
        this.parent = parent;
        all.add(this);
        indexMap.put(index, this);
        descMap.put(description, this);
    }

    public static List<ConstantGame> getAll(){
        return all;
    }

    /**
     * 如果未找到index对应的常量 ,返回null,而不会像枚举一样,报错
     * @param index
     * @return
     */
    public static ConstantGame getByIndex(int index){
        return indexMap.get(index);
    }

    /**
     * 找到desc对应的常量
     * @param desc
     * @return
     */
    public static ConstantGame getByDesc(String desc){
        return descMap.get(desc);
    }


    @Override
    public Integer getIndex() {
        return index;
    }


    @Override
    public String getDesc() {
        return description;
    }


    public ConstantGame getParent() {
        return parent;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + index;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConstantGame other = (ConstantGame) obj;
        if (index != other.index)
            return false;
        return true;
    }


    private Object readResolve() {
        if (this.getIndex().intValue() == ConstantGame.SJ.getIndex().intValue()) {
            return ConstantGame.SJ;
        }
        if (this.getIndex().intValue() == ConstantGame.CYHX.getIndex().intValue()) {
            return ConstantGame.CYHX;
        }
        if (this.getIndex().intValue() == ConstantGame.NZ.getIndex().intValue()) {
            return ConstantGame.NZ;
        }
        if (this.getIndex().intValue() == ConstantGame.SMZH.getIndex().intValue()) {
            return ConstantGame.SMZH;
        }
        return null;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConstantGame{");
        sb.append("index=").append(index);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
