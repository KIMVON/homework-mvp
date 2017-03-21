package com.example.a79069.homeworkmvp.studentMainTask;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a79069.homeworkmvp.R;
import com.example.a79069.homeworkmvp.data.People;
import com.example.a79069.homeworkmvp.studentMainTask.Fragment.FourFragment;
import com.example.a79069.homeworkmvp.studentMainTask.Fragment.OneFragment;
import com.example.a79069.homeworkmvp.studentMainTask.Fragment.ThreeFragment;
import com.example.a79069.homeworkmvp.studentMainTask.Fragment.TwoFragment;
import com.example.a79069.homeworkmvp.util.ActivityUtils;
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by 79069 on 2017/3/14.
 */

public class StudentTaskActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String PEOPLE = "com.example.a79069.homeworkmvp.studentMainTask.people";

    private List<StudentTaskContract.View> mFragmentList;
    private List<String> mIconNameList;
    private List<Integer> mIconDefaultImageIdList;
    private List<Integer> mIconImageIdList;
    private StudentTaskPresenter mPresenter;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private TextView mUserName;
    private ImageView mImageView;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context , StudentTaskActivity.class);
//        intent.putExtra(PEOPLE , people);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (mainToolbar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.toolbar_home);
        }

        mDrawerLayout = (DrawerLayout)findViewById(R.id.start_draw_layout);

        /**
         * 获取navigation
         */
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        View headerView = mNavigationView.getHeaderView(0);
        mUserName = (TextView) headerView.findViewById(R.id.user_name);
        mImageView = (ImageView) headerView.findViewById(R.id.person_head_image);

        ViewPager viewPager = (ViewPager) findViewById(R.id.fragment_viewpager);
        AdvancedPagerSlidingTabStrip tabStrip = (AdvancedPagerSlidingTabStrip) findViewById(R.id.tab_strip);


        FragmentManager fragmentManager = getSupportFragmentManager();
        initArrayList();

        mPresenter = new StudentTaskPresenter(ActivityUtils.getAppRepository() , mFragmentList);
        mPresenter.initializeName(this);




        FragmentAdapter fragmentAdapter = new FragmentAdapter(fragmentManager , mFragmentList , mIconImageIdList , mIconDefaultImageIdList , mIconNameList);
        viewPager.setAdapter(fragmentAdapter);
        tabStrip.setViewPager(viewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_menu_person_info:
                break;
            case R.id.nav_menu_history_homework:
                break;
        }
        return false;
    }

    public void showUserName(String name){
        mUserName.setText(name);
    }

    public void setNavigationView(String name , String url){
        mUserName.setText(name);
        Glide.with(this).load(url).into(mImageView);
    }


    public void initArrayList(){
        OneFragment oneFragment = OneFragment.newInstance();
        TwoFragment twoFragment = TwoFragment.newInstance();
        ThreeFragment threeFragment = ThreeFragment.newInstance();
        FourFragment fourFragment = FourFragment.newInstance();

        mFragmentList = new ArrayList<>();
        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
        mFragmentList.add(threeFragment);
        mFragmentList.add(fourFragment);

        mIconNameList = new ArrayList<>();
        mIconNameList.add("主页");
        mIconNameList.add("信息");
        mIconNameList.add("好友");
        mIconNameList.add("动态");

        mIconImageIdList = new ArrayList<>();
        mIconImageIdList.add(R.drawable.menu_home);
        mIconImageIdList.add(R.drawable.menu_message);
        mIconImageIdList.add(R.drawable.menu_friends);
        mIconImageIdList.add(R.drawable.menu_moving);

        mIconDefaultImageIdList = new ArrayList<>();
        mIconDefaultImageIdList.add(R.drawable.menu_home_default);
        mIconDefaultImageIdList.add(R.drawable.menu_message_default);
        mIconDefaultImageIdList.add(R.drawable.menu_friends_defalut);
        mIconDefaultImageIdList.add(R.drawable.menu_moving_default);
    }

    private class FragmentAdapter extends FragmentStatePagerAdapter
            implements AdvancedPagerSlidingTabStrip.IconTabProvider{
        private List<StudentTaskContract.View> mFragmentList;
        private List<String> mIconNameList;
        private List<Integer> mIconImageIdList;
        private List<Integer> mIconDefaultImageIdList;
        public FragmentAdapter(FragmentManager fm
                , List<StudentTaskContract.View> fragmentList
                , List<Integer> iconImageIdList
                , List<Integer> iconDefaultImageIdList
                , List<String> iconNameList)
        {
            super(fm);
            mFragmentList = fragmentList;
            mIconImageIdList = iconImageIdList;
            mIconDefaultImageIdList = iconDefaultImageIdList;
            mIconNameList = iconNameList;
        }


        @Override
        public Fragment getItem(int position) {
            return (Fragment) mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        @Override
        public <Integer> Integer getPageIcon(int position) {
            return (Integer) mIconDefaultImageIdList.get(position);
        }

        @Override
        public <Integer> Integer getPageSelectIcon(int position) {
            return (Integer) mIconImageIdList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mIconNameList.get(position);
        }

        @Override
        public Rect getPageIconBounds(int position) {
            return null;
        }


    }
}
