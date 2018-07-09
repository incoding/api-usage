package com.javaapi.test.buisness.dataTrans.json.fastjson.feature.pojo;

import com.javaapi.test.buisness.dataTrans.json.fastjson.feature.pojo.Book;

/**
 * Created by user on 18/4/5
 */
public class Student {
    private String name;
    private int age;
    private Book book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", book=").append(book);
        sb.append('}');
        return sb.toString();
    }
}



