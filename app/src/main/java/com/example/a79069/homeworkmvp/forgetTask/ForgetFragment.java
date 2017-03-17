package com.example.a79069.homeworkmvp.forgetTask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by 79069 on 2017/3/16.
 */

public class ForgetFragment extends Fragment implements ForgetContract.View {
    private ForgetContract.Presenter mPresenter;

    public static Fragment newInstance(){
        return new ForgetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void closeActivity() {
        getActivity().finish();
    }

    @Override
    public void setPresenter(ForgetContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
