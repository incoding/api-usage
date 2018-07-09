package com.javaapi.test.buisness.dataTrans.json.fastjson.SerDeser.serialize.pojoToKey.pojo;

import com.javaapi.test.buisness.constant.constant.classconstant.ConstantGame;

/**
 * Created by user on 18/4/4
 */
public class Student {
    private String name;
    private ConstantGame game;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConstantGame getGame() {
        return game;
    }

    public void setGame(ConstantGame game) {
        this.game = game;
    }
}
