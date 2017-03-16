package com.example.a79069.homeworkmvp.data;

import org.litepal.crud.DataSupport;

import java.sql.Date;

/**
 * Created by 79069 on 2017/3/15.
 */

public class Message extends DataSupport {
    private int id;

    private String content;

    private String sendPeople;

    private String acceptPeople;

    private Date date;

    private People people;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendPeople() {
        return sendPeople;
    }

    public void setSendPeople(String sendPeople) {
        this.sendPeople = sendPeople;
    }

    public String getAcceptPeople() {
        return acceptPeople;
    }

    public void setAcceptPeople(String acceptPeople) {
        this.acceptPeople = acceptPeople;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
