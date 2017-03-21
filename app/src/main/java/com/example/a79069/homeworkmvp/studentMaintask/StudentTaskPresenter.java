package com.example.a79069.homeworkmvp.studentMainTask;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import static com.google.common.base.Preconditions.checkNotNull;

import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.data.People;
import com.example.a79069.homeworkmvp.data.source.AppRepository;
import com.example.a79069.homeworkmvp.data.source.TasksDataSource;
import com.example.a79069.homeworkmvp.studentMainTask.Fragment.OneFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79069 on 2017/3/14.
 */

public class StudentTaskPresenter implements StudentTaskContract.Presenter {
    private StudentTaskContract.View mOneFragmentView;
    private StudentTaskContract.View mTwoFragmentView;
    private StudentTaskContract.View mThreeFragmentView;
    private StudentTaskContract.View mFourFragmentView;

    private AppRepository mAppRepository;

    public StudentTaskPresenter(AppRepository appRepository, List<StudentTaskContract.View> fragmentList) {
        mAppRepository = checkNotNull(appRepository, "AppRepository");

        mOneFragmentView = checkNotNull(fragmentList.get(0), "OneFragment");
        mTwoFragmentView = checkNotNull(fragmentList.get(1), "TwoFragment");
        mThreeFragmentView = checkNotNull(fragmentList.get(2), "ThreeFragment");
        mFourFragmentView = checkNotNull(fragmentList.get(3), "FourFragment");

        mOneFragmentView.setPresenter(this);
        mTwoFragmentView.setPresenter(this);
        mThreeFragmentView.setPresenter(this);
        mFourFragmentView.setPresenter(this);
    }

    @Override
    public void start() {
        loadUserInfo();
    }

    public void loadUserInfo() {

    }

    @Override
    public void addClassroom() {

    }

    @Override
    public void startOne() {
        initializeClassrooms();
    }

    @Override
    public void startTwo() {
        initializeMessages();
    }

    @Override
    public void startThree() {
        initializeFriends();
    }

    @Override
    public void startFour() {

    }


    @Override
    public void initializeName(final Context context) {
        mAppRepository.getUserInformation(new TasksDataSource.GetPeopleCallback() {
            @Override
            public void loadPeople(People people) {
                if (people != null) {
                    ((StudentTaskActivity) context).showUserName(people.getName());
                }else {
                    ((StudentTaskActivity) context).showUserName("KIM");
                }
            }

            @Override
            public void onDataNotAvailable() {
            }
        });

    }

    @Override
    public void initializeClassrooms() {
        /**
         * 测试
         */
        ((OneFragment) mOneFragmentView).setAdapter(new ArrayList<Classroom>());
        mAppRepository.getMyClassroomsInfo(new TasksDataSource.LoadMyClassroomsCallback() {
            @Override
            public void loadMyClassrooms(List<Classroom> classroomList) {
                ((OneFragment) mOneFragmentView).setAdapter(classroomList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void initializeMessages() {

    }

    @Override
    public void initializeFriends() {

    }

    @Override
    public void loadNewHomework() {

    }

    @Override
    public void loadMyClassroom() {

    }

    @Override
    public void loadMessage() {

    }

}
