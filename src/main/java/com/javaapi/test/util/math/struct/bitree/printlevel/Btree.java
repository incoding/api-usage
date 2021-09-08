package com.javaapi.test.util.math.struct.bitree.printlevel;

public class Btree {

    /**
     * 层级
     */
    private Integer level;

    /**
     * 具体的值
     */
    private Integer value;

    /**
     * 左节点
     */
    private Btree left;

    /**
     * 右节点
     */
    private Btree right;

    public Btree() {
    }

    public Btree(Btree left, Btree right) {
        this.left = left;
        this.right = right;
    }

    public Btree(Integer level, Integer value, Btree left, Btree right) {
        this.level = level;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Btree getLeft() {
        return left;
    }

    public void setLeft(Btree left) {
        this.left = left;
    }

    public Btree getRight() {
        return right;
    }

    public void setRight(Btree right) {
        this.right = right;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
