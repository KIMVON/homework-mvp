package com.example.a79069.homeworkmvp.loginTask;

import static com.google.common.base.Preconditions.checkNotNull;
import com.example.a79069.homeworkmvp.data.People;
import com.example.a79069.homeworkmvp.data.source.AppRepository;
import com.example.a79069.homeworkmvp.data.source.TasksDataSource;

/**
 * Created by 79069 on 2017/3/16.
 */

public class LoginTaskPresenter implements LoginTaskContract.Presenter {
    private LoginTaskContract.View mLoginFragmentView;
    private AppRepository mAppRepository;

    public LoginTaskPresenter(AppRepository appRepository , LoginTaskContract.View loginFragmentView){
        mAppRepository = checkNotNull(appRepository , "");
        mLoginFragmentView = checkNotNull(loginFragmentView , "");

        mLoginFragmentView.setPresenter(this);
    }

    @Override
    public void loginApp(final String account, final String password, final String peopleType, final Boolean isRemember) {
        mAppRepository.queryLoginAccountInfo(account, new TasksDataSource.GetPeopleCallback() {
            @Override
            public void loadPeople(People people) {
                if (people.getAccount().equals(account)
                        &&people.getPassword().equals(password)
                        &&people.getPeopleType().equals(peopleType)){
                    saveAccountInSharePreferences(account);
                    if (isRemember){
                        savePasswordInSharePreferences(password);
                        saveIsRememberInSharePreferences(true);
                    }else {
                        deletePasswordInSharePreferences();
                    }
                    if (peopleType.equals("学生类型")) {
                        mLoginFragmentView.loginSuccess();
                    }else if (peopleType.equals("家长类型")){

                    }else if (peopleType.equals("教师类型")){

                    }
                    mLoginFragmentView.closeActivity();
                }
            }

            @Override
            public void onDataNotAvailable() {
                mLoginFragmentView.loginFailed();
            }
        });
    }

    @Override
    public void start() {

    }



    /**
     * SharaPreference的相关操作
     * **/
    public void saveAccountInSharePreferences(String account){
        mAppRepository.saveAccountInSharePreferences(account);
    }

    public String getAccountInSharePreferences(){
        return  mAppRepository.getAccountInSharePreferences();
    }

    public void savePasswordInSharePreferences(String password){
        mAppRepository.savePasswordInSharePreferences(password);
    }

    public String getPasswordInSharePreferences(){
        return mAppRepository.getPasswordInSharePreferences();
    }

    public void deletePasswordInSharePreferences(){
        mAppRepository.deletePasswordInSharePreference();
    }

    public void saveIsRememberInSharePreferences(Boolean isRemember){
        mAppRepository.saveIsRememberInSharePreferences(isRemember);
    }

    public boolean getIsRememberInSharePreferences(){
        return mAppRepository.getIsRememberInSharePreferences();
    }
}
