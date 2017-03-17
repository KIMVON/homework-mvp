package com.example.a79069.homeworkmvp.studentMainTask;

import com.example.a79069.homeworkmvp.BasePresenter;
import com.example.a79069.homeworkmvp.BaseView;
import com.example.a79069.homeworkmvp.forgetTask.ForgetContract;

/**
 * Created by 79069 on 2017/3/14.
 */

public interface StudentTaskContract {
    interface Presenter extends BasePresenter {
        void loadNewHomework();

        void loadMyClassroom();

        void loadMessage();

    }

    interface View extends BaseView<Presenter> {
        interface OneView extends View {
            //启动我的提交
            void showMySubmitTask();

            //启动新的作业
            void showNewHomeworkTask();

            //启动作业答案
            void showAnswerTask();

            //添加班级
            void showAddClass();

            //启动提交作业的页面
            void showSubmitHomeworkTask();

            //启示我的班级界面
            void showMyClassroomInfo();

            //启动历史作业
            void showHistoryHomework();


        }

        interface TwoView extends View{

            //查看提到我的
            void showMentionsTask();

            //查看评论
            void showCommentsTask();

            //查看赞
            void showLikesTask();
        }

        interface FourView extends View{
            //启动校园社区
            void showSchoolSociety();
        }
    }
}
