package com.mj.gogo.DesignPattern;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.mj.gogo.DesignPattern.factorymethod.FactoryMethodFragment;
import com.mj.gogo.DesignPattern.singleton.SingletonFragment;
import com.mj.gogo.R;
import com.mj.gogo.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liuwei on 7/20/17.
 */

public class DesignPatternActivity extends BaseActivity {
    @BindView(R.id.vp_container)
    ViewPager vp_container;
    @BindView(R.id.tv_title)
    TextView tv_title;
    private Unbinder mUnbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        mUnbinder = ButterKnife.bind(this);
        SingletonFragment singletonFragment = SingletonFragment.newInstance();
        FactoryMethodFragment factoryMethodFragment = FactoryMethodFragment.newInstance();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(singletonFragment);
        fragments.add(factoryMethodFragment);

        //获取FragmentManager
        FragmentManager fm = getSupportFragmentManager();//v4包中的方法
        vp_container.setAdapter(new DPAdapter(fm, fragments));
        vp_container.addOnPageChangeListener(new DPScrollListener());//设置滑动监听
        vp_container.setCurrentItem(0);
        setTempTitle(0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_designpattern;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    /**
     * FragmentPager适配器，用于viewPager绑定Fragment
     */
    class DPAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragments;

        public DPAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


    /**
     * Viewpager 滑动监听器
     */
    class DPScrollListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * invoked when a new page becomes selected
         */
        @Override
        public void onPageSelected(int position) {
            setTempTitle(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    /**
     * 设置标题
     *
     * @param pos 当前所显示的Fragment
     */
    private void setTempTitle(int pos) {
        String title = null;
        switch (pos) {
            case 0:
                title = getString(R.string.singleton);
                break;
            case 1:
                title = getString(R.string.factory_method);
                break;
        }
        tv_title.setText(title);
    }
}
