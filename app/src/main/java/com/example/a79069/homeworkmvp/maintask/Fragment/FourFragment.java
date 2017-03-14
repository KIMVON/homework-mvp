package com.example.a79069.homeworkmvp.maintask.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a79069.homeworkmvp.R;

/**
 * Created by 79069 on 2017/3/14.
 */

public class FourFragment extends Fragment {
    public static FourFragment newInstance(){
        return new FourFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four , container , false);
        return view;
    }
}
