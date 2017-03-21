package com.example.a79069.homeworkmvp.registerTask;

import android.content.DialogInterface;

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

        void registerAccount();

        void registerSuccess();

        void registerFailed(String account , String password , String passwordAgain , String name , String sex , String year , String userType);

        void showAlertDialog(String title , String message , DialogInterface.OnClickListener listener);

        }
}
