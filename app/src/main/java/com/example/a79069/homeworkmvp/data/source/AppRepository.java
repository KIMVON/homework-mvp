package com.example.a79069.homeworkmvp.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.data.Friends;
import com.example.a79069.homeworkmvp.data.Homework;
import com.example.a79069.homeworkmvp.data.Message;
import com.example.a79069.homeworkmvp.data.People;
import com.example.a79069.homeworkmvp.data.source.local.TaskLocalDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 79069 on 2017/3/15.
 */

public class AppRepository implements TasksDataSource {
    private static AppRepository INSTANCE;

    Map<String, People> mCachedPeoples;


    private TasksDataSource mTasksLocalDataSource;
    private TasksDataSource mTasksRemoteDataSource;

    private AppRepository(TasksDataSource tasksLocalDataSource, TasksDataSource tasksRemoteDataSource) {
        mTasksLocalDataSource = tasksLocalDataSource;
        mTasksRemoteDataSource = tasksRemoteDataSource;
    }

    public static AppRepository getInstance(TasksDataSource tasksLocalDataSource, TasksDataSource tasksRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new AppRepository(tasksLocalDataSource, tasksRemoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void registerAccount(String account, String password, String name, String sex, int year, String userType , final RegisterAccountCallback callback) {
        checkNotNull(account);
        checkNotNull(password);
        checkNotNull(name);
        checkNotNull(sex);
        checkNotNull(year);
        checkNotNull(userType);
        checkNotNull(callback);


        mTasksLocalDataSource.registerAccount(account, password, name, sex, year, userType, new RegisterAccountCallback() {
            @Override
            public void registerSuccess() {
                callback.registerSuccess();
            }

            @Override
            public void registerFailed(String account) {
               callback.registerFailed(account);
            }
        });


    }

    @Override
    public void getUserInformation(final GetPeopleCallback callback) {
        checkNotNull(callback);

        mTasksLocalDataSource.getUserInformation(new GetPeopleCallback() {
            @Override
            public void loadPeople(People people) {
                callback.loadPeople(people);
            }

            @Override
            public void onDataNotAvailable() {

                mTasksRemoteDataSource.getUserInformation(new GetPeopleCallback() {
                    @Override
                    public void loadPeople(People people) {
                        callback.loadPeople(people);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });

    }

    @Override
    public void queryLoginAccountInfo(final String account, final GetPeopleCallback callback) {
        checkNotNull(account);
        checkNotNull(callback);

        People cachePeople = getPeopleWithAccount(account);

        if (cachePeople != null) {
            callback.loadPeople(cachePeople);
            return;
        }

        mTasksLocalDataSource.queryLoginAccountInfo(account, new GetPeopleCallback() {
            @Override
            public void loadPeople(People people) {
                if (mCachedPeoples == null) {
                    mCachedPeoples = new LinkedHashMap<>();
                }

                mCachedPeoples.put(people.getAccount(), people);
                callback.loadPeople(people);
            }

            @Override
            public void onDataNotAvailable() {
                mTasksRemoteDataSource.queryLoginAccountInfo(account, new GetPeopleCallback() {
                    @Override
                    public void loadPeople(People people) {
                        if (mCachedPeoples == null) {
                            mCachedPeoples = new LinkedHashMap<>();
                        }

                        mCachedPeoples.put(people.getAccount(), people);
                        callback.loadPeople(people);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
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
    public void getMyClassroomsInfo(final LoadMyClassroomsCallback callback) {
        checkNotNull(callback);

        mTasksLocalDataSource.getMyClassroomsInfo(new LoadMyClassroomsCallback() {
            @Override
            public void loadMyClassrooms(List<Classroom> classroomList) {
                callback.loadMyClassrooms(classroomList);
            }

            @Override
            public void onDataNotAvailable() {
                mTasksRemoteDataSource.getMyClassroomsInfo(new LoadMyClassroomsCallback() {
                    @Override
                    public void loadMyClassrooms(List<Classroom> classroomList) {
                        callback.loadMyClassrooms(classroomList);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void getMyClassroomInfo(GetMyClassroomCallback callback) {

    }

    @Override
    public void getFriendsInfo(final LoadMyFriendsCallback callback) {
        checkNotNull(callback);

        mTasksLocalDataSource.getFriendsInfo(new LoadMyFriendsCallback() {
            @Override
            public void loadMyFriends(List<Friends> friendsList) {
                callback.loadMyFriends(friendsList);
            }

            @Override
            public void onDataNotAvailable() {
                mTasksRemoteDataSource.getFriendsInfo(new LoadMyFriendsCallback() {
                    @Override
                    public void loadMyFriends(List<Friends> friendsList) {
                        callback.loadMyFriends(friendsList);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void getFriendInfo(GetPeopleCallback callback) {
        checkNotNull(callback);


    }

    @Override
    public void getMessagesInfo(final LoadMessagesCallback callback) {
        checkNotNull(callback);

        mTasksLocalDataSource.getMessagesInfo(new LoadMessagesCallback() {
            @Override
            public void loadMessages(List<Message> messageList) {
                callback.loadMessages(messageList);
            }

            @Override
            public void onDataNotAvailable() {
                mTasksRemoteDataSource.getMessagesInfo(new LoadMessagesCallback() {
                    @Override
                    public void loadMessages(List<Message> messageList) {
                        callback.loadMessages(messageList);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
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

    @Nullable
    private People getPeopleWithAccount(@NonNull String account) {
        checkNotNull(account);
        if (mCachedPeoples == null || mCachedPeoples.isEmpty()) {
            return null;
        } else {
            return mCachedPeoples.get(account);
        }
    }


    public void saveAccountInSharePreferences(String account) {
        ((TaskLocalDataSource) mTasksLocalDataSource).saveAccountInSharePreferences(account);
    }

    public String getAccountInSharePreferences() {
        return ((TaskLocalDataSource) mTasksLocalDataSource).getAccountInSharePreferences();
    }

    public void savePasswordInSharePreferences(String password) {
        ((TaskLocalDataSource) mTasksLocalDataSource).savePasswordInSharePreferences(password);
    }

    public String getPasswordInSharePreferences() {
        return ((TaskLocalDataSource) mTasksLocalDataSource).getPasswordInSharePreferences();
    }

    public void deletePasswordInSharePreference(){
        ((TaskLocalDataSource) mTasksLocalDataSource).deletePassworkInSharePreferences();
    }

    public void saveIsRememberInSharePreferences(Boolean isRemember) {
        ((TaskLocalDataSource) mTasksLocalDataSource).saveIsRememberInSharePreferences(isRemember);
    }

    public boolean getIsRememberInSharePreferences() {
        return ((TaskLocalDataSource) mTasksLocalDataSource).getIsRememberInSharePreferences();
    }


}