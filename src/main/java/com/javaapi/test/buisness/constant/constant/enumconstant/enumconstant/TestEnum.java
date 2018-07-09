package com.javaapi.test.buisness.constant.constant.enumconstant.enumconstant;

import org.junit.Test;

public class TestEnum {

    @Test
    public void testEnum() {
        System.out.println(EnumGame.CYHX == EnumGame.CYHX);

    }

    @Test
    public void testEnumIndex() {
        System.out.println(EnumGame.CYHX.getIndex());
    }

    @Test
    public void testGetByIndex() {

    }

    @Test
    public void testEnumDescription() {
        System.out.println(EnumGame.CYHX.getDescription());
    }

    @Test
    public void testEnumValues() {
        EnumGame[] values = EnumGame.values();
        for (EnumGame value : values) {
            System.out.println("value = " + value);
        }


        String name = EnumGame.CYHX.name();
        EnumGame game1 = EnumGame.valueOf(name);
        System.out.println("game1 = " + game1);

        EnumGame game2 = EnumGame.valueOf(EnumGame.class, name);
        System.out.println("game2 = " + game2);
    }


}
