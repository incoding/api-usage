package com.javaapi.test.buisness.skill.branch.eg2;

import java.util.HashMap;
import java.util.Map;

public class VarOneImp2 implements VarOne {
    static Map<String, VarTwo> map = new HashMap<String, VarTwo>();
    static {
        map.put("one", new VarTwoImp1());
        map.put("two", new VarTwoImp2());
    }
    public VarTwo              two;

    public VarTwo getTwo() {
        return two;
    }

    public void setTwo(VarTwo two) {
        this.two = two;
    }

    @Override
    public String getName(String var) {
        String paramThree = null;
        System.out.println(this.getClass().getName());
        map.get(var).getName(paramThree);
        return null;
    }
}
