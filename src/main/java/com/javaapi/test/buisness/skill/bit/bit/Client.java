package com.javaapi.test.buisness.skill.bit.bit;

import org.junit.Test;

/**
 * Created by user on 18/2/14.
 */
public class Client {

    /**
     * test add,remove,isExist
     */
    @Test
    public void testFeature0(){
        Features features=new Features();
        System.out.println("原始特性==>"+Integer.toBinaryString(features.getFeatures()));
        System.out.println("有特性0么==>"+features.hasFeature(Features.feature0));
        features.removeFeature(Features.feature0);
        System.out.println("移除特性0==>"+Integer.toBinaryString(features.getFeatures()));
        System.out.println("有特性0么==>"+features.hasFeature(Features.feature0));
        features.addFeature(Features.feature0);
        System.out.println("添加特性0==>"+Integer.toBinaryString(features.getFeatures()));
        System.out.println("有特性0么==>"+features.hasFeature(Features.feature0));
        System.out.println("最终==>"+Integer.toBinaryString(features.getFeatures()));
    }



    /**
     * test add,remove,isExist
     */
    @Test
    public void testFeature1(){
        Features features=new Features();
        System.out.println("原始特性==>"+Integer.toBinaryString(features.getFeatures()));
        System.out.println("有特性1么==>"+features.hasFeature(Features.feature1));
        features.removeFeature(Features.feature1);
        System.out.println("移除特性1==>"+Integer.toBinaryString(features.getFeatures()));
        features.addFeature(Features.feature1);
        System.out.println("添加特性1==>"+Integer.toBinaryString(features.getFeatures()));
        System.out.println(features.hasFeature(Features.feature1));
        System.out.println(features.hasFeature(Features.feature2));
        System.out.println("最终==>"+Integer.toBinaryString(features.getFeatures()));
    }

    /**
     * test add,remove,isExist
     */
    @Test
    public void testFeature2(){
        Features features=new Features();
        System.out.println("原始特性==>"+Integer.toBinaryString(features.getFeatures()));
        System.out.println("有特性2么==>"+features.hasFeature(Features.feature2));
        features.removeFeature(Features.feature2);
        System.out.println("移除特性2==>"+Integer.toBinaryString(features.getFeatures()));
        features.addFeature(Features.feature2);
        System.out.println("添加特性2==>"+Integer.toBinaryString(features.getFeatures()));
        System.out.println(features.hasFeature(Features.feature1));
        System.out.println(features.hasFeature(Features.feature2));
        System.out.println("最终==>"+Integer.toBinaryString(features.getFeatures()));
    }

    @Test
    public void testFeature(){
        Features features=new Features();
        System.out.println(Features.feature0+"="+Integer.toBinaryString(Features.feature0));
        System.out.println(Features.feature1+"="+Integer.toBinaryString(Features.feature1));
        System.out.println(Features.feature2+"="+Integer.toBinaryString(Features.feature2));
        System.out.println(Features.feature3+"="+Integer.toBinaryString(Features.feature3));
        System.out.println(Features.feature4+"="+Integer.toBinaryString(Features.feature4));
        System.out.println(Features.feature5+"="+Integer.toBinaryString(Features.feature5));
        System.out.println(Features.feature6+"="+Integer.toBinaryString(Features.feature6));
        System.out.println(Features.feature7+"="+Integer.toBinaryString(Features.feature7));
        System.out.println(Integer.toBinaryString(features.getFeatures()));
    }

    @Test
    public void testFeature3(){
        Features features =new Features();
        features.addFeature(Features.feature6);
        features.addFeature(Features.feature7);
        System.out.println("features = " + features.getFeatures());
    }

}
