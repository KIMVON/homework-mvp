package com.example.a79069.homeworkmvp.forgetTask;

import com.example.a79069.homeworkmvp.data.source.AppRepository;
import com.example.a79069.homeworkmvp.registerTask.RegisterContract;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by 79069 on 2017/3/16.
 */

public class ForgetPresenter implements ForgetContract.Presenter {
    private AppRepository mAppRepository;
    private ForgetContract.View mForgetFragment;
    public ForgetPresenter(AppRepository appRepository, ForgetContract.View forgetView) {
        checkNotNull(appRepository);
        checkNotNull(forgetView);

        mAppRepository = appRepository;
        mForgetFragment = forgetView;

        mForgetFragment.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
