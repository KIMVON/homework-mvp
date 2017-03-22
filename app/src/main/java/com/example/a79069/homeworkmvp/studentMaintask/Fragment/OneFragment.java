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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.View.FullyGridLayoutManager;
import com.example.a79069.homeworkmvp.addClassroomTask.AddClassroomActivity;
import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.myClassroomDetailsTask.MyClassroomDetailsActivity;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskContract;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskPresenter;

import org.w3c.dom.Text;

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


//        mClassroomsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 3){
//
//
//
//
//            /**
//             * 禁止滑动
//             * @param recycler
//             * @param state
//             * @param widthSpec
//             * @param heightSpec
//
//            @Override
//            public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
//                super.onMeasure(recycler, state, widthSpec, heightSpec);
//                int measuredWidth = mClassroomsRecyclerView.getMeasuredWidth();
//                int measuredHeight = mClassroomsRecyclerView.getMeasuredHeight();
//                int myMeasureHeight = 0;
//                int count = state.getItemCount();
//                for (int i = 0; i < count; i++) {
//                    View view = recycler.getViewForPosition(i);
//                    if (view != null) {
//                        if (myMeasureHeight < measuredHeight && i % 3 == 0) {
//                            RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
//                            int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec,
//                                    getPaddingLeft() + getPaddingRight(), p.width);
//                            int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
//                                    getPaddingTop() + getPaddingBottom(), p.height);
//                            view.measure(childWidthSpec, childHeightSpec);
//                            myMeasureHeight += view.getMeasuredHeight() + p.bottomMargin + p.topMargin;
//                        }
//                        recycler.recycleView(view);
//                    }
//                }
//                // Log.i("Height", "" + Math.min(measuredHeight, myMeasureHeight));
//                setMeasuredDimension(measuredWidth, Math.min(measuredHeight, myMeasureHeight));
//            }
//            */
//        });

        /**
         * 重写完之后，用就好说了，在adapter的onBindview和平常一样用就可以了
         * 这个要这样
         */
        final FullyGridLayoutManager manager = new FullyGridLayoutManager(getActivity(), 3);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        manager.setSmoothScrollbarEnabled(true);
        mClassroomsRecyclerView.setLayoutManager(manager);




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
        Intent intent = MyClassroomDetailsActivity.newIntent(getActivity());
        startActivity(intent);
    }


    @Override
    public void showHistoryHomework() {

    }






    private class MyClassroomViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private ImageView mRedPoint;
        private TextView mClassroomName;

        public MyClassroomViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.add_classroom_image_view);
            mClassroomName = (TextView) itemView.findViewById(R.id.class_name);
            mRedPoint = (ImageView) itemView.findViewById(R.id.red_point);
        }


        void bindView(List<Classroom> mClassroomList, int position){

            /**
             * 显示已经添加好的班级
             */
            if (position != mClassroomList.size()){
//                mImageView.setVisibility(View.GONE);
                Glide.with(getActivity()).load(R.mipmap.ic_launcher).into(mImageView);
                mImageView.setBackgroundColor(Color.BLACK);
                mImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showMyClassroomInfo();
                    }
                });
            }

            /**
             * 显示+号图标
             */
            if (position==mClassroomList.size()){
                mRedPoint.setVisibility(View.GONE);
                mClassroomName.setVisibility(View.GONE);
                mImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showAddClass();
                    }
                });
            }
        }


    }

    private class MyClassroomAdapter extends RecyclerView.Adapter<MyClassroomViewHolder>{
        private List<Classroom> mClassroomList;

//        private ImageView mImageView;
//        private ImageView mRedPoint;
//        private TextView mClassroomName;

        public MyClassroomAdapter(List<Classroom> classroomList){
            mClassroomList = classroomList;
        }


        @Override
        public MyClassroomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_one_classroom_item , parent , false);
//            mImageView = (ImageView) view.findViewById(R.id.add_classroom_image_view);
//            mClassroomName = (TextView) view.findViewById(R.id.class_name);
//            mRedPoint = (ImageView) view.findViewById(R.id.red_point);

            return new MyClassroomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyClassroomViewHolder holder, int position) {
            holder.bindView(mClassroomList,position);
//            /**
//             * 显示已经添加好的班级
//             */
//            if (position != mClassroomList.size()){
////                mImageView.setVisibility(View.GONE);
//                Glide.with(getActivity()).load(R.mipmap.ic_launcher).into(mImageView);
//                mImageView.setBackgroundColor(Color.BLACK);
//                mImageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        showMyClassroomInfo();
//                    }
//                });
//            }
//
//            /**
//             * 显示+号图标
//             */
//            if (position==mClassroomList.size()){
//                mRedPoint.setVisibility(View.GONE);
//                mClassroomName.setVisibility(View.GONE);
//                mImageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        showAddClass();
//                    }
//                });
//            }

        }

        @Override
        public int getItemCount() {

            return mClassroomList.size()+1;
        }
    }
}
