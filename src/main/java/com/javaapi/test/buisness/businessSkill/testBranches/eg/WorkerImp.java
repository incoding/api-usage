package com.javaapi.test.buisness.businessSkill.testBranches.eg;

public class WorkerImp implements PeopleI {

    @Override
    public String getName() {
        String name = "worker";
        System.out.println(name);
        return name;
    }

}
