package com.example.a79069.homeworkmvp.addClassroomTask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a79069.homeworkmvp.R;

/**
 * Created by 79069 on 2017/3/21.
 */

public class AddClassroomFragment extends Fragment
        implements AddClassroomContract.View {

    public static AddClassroomFragment newInstance(){
        return new AddClassroomFragment();
    }

    private AddClassroomContract.Presenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_classroom , container , false);

        /**
         * 测试用
         */
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.addClassroom();
            }
        });

        return view;
    }


    @Override
    public void setPresenter(AddClassroomPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void closeActivity() {
        getActivity().finish();
    }
}
