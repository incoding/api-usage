package com.javaapi.test.arithmetic.quchong.quanzhong3lottery;

import com.javaapi.test.arithmetic.quchong.quanzhong2.Weight;

import java.util.Objects;

/**
 * Created by user on 17/1/9.
 */
public class Gift  extends Weight{
    private int id;
    private String name;
    /**
     * 分子
     */
    private int numerator;
    /**
     * 分母
     */
    private int denominator;

    /**
     * 临时属性不持久化
     */
    private int weight;

    public Gift() {
    }

    public Gift(int id, String name, int numerator, int denominator) {
        this.id = id;
        this.name = name;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(id, gift.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Gift{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", numerator=").append(numerator);
        sb.append(", denominator=").append(denominator);
        sb.append('}');
        return sb.toString();
    }
}
