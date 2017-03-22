package com.example.a79069.homeworkmvp.myClassroomDetailsTask;

import com.example.a79069.homeworkmvp.data.source.AppRepository;
import com.example.a79069.homeworkmvp.registerTask.RegisterContract;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by 79069 on 2017/3/22.
 */

public class MyClassroomDetailsPresenter implements MyClassroomDetailsContract.Presenter {
    private AppRepository mAppRepository;
    private MyClassroomDetailsContract.View mMyClassroomDetailsFragment;
    public MyClassroomDetailsPresenter(AppRepository appRepository , MyClassroomDetailsContract.View myClassroomDetailsView){
        checkNotNull(appRepository);
        checkNotNull(myClassroomDetailsView);

        mAppRepository = appRepository;
        mMyClassroomDetailsFragment = myClassroomDetailsView;

        mMyClassroomDetailsFragment.setPresenter(this);
    }
    @Override
    public void start() {

    }
}
