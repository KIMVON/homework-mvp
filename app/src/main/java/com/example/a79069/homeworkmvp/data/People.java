package com.example.a79069.homeworkmvp.data;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 79069 on 2017/3/14.
 */

public class People extends DataSupport{
    private String id;

    private String name;

    private String sex;

    private int year;

    private String account;

    private String password;

    private String peopleType;

    private List<Homework> homeworkList;

    private List<Classroom> classroomList;

    private List<Message> messageList;

    private List<People> friendsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType;
    }

    public List<Homework> getHomeworkList() {
        return homeworkList;
    }

    public void setHomeworkList(List<Homework> homeworkList) {
        this.homeworkList = homeworkList;
    }

    public List<Classroom> getClassroomList() {
        return classroomList;
    }

    public void setClassroomList(List<Classroom> classroomList) {
        this.classroomList = classroomList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<People> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<People> friendsList) {
        this.friendsList = friendsList;
    }
}
