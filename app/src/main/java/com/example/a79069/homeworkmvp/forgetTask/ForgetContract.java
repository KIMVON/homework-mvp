package com.example.a79069.homeworkmvp.forgetTask;

import com.example.a79069.homeworkmvp.BasePresenter;
import com.example.a79069.homeworkmvp.BaseView;

/**
 * Created by 79069 on 2017/3/16.
 */

public interface ForgetContract {
    interface Presenter extends BasePresenter{

    }

    interface View extends BaseView<Presenter>{
        void closeActivity();


    }
}
