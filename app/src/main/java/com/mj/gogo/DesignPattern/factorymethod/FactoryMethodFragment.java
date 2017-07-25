package com.mj.gogo.DesignPattern.factorymethod;

import android.view.View;

import com.mj.gogo.DesignPattern.singleton.SingletonFragment;
import com.mj.gogo.R;
import com.mj.gogo.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liuwei on 7/25/17.
 * 用于测试工厂方法模式
 */

public class FactoryMethodFragment extends BaseFragment {
    private Unbinder mUnbinder;

    public static FactoryMethodFragment newInstance() {
        return new FactoryMethodFragment();
    }

    @Override
    public int loadContentView() {
        return R.layout.fragment_factorymethod;
    }

    @Override
    public void initView(View view) {
        mUnbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
