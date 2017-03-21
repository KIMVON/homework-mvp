package com.example.a79069.homeworkmvp.registerTask;

import com.example.a79069.homeworkmvp.data.source.AppRepository;
import com.example.a79069.homeworkmvp.data.source.TasksDataSource;

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


    /**
     * 注册账号
     * @param account
     * @param password
     * @param name
     * @param sex
     * @param year
     * @param userType
     */
    @Override
    public void registerUserInfo(String account, String password, String name, String sex, int year, String userType ) {
        mAppRepository.registerAccount(account, password, name, sex, year, userType, new TasksDataSource.RegisterAccountCallback() {
            @Override
            public void registerSuccess() {
                mRegisterFragment.registerSuccess();
            }

            @Override
            public void registerFailed(String account) {
                mRegisterFragment.showAlertDialog("Error" , "注册失败，"+account+"已经存在" , null);
            }
        });
    }

    @Override
    public void start() {

    }


}
