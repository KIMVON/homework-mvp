package com.example.a79069.homeworkmvp.maintask.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.maintask.MainTaskContract;
import com.example.a79069.homeworkmvp.maintask.MainTaskPresenter;

/**
 * Created by 79069 on 2017/3/14.
 */

public class OneFragment extends Fragment implements MainTaskContract.View.OneView{
    public static OneFragment newInstance() {
        return new OneFragment();
    }
    private MainTaskPresenter mMainTaskPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one , container , false);


        return view;
    }

    @Override
    public void setPresenter(MainTaskContract.Presenter presenter) {
        mMainTaskPresenter = (MainTaskPresenter) presenter;
    }

    @Override
    public void showMySubmitTask() {

    }

    @Override
    public void showNewHomeworkTask() {

    }

    @Override
    public void showAnswerTask() {

    }

    @Override
    public void showAddClass() {

    }

    @Override
    public void showSubmitHomeworkTask() {

    }

    @Override
    public void showMyInfo() {

    }

    @Override
    public void showHistoryHomework() {

    }

    @Override
    public void showSchoolSociety() {

    }

}
