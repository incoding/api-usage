package com.javaapi.test.buisness.skill.branch.eg2;

import java.util.HashMap;
import java.util.Map;

public class VarThreeImp1 implements VarThree {
    static Map<String, VarFour> map = new HashMap<String, VarFour>();
    static {
        map.put("one", new VarFourImp1());
        map.put("two", new VarFourImp2());
    }
    VarFour                     var;

    public VarFour getVar() {
        return var;
    }

    public void setVar(VarFour var) {
        this.var = var;
    }

    @Override
    public String getName(String var) {
        System.out.println(this.getClass().getName());
        map.get(var).getName(var);
        return null;
    }
}
