package com.example.a79069.homeworkmvp.registerTask;

import com.example.a79069.homeworkmvp.data.source.AppRepository;
import static com.google.common.base.Preconditions.checkNotNull;
/**
 * Created by 79069 on 2017/3/16.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private AppRepository mAppRepository;
    private RegisterContract.View mRegisterFragment;
    public RegisterPresenter(AppRepository appRepository , RegisterContract.View registerView){
        checkNotNull(appRepository);
        checkNotNull(registerView);

        mAppRepository = appRepository;
        mRegisterFragment = registerView;

        mRegisterFragment.setPresenter(this);
    }

    @Override
    public void registerUserInfo(String account, String password, String name, String sex, int year, String userType) {

    }

    @Override
    public void start() {

    }
}
