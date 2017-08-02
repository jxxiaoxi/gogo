package com.mj.gogo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mj.commonlib.wedgit.bottomnavigation.BottomNavigationBar;
import com.mj.commonlib.wedgit.bottomnavigation.BottomNavigationItem;
import com.mj.gogo.base.BaseActivity;
import com.mj.gogo.fragment.BookFragment;
import com.mj.gogo.fragment.HomeFragment;
import com.mj.gogo.fragment.SettingsFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    private Unbinder mUnbinder;

    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUnbinder = ButterKnife.bind(this);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
       // bottomNavigationBar.set
        refresh();
        setDefaultFragment();
    }

    private void refresh() {
        bottomNavigationBar.clearAll();
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "home"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "book"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "settings")).initialise();
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment homeFragment = HomeFragment.newInstance("home");
        fragmentTransaction.replace(R.id.fl_fragment, homeFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                Fragment homeFragment = HomeFragment.newInstance("home");
                fragmentTransaction.replace(R.id.fl_fragment, homeFragment);
                break;
            case 1:
                Fragment bookFragment = BookFragment.newInstance("book");
                fragmentTransaction.replace(R.id.fl_fragment, bookFragment);
                break;
            case 2:
                Fragment settingsFragment = SettingsFragment.newInstance("settings");
                fragmentTransaction.replace(R.id.fl_fragment, settingsFragment);
                break;
        }
        //提交事务
        fragmentTransaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
