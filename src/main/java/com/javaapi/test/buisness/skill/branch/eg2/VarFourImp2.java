package com.javaapi.test.buisness.skill.branch.eg2;

import java.util.HashMap;
import java.util.Map;

public class VarFourImp2 implements VarFour {
    static Map<String, VarFive> map = new HashMap<String, VarFive>();
    static {
        map.put("one", new VarFiveImp1());
        map.put("two", new VarFiveImp2());
    }
    VarFive                     var;

    public VarFive getVar() {
        return var;
    }

    public void setVar(VarFive var) {
        this.var = var;
    }

    @Override
    public String getName(String var) {
        System.out.println(this.getClass().getName());
        String paramFive = null;
        map.get(var).getName(paramFive);
        return null;
    }
}
