package com.example.a79069.homeworkmvp.studentMainTask.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskContract;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskPresenter;

/**
 * Created by 79069 on 2017/3/14.
 */

public class OneFragment extends Fragment implements StudentTaskContract.View.OneView, View.OnClickListener {
    public static OneFragment newInstance() {
        return new OneFragment();
    }
    private StudentTaskPresenter mStudentTaskPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one , container , false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recylerview_my_class);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 3));

        MyClassroomAdapter adapter = new MyClassroomAdapter();
        recyclerView.setAdapter(adapter);

        LinearLayout newHomeworkBtn = (LinearLayout) view.findViewById(R.id.new_homework);
        LinearLayout homeworkAnswerBtn = (LinearLayout) view.findViewById(R.id.answer_homework);
        LinearLayout myHomeworkAnswerBtn = (LinearLayout) view.findViewById(R.id.my_submit);
        newHomeworkBtn.setOnClickListener(this);
        myHomeworkAnswerBtn.setOnClickListener(this);
        homeworkAnswerBtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_one_menu , menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.post_homework:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.new_homework:
                break;
            case R.id.my_submit:
                break;
            case R.id.answer_homework:
                break;
        }
    }
    private class MyClassroomViewHolder extends RecyclerView.ViewHolder{

        public MyClassroomViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class MyClassroomAdapter extends RecyclerView.Adapter<MyClassroomViewHolder>{

        public MyClassroomAdapter(){

        }

        @Override
        public MyClassroomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(MyClassroomViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    @Override
    public void setPresenter(StudentTaskContract.Presenter presenter) {
        mStudentTaskPresenter = (StudentTaskPresenter) presenter;
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
    public void showMyClassroomInfo() {

    }


    @Override
    public void showHistoryHomework() {

    }

}
