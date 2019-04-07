package com.javaapi.test.test.javafeature.version8.streams;

/**
 * Created by user on 15/8/15.
 */
public class Person {

    private String firstName, lastName, job, gender;
    private Integer salary;
    private Integer age;

    public Person(String firstName, String lastName, String job,
                  String gender, int age, int salary)       {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // Getter and Setter
// . . . . .

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", job='").append(job).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}