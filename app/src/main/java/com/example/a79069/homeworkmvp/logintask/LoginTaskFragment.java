package com.example.a79069.homeworkmvp.logintask;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.maintask.MainTaskActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79069 on 2017/3/16.
 */

public class LoginTaskFragment extends Fragment implements LoginTaskContract.View, View.OnClickListener {
    public static LoginTaskFragment newInstance(){
        return new LoginTaskFragment();
    }

    private LoginTaskPresenter mLoginPresenter;
    private String mSelectType;
    private Boolean isRemember;
    private EditText account;
    private EditText password;
    private List<String> spinnerList = new ArrayList<>();
    private ArrayAdapter arrayAdapter;
    private CheckBox remCheckBox;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login , container , false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tool_inlogin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        Spinner selectSpinner = (Spinner) view.findViewById(R.id.spinner);
        spinnerList.add("学生类型");
        spinnerList.add("家长类型");
        spinnerList.add("教师类型");
        arrayAdapter = new ArrayAdapter(getActivity()
                , android.R.layout.simple_spinner_item , spinnerList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectSpinner.setAdapter(arrayAdapter);
        selectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mSelectType = (String) arrayAdapter.getItem(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        account = (EditText) view.findViewById(R.id.person_account);
        password  = (EditText)view.findViewById(R.id.person_password);
        Button loginButton = (Button) view.findViewById(R.id.login);
        loginButton.setOnClickListener(this);




        isRemember = mLoginPresenter.getIsRememberInSharePreferences();
        account.setText(mLoginPresenter.getAccountInSharePreferences());


        remCheckBox = (CheckBox) view.findViewById(R.id.checkbox_remember);
        if (isRemember){
            remCheckBox.setChecked(true);
            password.setText(mLoginPresenter.getPasswordInSharePreferences());
        }




        return view;
    }

    @Override
    public void setPresenter(LoginTaskContract.Presenter presenter) {
        mLoginPresenter = (LoginTaskPresenter) presenter;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                mLoginPresenter.loginApp(account.getText().toString()
                        , password.getText().toString() , mSelectType , remCheckBox.isChecked());
                break;
        }
    }


    @Override
    public void showMainActivityTask() {
        Intent intent = MainTaskActivity.newIntent(getActivity());
        startActivity(intent);
    }

    @Override
    public void showRegisteredActivityTask() {

    }

    @Override
    public void showForgetActivityTask() {

    }

    @Override
    public void closeActivity() {
        getActivity().finish();
    }

    @Override
    public void showDialogForFaultLogin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle("Error");
        builder.setMessage("你输入的账号或者密码不对，无法登陆");
        builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                account.setText("");
                password.setText("");
            }
        });
        builder.show();
    }

}
