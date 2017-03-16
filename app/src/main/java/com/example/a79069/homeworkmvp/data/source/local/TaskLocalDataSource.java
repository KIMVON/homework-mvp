package com.example.a79069.homeworkmvp.data.source.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.a79069.homeworkmvp.app.MyApplication;
import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.data.Homework;
import com.example.a79069.homeworkmvp.data.Message;
import com.example.a79069.homeworkmvp.data.People;
import com.example.a79069.homeworkmvp.data.source.TasksDataSource;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79069 on 2017/3/15.
 */

public class TaskLocalDataSource implements TasksDataSource {
    private static TaskLocalDataSource INSTANCE;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private static final String REMEMBER_PASSWORD = "com.example.a79069.homeworkmvp.data.source.local.remember_password";
    private static final String ACCOUNT = "com.example.a79069.homeworkmvp.data.source.local.account";
    private static final String PASSWORD = "com.example.a79069.homeworkmvp.data.source.local.password";

    public static TaskLocalDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new TaskLocalDataSource();
        }
        return INSTANCE;
    }

    private TaskLocalDataSource(){
        LitePal.getDatabase();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        mEditor = mSharedPreferences.edit();
    }

    @Override
    public void getMyInformation() {
        People people = new People();

        people = (People) DataSupport.where("name=?" , "").find(People.class);
    }




    @Override
    public void queryLoginAccountInfo(String account, GetPeopleCallback callback) {
         List<People> peopleList = DataSupport.where("account=?" , account).find(People.class);
        if (peopleList.size() == 0){
            callback.onDataNotAvailable();
        }else {
            callback.loadPeople(peopleList.get(0));
        }

    }

    @Override
    public void getNewHomeworksInfo(LoadHomeworkCallback callback) {
        List<Homework> homeworkList = new ArrayList<>();

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
    public void getFriendInfo(GetPeopleCallback callback) {

    }


    @Override
    public void getMessagesInfo(LoadMessagesCallback callback) {

    }

    @Override
    public void getMessageInfo(GetMessageCallback callback) {

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


    /**
     * SharePreference()的相关操作
     *
     * **/
    public void saveAccountInSharePreferences(String account){
        mEditor.putString(ACCOUNT , account);
        mEditor.apply();
    }

    public String getAccountInSharePreferences(){
        String account = mSharedPreferences.getString(ACCOUNT , null);
        return account;
    }

    public void savePasswordInSharePreferences(String password){
        mEditor.putString(PASSWORD , password);
        mEditor.apply();
    }

    public String getPasswordInSharePreferences(){
        String password = mSharedPreferences.getString(PASSWORD , null);
        return password;
    }

    public void saveIsRememberInSharePreferences(Boolean isRemember){
        mEditor.putBoolean(REMEMBER_PASSWORD , isRemember);
        mEditor.apply();
    }

    public boolean getIsRememberInSharePreferences(){
        boolean isRemember = mSharedPreferences.getBoolean(REMEMBER_PASSWORD , false);
        return isRemember;
    }

    public void deletePassworkInSharePreferences(){
        mEditor.remove(PASSWORD);
        mEditor.apply();
    }

}
