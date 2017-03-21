package com.example.a79069.homeworkmvp.data;

import org.litepal.crud.DataSupport;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79069 on 2017/3/14.
 */

public class Homework extends DataSupport{
    private int id;

    private Date date;

    private String subject;

    private String content;

    private List<People> peopleList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }
}
