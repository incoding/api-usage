package com.javaapi.test.buisness.data.json.fastjson.annotation.jsontype;

import com.javaapi.test.buisness.constant.constant.classconstant.ConstantGame;

/**
 * Created by user on 18/4/5
 */
public class Student {
    private String name;
    private ConstantGame constantGame;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConstantGame getConstantGame() {
        return constantGame;
    }

    public void setConstantGame(ConstantGame constantGame) {
        this.constantGame = constantGame;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", constantGame=").append(constantGame);
        sb.append('}');
        return sb.toString();
    }
}



