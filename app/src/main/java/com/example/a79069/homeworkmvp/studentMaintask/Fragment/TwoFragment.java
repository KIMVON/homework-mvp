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

public class TwoFragment extends Fragment implements StudentTaskContract.View.TwoView, View.OnClickListener {
    public static TwoFragment newInstance(){
        return new TwoFragment();
    }
    private LinearLayout mMentionsLinearLayout;
    private LinearLayout mCommentsLinearLayout;
    private LinearLayout mLikesLinearLayout;

    private StudentTaskContract.Presenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two , container , false);

        mMentionsLinearLayout = (LinearLayout) view.findViewById(R.id.mentions_linearlayout);
        mCommentsLinearLayout = (LinearLayout) view.findViewById(R.id.comments_linearlayout);
        mLikesLinearLayout = (LinearLayout) view.findViewById(R.id.likes_linearlayout);

        mMentionsLinearLayout.setOnClickListener(this);
        mCommentsLinearLayout.setOnClickListener(this);
        mLikesLinearLayout.setOnClickListener(this);



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        mPresenter.start();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.fragment_two_menu , menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(StudentTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mentions_linearlayout:
                break;
            case R.id.comments_linearlayout:
                break;
            case R.id.likes_linearlayout:
                break;
        }
    }

    @Override
    public void showMentionsTask() {

    }

    @Override
    public void showCommentsTask() {

    }

    @Override
    public void showLikesTask() {

    }
}
