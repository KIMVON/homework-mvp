package com.example.a79069.homeworkmvp.data;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 79069 on 2017/3/14.
 */

public class Classroom extends DataSupport{
    private int id;

    private String name;

    private int numOfPeople;

    private int nameOfTeacher;

    private List<People> peopleList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public int getNameOfTeacher() {
        return nameOfTeacher;
    }

    public void setNameOfTeacher(int nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }
}
