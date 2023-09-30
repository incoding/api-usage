package com.javaapi.test.test.semantic;

import com.google.common.collect.Sets;


import java.util.Set;

public class CalcType {
//    Add('+'),
//    Subtract('-'),
//    Multiply('*'),
//    Divide('/'),;
//    private Character symbol;
//
//    CalcType(Character symbol) {
//        this.symbol = symbol;
//    }
//
//    public Character getSymbol() {
//        return symbol;
//    }
//
//    public void setSymbol(Character symbol) {
//        this.symbol = symbol;
//    }
//    public static Set<Character> allSymbol = Sets.newHashSet(Add.getSymbol(),Subtract.getSymbol(),Multiply.getSymbol(),Divide.getSymbol());

    public static final char Add =  '+';
    public static final char Subtract = '-';
    public static final char Multiply = '*';
    public static final char Divide = '/';
    public static Set<Character> allSymbol = Sets.newHashSet(Add,Subtract,Multiply,Divide);
}
