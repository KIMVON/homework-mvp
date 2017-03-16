package com.example.a79069.homeworkmvp.loginTask;

import com.example.a79069.homeworkmvp.BasePresenter;
import com.example.a79069.homeworkmvp.BaseView;

/**
 * Created by 79069 on 2017/3/15.
 */

public interface LoginTaskContract {
    interface Presenter extends BasePresenter{
        void loginApp(String account , String password , String peopleType , Boolean isRemember);
    }

    interface View extends BaseView<Presenter>{
        void loginSuccess();

        void loginFailed();

        void showRegisteredActivity();

        void showForgetActivity();

        void closeActivity();
    }
}
