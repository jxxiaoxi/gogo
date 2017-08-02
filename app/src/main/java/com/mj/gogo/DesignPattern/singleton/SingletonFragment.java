package com.mj.gogo.DesignPattern.singleton;

import android.view.View;
import android.widget.TextView;

import com.mj.commonlib.utils.LogUtils;
import com.mj.gogo.R;
import com.mj.gogo.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liuwei on 7/21/17.
 */

public class SingletonFragment extends BaseFragment {

    @BindView(R.id.tv_effect)
    TextView tvEffect;
    @BindView(R.id.tv_virtue)
    TextView tvVirtue;
    @BindView(R.id.tv_defect)
    TextView tvDefect;
    private Unbinder mUnbinder;

    public static SingletonFragment newInstance() {
        return new SingletonFragment();
    }

    @Override
    public int loadFragmentView() {
        return R.layout.fragment_singleton;
    }

    @Override
    public void initView(View view) {
        mUnbinder = ButterKnife.bind(this, view);
        //initData();
    }

    @Override
    public void initData() {
        //获取Singleton的实例
        Singleton singleton = Singleton.getInstance();
        tvEffect.setText(singleton.effect());
        tvVirtue.setText(singleton.virtue());
        tvDefect.setText(singleton.defect());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
