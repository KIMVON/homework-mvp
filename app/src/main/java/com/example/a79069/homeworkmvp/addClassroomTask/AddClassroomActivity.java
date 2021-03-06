package com.example.a79069.homeworkmvp.addClassroomTask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.data.source.AppRepository;
import com.example.a79069.homeworkmvp.util.ActivityUtils;

/**
 * Created by 79069 on 2017/3/21.
 */

public class AddClassroomActivity extends AppCompatActivity {
    public static Intent newIntent(Context context){
        Intent intent = new Intent(context , AddClassroomActivity.class);
        return intent;
    }

    private AddClassroomContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = AddClassroomFragment.newInstance();
            ActivityUtils.addFragmentToActivity(fragmentManager , fragment , R.id.fragment_container);
        }

        mPresenter = new AddClassroomPresenter(ActivityUtils.getAppRepository() , (AddClassroomContract.View) fragment);

    }
}
