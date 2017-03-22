package com.example.a79069.homeworkmvp.addClassroomTask;

import com.example.a79069.homeworkmvp.BasePresenter;
import com.example.a79069.homeworkmvp.BaseView;

/**
 * Created by 79069 on 2017/3/21.
 */

public interface AddClassroomContract {
    interface Presenter extends BasePresenter{
        void addClassroom();
    }

    interface View extends BaseView<AddClassroomPresenter>{
        void closeActivity();
    }
}
