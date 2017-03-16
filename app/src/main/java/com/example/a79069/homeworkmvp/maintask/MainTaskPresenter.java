package com.example.a79069.homeworkmvp.maintask;

import android.support.v4.app.Fragment;
import static com.google.common.base.Preconditions.checkNotNull;
import com.example.a79069.homeworkmvp.data.source.AppRepository;

import java.util.List;

/**
 * Created by 79069 on 2017/3/14.
 */

public class MainTaskPresenter implements MainTaskContract.Presenter {
    private MainTaskContract.View mOneFragmentView;
    private MainTaskContract.View mTwoFragmentView;
    private MainTaskContract.View mThreeFragmentView;
    private MainTaskContract.View mFourFragmentView;

    private AppRepository mAppRepository;

    public MainTaskPresenter(AppRepository appRepository , List<MainTaskContract.View> fragmentList){
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
