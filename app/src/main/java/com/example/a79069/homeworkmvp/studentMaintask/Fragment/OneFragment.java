package com.example.a79069.homeworkmvp.studentMainTask.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.addClassroomTask.AddClassroomActivity;
import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskContract;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskPresenter;

import java.util.List;

/**
 * Created by 79069 on 2017/3/14.
 */

public class OneFragment extends Fragment implements StudentTaskContract.View.OneView, View.OnClickListener {
    public static OneFragment newInstance() {
        return new OneFragment();
    }
    private StudentTaskPresenter mStudentTaskPresenter;

    private RecyclerView mClassroomsRecyclerView;

    private MyClassroomAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one , container , false);

        mClassroomsRecyclerView = (RecyclerView) view.findViewById(R.id.recylerview_my_class);
        mClassroomsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 3));

        mStudentTaskPresenter.initializeClassrooms();

        LinearLayout newHomeworkBtn = (LinearLayout) view.findViewById(R.id.new_homework);
        LinearLayout homeworkAnswerBtn = (LinearLayout) view.findViewById(R.id.answer_homework);
        LinearLayout myHomeworkAnswerBtn = (LinearLayout) view.findViewById(R.id.my_submit);
        newHomeworkBtn.setOnClickListener(this);
        myHomeworkAnswerBtn.setOnClickListener(this);
        homeworkAnswerBtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mStudentTaskPresenter.start();
        mStudentTaskPresenter.startOne();
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

    public void setAdapter(List<Classroom> classroomsList){
        mAdapter = new MyClassroomAdapter(classroomsList);
        mClassroomsRecyclerView.setAdapter(mAdapter);

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
        Intent intent = AddClassroomActivity.newIntent(getActivity());
        startActivity(intent);
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






    private class MyClassroomViewHolder extends RecyclerView.ViewHolder {
        public MyClassroomViewHolder(View itemView) {
            super(itemView);

        }
    }

    private class MyClassroomAdapter extends RecyclerView.Adapter<MyClassroomViewHolder>{
        private List<Classroom> mClassroomList;

        private ImageView mImageView;

        public MyClassroomAdapter(List<Classroom> classroomList){

            mClassroomList = classroomList;
        }

        @Override
        public MyClassroomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_one_classroom_item , parent , false);
            mImageView = (ImageView) view.findViewById(R.id.add_classroom_image_view);
            return new MyClassroomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyClassroomViewHolder holder, int position) {
            /**
             * 显示已经添加好的班级
             */
            if (position != mClassroomList.size()){
                mImageView.setVisibility(View.GONE);
                mImageView.setBackgroundColor(Color.BLACK);
                mImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
            /**
             * 显示+号图标
             */
            if (position==mClassroomList.size()){
                mImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showAddClass();
                    }
                });
            }
        }

        @Override
        public int getItemCount() {

            return mClassroomList.size()+1;
        }
    }
}
