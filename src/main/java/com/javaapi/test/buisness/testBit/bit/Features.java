package com.javaapi.test.buisness.testBit.bit;


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
     * 一种形式
     *
     * @param feature
     * @return
     */
    public Boolean hasFeature(int feature) {
        return (features & feature) != 0;
    }

    /**
     * 另一种形式
     *
     * @param feature
     * @return
     */
    public Boolean hasFeatureOther(int feature) {
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
