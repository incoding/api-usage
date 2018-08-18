package com.javaapi.test.buisness.skill.branch;

import com.javaapi.test.buisness.skill.branch.eg2.VarFive;
import com.javaapi.test.buisness.skill.branch.eg2.VarFour;
import com.javaapi.test.buisness.skill.branch.eg2.VarOne;
import com.javaapi.test.buisness.skill.branch.eg2.VarThree;
import com.javaapi.test.buisness.skill.branch.eg2.VarTwo;

/**
 * 可以当做方法参数
 * 
 * @author
 * 
 */
public class Param {
    public VarOne   one;
    public VarTwo   two;
    public VarThree three;
    public VarFour  four;
    public VarFive  five;

    public VarOne getOne() {
        return one;
    }

    public void setOne(VarOne one) {
        this.one = one;
    }

    public VarTwo getTwo() {
        return two;
    }

    public void setTwo(VarTwo two) {
        this.two = two;
    }

    public VarThree getThree() {
        return three;
    }

    public void setThree(VarThree three) {
        this.three = three;
    }

    public VarFour getFour() {
        return four;
    }

    public void setFour(VarFour four) {
        this.four = four;
    }

    public VarFive getFive() {
        return five;
    }

    public void setFive(VarFive five) {
        this.five = five;
    }

}
