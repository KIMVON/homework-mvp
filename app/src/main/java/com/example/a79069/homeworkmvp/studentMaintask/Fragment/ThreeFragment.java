package com.example.a79069.homeworkmvp.studentMainTask.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskContract;

/**
 * Created by 79069 on 2017/3/14.
 */

public class ThreeFragment extends Fragment implements StudentTaskContract.View, View.OnClickListener {
    public static ThreeFragment newInstance(){
        return new ThreeFragment();
    }

    private LinearLayout mNewFriendsLinearLayout;
    private LinearLayout mMyTeacherLinearLayout;
    private LinearLayout mClassroomGroupChatLinearLayout;

    private StudentTaskContract.Presenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three , container , false);

        mNewFriendsLinearLayout = (LinearLayout) view.findViewById(R.id.new_friends);
        mMyTeacherLinearLayout = (LinearLayout) view.findViewById(R.id.my_teachers);
        mClassroomGroupChatLinearLayout = (LinearLayout) view.findViewById(R.id.classroom_group_chat);

        mNewFriendsLinearLayout.setOnClickListener(this);
        mMyTeacherLinearLayout.setOnClickListener(this);
        mClassroomGroupChatLinearLayout.setOnClickListener(this);


        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.fragment_three_menu , menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_friends:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.new_friends:
                break;
            case R.id.my_teachers:
                break;
            case R.id.classroom_group_chat:
                break;
        }
    }

    @Override
    public void setPresenter(StudentTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

}
