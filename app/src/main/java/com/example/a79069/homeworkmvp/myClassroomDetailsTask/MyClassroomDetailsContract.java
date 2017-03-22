package com.example.a79069.homeworkmvp.myClassroomDetailsTask;

import android.view.View;

import com.example.a79069.homeworkmvp.BasePresenter;
import com.example.a79069.homeworkmvp.BaseView;

/**
 * Created by 79069 on 2017/3/22.
 */

public interface MyClassroomDetailsContract {
    interface Presenter extends BasePresenter{

    }


    interface View extends BaseView<Presenter>{

    }
}
