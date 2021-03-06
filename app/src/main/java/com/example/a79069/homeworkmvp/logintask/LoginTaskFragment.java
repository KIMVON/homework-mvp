package com.example.a79069.homeworkmvp.loginTask;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.TextView;

import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.data.Classroom;
import com.example.a79069.homeworkmvp.data.People;
import com.example.a79069.homeworkmvp.forgetTask.ForgetActivity;
import com.example.a79069.homeworkmvp.registerTask.RegisterActivity;
import com.example.a79069.homeworkmvp.studentMainTask.StudentTaskActivity;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

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
    private TextView mRegisterTextView;
    private TextView mForgetTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        addDATA();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login , container , false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_login);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        /**
         * 初始化Spinner
         */
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

        mRegisterTextView = (TextView) view.findViewById(R.id.register_account);
        mRegisterTextView.setOnClickListener(this);

        mForgetTextView = (TextView) view.findViewById(R.id.forget_password);
        mForgetTextView.setOnClickListener(this);

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
    public void onResume() {
        super.onResume();
        mLoginPresenter.start();
    }

    @Override
    public void setPresenter(LoginTaskContract.Presenter presenter) {
        mLoginPresenter = (LoginTaskPresenter) presenter;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                /** 测试先不用
                 **/
                mLoginPresenter.loginApp(account.getText().toString()
                        , password.getText().toString() , mSelectType , remCheckBox.isChecked());
                /**
                 * 测试用
                loginSuccess();
                 */
                break;
            case R.id.register_account:
                showRegisteredActivity();
                break;
            case R.id.forget_password:
                showForgetActivity();
                break;
        }
    }

    /**
     * 登陆成功
     */
    @Override
    public void loginSuccess() {
        Intent intent = StudentTaskActivity.newIntent(getActivity());
        startActivity(intent);
    }


    /**
     * 登陆失败
     */
    @Override
    public void loginFailed() {
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

    /**
     * 进入注册页面
     */
    @Override
    public void showRegisteredActivity() {
        Intent intent = RegisterActivity.newIntent(getActivity());
        startActivity(intent);
    }

    /**
     * 进入忘记密码界面
     */
    @Override
    public void showForgetActivity() {
        Intent intent = ForgetActivity.newIntent(getActivity());
        startActivity(intent);
    }

    /**
     * 关闭页面
     */
    @Override
    public void closeActivity() {
        getActivity().finish();
    }
}
