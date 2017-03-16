package com.example.a79069.homeworkmvp.registerTask;

import com.example.a79069.homeworkmvp.BasePresenter;
import com.example.a79069.homeworkmvp.BaseView;

/**
 * Created by 79069 on 2017/3/16.
 */

public interface RegisterContract {
    interface Presenter extends BasePresenter{
        void registerUserInfo(String account , String password , String name , String sex , int year , String userType);
    }


    interface View extends BaseView<Presenter>{
        void closeActivity();

        void registerSuccess();

        void registerFailed();
    }
}
