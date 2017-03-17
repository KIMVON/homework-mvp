package com.example.a79069.homeworkmvp.studentMainTask.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskContract;

/**
 * Created by 79069 on 2017/3/14.
 */

public class FourFragment extends Fragment implements StudentTaskContract.View.FourView{
    public static FourFragment newInstance(){
        return new FourFragment();
    }

    private Button mSchoolSocietyButton;
    private Button mLogoutButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four , container , false);

        mSchoolSocietyButton = (Button) view.findViewById(R.id.school_society);
        mLogoutButton = (Button) view.findViewById(R.id.logout_button);

        return view;
    }

    @Override
    public void setPresenter(StudentTaskContract.Presenter presenter) {

    }

    @Override
    public void showSchoolSociety() {

    }
}
