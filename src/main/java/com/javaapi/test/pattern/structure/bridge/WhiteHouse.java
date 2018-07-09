package com.javaapi.test.pattern.structure.bridge;

public class WhiteHouse implements House {
    private Person person;
    
    
    @Override
    public void say() {
        System.out.println("在白房子里");
        person.dress();
    }


    public Person getPerson() {
        return person;
    }


    public void setPerson(Person person) {
        this.person = person;
    }

}
