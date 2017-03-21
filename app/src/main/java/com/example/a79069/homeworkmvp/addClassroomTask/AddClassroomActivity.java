package com.example.a79069.homeworkmvp.addClassroomTask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 79069 on 2017/3/21.
 */

public class AddClassroomActivity extends AppCompatActivity {
    public static Intent newIntent(Context context){
        Intent intent = new Intent(context , AddClassroomActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
