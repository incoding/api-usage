package com.javaapi.test.spring.aop.springaop2AutoProxy3AspectJAnnotataion;

/**
 * Created by user on 15/9/20.
 */
public class Book {
    private String name;
    private String url;
    private String pages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void printName() {
        System.out.println("name = " + name);
    }

    public void printUrl() {
        System.out.println("url = " + url);
    }

    public void printThrowException() {
        throw new RuntimeException("nihao");
    }
}
