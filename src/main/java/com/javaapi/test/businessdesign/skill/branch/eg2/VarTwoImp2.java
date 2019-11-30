package com.javaapi.test.businessdesign.skill.branch.eg2;

import java.util.HashMap;
import java.util.Map;

public class VarTwoImp2 implements VarTwo {
    static Map<String, VarThree> map = new HashMap<String, VarThree>();
    static {
        map.put("one", new VarThreeImp1());
        map.put("two", new VarThreeImp2());
    }
    VarThree                     three;

    public VarThree getThree() {
        return three;
    }

    public void setThree(VarThree three) {
        this.three = three;
    }

    @Override
    public String getName(String var) {
        String paramThree = null;
        System.out.println(this.getClass().getName());
        map.get(var).getName(paramThree);
        return null;
    }
}
