package com.javaapi.test.spring.ioc.xml.xmlioc;

import java.util.List;

import org.springframework.http.MediaType;

public class HtmlPage {
    List<MediaType> list;
    List<People> peoplelist;
    public List<MediaType> getList() {
        return list;
    }

    public void setList(List<MediaType> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HtmlPage [list=" + list + "]";
    }

    public List<People> getPeoplelist() {
        return peoplelist;
    }

    public void setPeoplelist(List<People> peoplelist) {
        this.peoplelist = peoplelist;
    }

}
