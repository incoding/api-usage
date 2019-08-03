package com.javaapi.test.buisness.pattern.structure.decorator.mytest;

public class ManOper1 implements Person{
    
    private Person person;
    
    @Override
    public void eat() {
        person.eat();
        System.out.println("再吃1");
    }



    public Person getPerson() {
        return person;
    }



    public void setPerson(Person person) {
        this.person = person;
    }

}
