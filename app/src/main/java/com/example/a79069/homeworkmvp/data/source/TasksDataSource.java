package com.example.a79069.homeworkmvp.data.source;

import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.data.Friends;
import com.example.a79069.homeworkmvp.data.Homework;
import com.example.a79069.homeworkmvp.data.Message;
import com.example.a79069.homeworkmvp.data.People;

import java.util.List;

/**
 * Created by 79069 on 2017/3/14.
 */

public interface TasksDataSource {
    /**
     * 加载作业的回调
     * */
    interface LoadHomeworkCallback{
        void loadHomeworks(List<Homework> homeworkList);

        void onDataNotAvailable();
    }

    interface GetHomeworkCallback{
        void loadHomework(Homework homework);

        void onDataNotAvailable();
    }


    /**
     * 加载班级的回调
     * */
    interface LoadMyClassroomsCallback{
        void loadMyClassrooms(List<Classroom> classroomList);

        void onDataNotAvailable();
    }

    interface GetMyClassroomCallback{
        void loadMyClassroom(Classroom classroom);

        void onDataNotAvailable();
    }

    /**
     * 加载朋友的回调
     * */
    interface LoadMyFriendsCallback{
        void loadMyFriends(List<Friends> friendsList);

        void onDataNotAvailable();
    }

    interface GetPeopleCallback{
        void loadPeople(People people);

        void onDataNotAvailable();
    }

    /**
     * 加载信息的回调
     * */
    interface LoadMessagesCallback{
        void loadMessages(List<Message> messageList);

        void onDataNotAvailable();
    }

    interface GetMessageCallback{
        void loadMessage(Message message);

        void onDataNotAvailable();
    }


    /**
     * 注册回调
     */
    interface RegisterAccountCallback{
        void registerSuccess();

        void registerFailed(String account);
    }


    void registerAccount(String account, String password, String name, String sex, int year, String userType ,RegisterAccountCallback callback);

    void getUserInformation(GetPeopleCallback callback);

    void queryLoginAccountInfo(String account,GetPeopleCallback callback);

    void getNewHomeworksInfo(LoadHomeworkCallback callback);
    void getNewHomeworkInfo(GetHomeworkCallback callback);

    void getMySubmitAnswersInfo(LoadHomeworkCallback callback);
    void getHomeworkAnswerInfo(GetHomeworkCallback callback);

    void getMySubmitHomework(LoadHomeworkCallback callback);
    void getMySubmitHomework(GetHomeworkCallback callback);

    void getHistoryHomeworksInfo(LoadHomeworkCallback callback);
    void getHistoryHomeworkInfo(GetHomeworkCallback callback);

    void getMyClassroomsInfo(LoadMyClassroomsCallback callback);
    void getMyClassroomInfo(GetMyClassroomCallback callback);

    void getFriendsInfo(LoadMyFriendsCallback callback);
    void getFriendInfo(GetPeopleCallback callback);

    void getMessagesInfo(LoadMessagesCallback callback);
    void getMessageInfo(GetMessageCallback callback);


    void getSchoolSocietyInfo();

    void refreshNewHomework();

    void refreshMessageInfo();

    void refreshFriendsInfo();

    void addMyClassroom(Classroom classroom);

    void pushMyHomework(Homework homework);

    void addFriend(People people);

    void deleteFriend(People people);

    void sendMessage(Message message);

    void deleteMessage(Message message);

    void deleteAllMessage();

    void pushGoodHomework(Homework homework);
}
