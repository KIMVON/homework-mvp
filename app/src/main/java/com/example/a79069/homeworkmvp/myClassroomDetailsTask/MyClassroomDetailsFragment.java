package com.example.a79069.homeworkmvp.myClassroomDetailsTask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 79069 on 2017/3/22.
 */

public class MyClassroomDetailsFragment extends Fragment implements MyClassroomDetailsContract.View {
    public static MyClassroomDetailsFragment newInstance(){
        return new MyClassroomDetailsFragment();
    }

    private MyClassroomDetailsPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setPresenter(MyClassroomDetailsContract.Presenter presenter) {
        mPresenter = (MyClassroomDetailsPresenter) presenter;
    }
}
