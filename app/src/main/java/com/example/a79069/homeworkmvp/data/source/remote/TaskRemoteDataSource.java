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
    public void getNewHomeworksInfo(LoadHomeworkCallback callback) {

    }

    @Override
    public void getNewHomeworkInfo(GetHomeworkCallback callback) {

    }

    @Override
    public void getMySubmitAnswersInfo(LoadHomeworkCallback callback) {

    }

    @Override
    public void getHomeworkAnswerInfo(GetHomeworkCallback callback) {

    }

    @Override
    public void getMySubmitHomework(LoadHomeworkCallback callback) {

    }

    @Override
    public void getMySubmitHomework(GetHomeworkCallback callback) {

    }

    @Override
    public void getHistoryHomeworksInfo(LoadHomeworkCallback callback) {

    }

    @Override
    public void getHistoryHomeworkInfo(GetHomeworkCallback callback) {

    }

    @Override
    public void getMyClassroomsInfo(LoadMyClassroomsCallback callback) {

    }

    @Override
    public void getMyClassroomInfo(GetMyClassroomCallback callback) {

    }

    @Override
    public void getFriendsInfo(LoadMyFriendsCallback callback) {

    }

    @Override
    public void getFriendInfo(GetMyFriendCallback callback) {

    }

    @Override
    public void getMessagesInfo(LoadMessagesCallback callback) {

    }

    @Override
    public void getMessageInfo(GetMessageCallback callback) {

    }

    @Override
    public void getMyInformation() {

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
