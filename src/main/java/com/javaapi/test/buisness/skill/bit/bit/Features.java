package com.javaapi.test.buisness.skill.bit.bit;


public class Features {
    public static int feature0 = 1 << 0;
    public static int feature1 = 1 << 1;
    public static int feature2 = 1 << 2;
    public static int feature3 = 1 << 3;
    public static int feature4 = 1 << 4;
    public static int feature5 = 1 << 5;
    public static int feature6 = 1 << 6;
    public static int feature7 = 1 << 7;

    private  int features = 0;

    /**
     * 第一种写法
     *
     * @param feature
     * @return
     */
    public Boolean hasFeature(int feature) {
        return (features & feature) != 0;
    }

    /**
     * 第二种写法
     *
     * @param feature
     * @return
     */
    public Boolean hasFeatureSecond(int feature) {
        return (features & feature) == feature;
    }

    /**
     * 第三种写法
     *
     * @param feature
     * @return
     */
    public Boolean hasFeatureOtherThird(int feature) {
        return (features & feature) == feature;
    }

    public void addFeature(int feature) {
        features |= feature;
    }

    public void removeFeature(int feature) {
        features &= ~feature;
    }

    public int getFeatures() {
        return features;
    }

    public void setFeatures(int features) {
        this.features = features;
    }
}
