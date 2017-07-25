package com.mj.gogo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.mj.gogo.DesignPattern.DesignPatternActivity;
import com.mj.gogo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Unbinder mUnbinder;


    @BindView(R.id.bt_fac_mode)
    Button btFacMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btFacMode.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_fac_mode:
                invoke(MainActivity.this, DesignPatternActivity.class);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
