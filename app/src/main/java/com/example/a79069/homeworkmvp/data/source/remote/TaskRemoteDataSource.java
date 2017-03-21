package com.example.a79069.homeworkmvp.data.source.remote;

import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.data.Homework;
import com.example.a79069.homeworkmvp.data.Message;
import com.example.a79069.homeworkmvp.data.People;
import com.example.a79069.homeworkmvp.data.source.TasksDataSource;

/**
 * Created by 79069 on 2017/3/15.
 */

public class TaskRemoteDataSource implements TasksDataSource {
    private static TaskRemoteDataSource INSTANCE;
    public static TasksDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TaskRemoteDataSource();
        }
        return INSTANCE;
    }


    @Override
    public void registerAccount(String account, String password,
                                String name, String sex, int year, String userType , RegisterAccountCallback callback) {
        callback.registerFailed(account);
    }

    @Override
    public void getUserInformation(GetPeopleCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void queryLoginAccountInfo(String account, GetPeopleCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getNewHomeworksInfo(LoadHomeworkCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getNewHomeworkInfo(GetHomeworkCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getMySubmitAnswersInfo(LoadHomeworkCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getHomeworkAnswerInfo(GetHomeworkCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getMySubmitHomework(LoadHomeworkCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getMySubmitHomework(GetHomeworkCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getHistoryHomeworksInfo(LoadHomeworkCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getHistoryHomeworkInfo(GetHomeworkCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getMyClassroomsInfo(LoadMyClassroomsCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getMyClassroomInfo(GetMyClassroomCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getFriendsInfo(LoadMyFriendsCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getFriendInfo(GetPeopleCallback callback) {
        callback.onDataNotAvailable();
    }




    @Override
    public void getMessagesInfo(LoadMessagesCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getMessageInfo(GetMessageCallback callback) {
        callback.onDataNotAvailable();
    }

    @Override
    public void getSchoolSocietyInfo() {

    }

    @Override
    public void refreshNewHomework() {

    }

    @Override
    public void refreshMessageInfo() {

    }

    @Override
    public void refreshFriendsInfo() {

    }

    @Override
    public void addMyClassroom(Classroom classroom) {

    }

    @Override
    public void pushMyHomework(Homework homework) {

    }

    @Override
    public void addFriend(People people) {

    }

    @Override
    public void deleteFriend(People people) {

    }

    @Override
    public void sendMessage(Message message) {

    }

    @Override
    public void deleteMessage(Message message) {

    }

    @Override
    public void deleteAllMessage() {

    }

    @Override
    public void pushGoodHomework(Homework homework) {

    }
}
