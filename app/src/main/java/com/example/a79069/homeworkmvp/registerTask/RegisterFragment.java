package com.example.a79069.homeworkmvp.registerTask;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a79069.homeworkmvp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79069 on 2017/3/16.
 */

public class RegisterFragment extends Fragment implements RegisterContract.View, View.OnClickListener {
    private RegisterContract.Presenter mPresenter;

    public static Fragment newInstance(){
        return new RegisterFragment();
    }


    private EditText mRegisterAccount;
    private EditText mRegisterPassword;
    private EditText mRegisterPasswordAgain;
    private EditText mRegisterName;
    private EditText mRegisterYear;
    private EditText mRegisterSex;

    private Button mRegisterButton;

    private Spinner mRegisterSpinner;

    private List<String> mSpinnerList = new ArrayList<>();
    private ArrayAdapter<String> mArrayAdapter;
    private String mSelectSpinnerType;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register , container , false);

        mRegisterAccount = (EditText) view.findViewById(R.id.register_account);
        mRegisterPassword = (EditText) view.findViewById(R.id.register_password);
        mRegisterPasswordAgain = (EditText) view.findViewById(R.id.register_password_again);
        mRegisterName = (EditText) view.findViewById(R.id.register_name);
        mRegisterYear = (EditText) view.findViewById(R.id.register_year);
        mRegisterSex = (EditText) view.findViewById(R.id.register_sex);

        mRegisterSpinner = (Spinner) view.findViewById(R.id.register_spinner);
        mSpinnerList.add("学生类型");
        mSpinnerList.add("家长类型");
        mSpinnerList.add("教师类型");

        mArrayAdapter = new ArrayAdapter(getActivity()
                , android.R.layout.simple_spinner_item , mSpinnerList);
        mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mRegisterSpinner.setAdapter(mArrayAdapter);
        mRegisterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mSelectSpinnerType =  mArrayAdapter.getItem(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        mRegisterButton = (Button) view.findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_button:
                registerAccount();
                break;
        }
    }




    @Override
    public void closeActivity() {
        getActivity().finish();
    }


    /**
     * 点击登陆
     */
    @Override
    public void registerAccount() {
        String registerAccount = mRegisterAccount.getText().toString();
        String registerPassword = mRegisterPassword.getText().toString();
        String registerPasswordAgain = mRegisterPasswordAgain.getText().toString();
        String registerName = mRegisterName.getText().toString();
        String registerSex = mRegisterSex.getText().toString();
        String registerYear = mRegisterYear.getText().toString();
        String registerType =mSelectSpinnerType;

        if ((!registerAccount.equals(""))&&
                (!registerPassword.equals(""))&&
                (!registerPasswordAgain.equals(""))&&
                (!registerName.equals(""))&&
                (!registerSex.equals(""))&&
                (!registerYear.equals(""))&&
                (!registerType.equals(""))&&
                registerPassword.equals(registerPasswordAgain)
                ){
            mPresenter.registerUserInfo(registerAccount , registerPassword , registerName , registerSex , Integer.parseInt(registerYear) , registerType );
        }else {
            registerFailed(registerAccount , registerPassword ,registerPasswordAgain ,registerName , registerSex , registerYear , registerType );
        }
    }

    /**
     * 登陆成功
     */
    @Override
    public void registerSuccess() {
        showAlertDialog("恭喜", "注册成功", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                closeActivity();
            }
        });
    }
    @Override
    public void registerFailed(String account , String password , String passwordAgain ,
                               String name , String sex , String year , String userType) {
        if (account.equals("")||
                password.equals("")||
                passwordAgain.equals("")||
                name.equals("")||
                sex.equals("")||
                year.equals("")||
                userType.equals("")
                ){

            showAlertDialog("Error" , "不能留空，请填写所有信息" , null);

        }else if (!password.equals(passwordAgain)){
            Toast.makeText(getActivity(), password+"+++"+passwordAgain, Toast.LENGTH_SHORT).show();
            showAlertDialog("Error" , "两次输入密码不相同，请重新输入" , null);
        }
    }

    @Override
    public void showAlertDialog(String title , String message , DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("确定",listener);
        builder.show();
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = presenter;
    }

}
