package com.javaapi.test.pattern.structure.bridge;

public class BlackHouse implements House {
    private Person person;
    
    
    @Override
    public void say() {
        System.out.println("在黑屋子里");
        person.dress();
    }


    public Person getPerson() {
        return person;
    }


    public void setPerson(Person person) {
        this.person = person;
    }

}
