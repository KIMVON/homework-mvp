package com.example.a79069.homeworkmvp.maintask;

import com.example.a79069.homeworkmvp.BasePresenter;
import com.example.a79069.homeworkmvp.BaseView;

/**
 * Created by 79069 on 2017/3/14.
 */

public interface MainTaskContract {
    interface Presenter extends BasePresenter {
        void loadNewHomework();

        void loadMyClass();
    }

    interface View extends BaseView<Presenter> {
        interface OneView extends View {
            void showMySubmitTask();

            void showNewHomeworkTask();

            void showAnswerTask();

            void showAddClass();

            void showSubmitHomeworkTask();

            void showMyInfo();

            void showHistoryHomework();

            void showSchoolSociety();
        }
    }
}
