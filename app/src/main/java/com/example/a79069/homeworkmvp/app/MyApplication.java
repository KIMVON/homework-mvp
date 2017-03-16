package com.example.a79069.homeworkmvp.app;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by 79069 on 2017/3/15.
 */

public class MyApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LitePal.initialize(this);
    }

    public static Context getContext(){
        return mContext;
    }
}
