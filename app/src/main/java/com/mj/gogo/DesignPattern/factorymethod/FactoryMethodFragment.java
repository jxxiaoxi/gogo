package com.mj.gogo.DesignPattern.factorymethod;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mj.commonlib.utils.LogUtils;
import com.mj.gogo.R;
import com.mj.gogo.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liuwei on 7/25/17.
 * 用于测试工厂方法模式
 */

public class FactoryMethodFragment extends BaseFragment {
    @BindView(R.id.tv_effect)
    TextView tvEffect;
    @BindView(R.id.tv_virtue)
    TextView tvVirtue;
    @BindView(R.id.tv_defect)
    TextView tvDefect;
    @BindView(R.id.tv_scene)
    TextView tvScene;
    Unbinder unbinder;
    private Unbinder mUnbinder;
    public static final String TAG = FactoryMethodFragment.class.getName();

    public static FactoryMethodFragment newInstance() {
        return new FactoryMethodFragment();
    }

    @Override
    public int loadFragmentView() {
        return R.layout.fragment_factorymethod;
    }

    @Override
    public void initView(View view) {
        mUnbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initData() {
        DrinkMachine drinkMachine = new DrinkMachine();
        Coffee coffee = drinkMachine.makeDrink(Coffee.class);
        LogUtils.e(TAG, coffee.getName());
        Tea tea = drinkMachine.makeDrink(Tea.class);
        LogUtils.e(TAG, tea.getName());
        Coke coke = drinkMachine.makeDrink(Coke.class);
        LogUtils.e(TAG, coke.getName());

        Explain explain = new Explain();
        tvEffect.setText(explain.effect());
        tvVirtue.setText(explain.virtue());
        tvDefect.setText(explain.defect());
        tvDefect.setVisibility(View.GONE);
        tvScene.setText(explain.useScene());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
