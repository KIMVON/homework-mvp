package com.example.a79069.homeworkmvp.addClassroomTask;
import static com.google.common.base.Preconditions.checkNotNull;

import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.data.source.AppRepository;

/**
 * Created by 79069 on 2017/3/21.
 */

public class AddClassroomPresenter implements AddClassroomContract.Presenter {
    private AppRepository mAppRepository;
    private AddClassroomContract.View mAddClassroomFragment;

    public AddClassroomPresenter(AppRepository appRepository , AddClassroomContract.View addClassroomFragmentView){
        checkNotNull(appRepository);
        checkNotNull(addClassroomFragmentView);

        mAppRepository = appRepository;

        mAddClassroomFragment = addClassroomFragmentView;

        mAddClassroomFragment.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void addClassroom() {
        Classroom classroom = new Classroom();
        classroom.setName("六年三班");
        mAppRepository.addMyClassroom(classroom);
        mAddClassroomFragment.closeActivity();
    }
}
