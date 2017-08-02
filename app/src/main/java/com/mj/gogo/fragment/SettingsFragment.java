package com.mj.gogo.fragment;

import android.os.Bundle;
import android.view.View;

import com.mj.gogo.R;
import com.mj.gogo.base.BaseFragment;


/**
 * Created by liuwei on 2/6/17.
 */

public class SettingsFragment extends BaseFragment {

    public static SettingsFragment newInstance(String param1) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int loadFragmentView() {
        return R.layout.fragment_settings;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }
}
