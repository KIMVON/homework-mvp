package com.example.a79069.homeworkmvp.studentMainTask;

import static com.google.common.base.Preconditions.checkNotNull;
import com.example.a79069.homeworkmvp.data.source.AppRepository;

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

    public StudentTaskPresenter(AppRepository appRepository , List<StudentTaskContract.View> fragmentList){
        mAppRepository = checkNotNull(appRepository , "AppRepository");

        mOneFragmentView = checkNotNull(fragmentList.get(0),"OneFragment");
        mTwoFragmentView =  checkNotNull(fragmentList.get(1),"TwoFragment");
        mThreeFragmentView = checkNotNull(fragmentList.get(2),"ThreeFragment");
        mFourFragmentView =  checkNotNull(fragmentList.get(3),"FourFragment");

        mOneFragmentView.setPresenter(this);
        mTwoFragmentView.setPresenter(this);
        mThreeFragmentView.setPresenter(this);
        mFourFragmentView.setPresenter(this);
    }

    @Override
    public void start() {

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
