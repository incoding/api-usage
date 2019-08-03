package com.javaapi.test.spring.spring.feature.javaconfig.configurationAnnotataion;

import org.springframework.beans.factory.annotation.Autowired;

public class Counter {
    private double multiplier;
    private String song;

    @Autowired
    Piano piano;

    public Counter() {
    }

    public Counter(double multiplier, String song) {
        this.multiplier = multiplier;
        this.song = song;
    }

    public double getMultiplier() {
        System.out.println("piano = " + piano);
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }


    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }


}