package com.mj.gogo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mj.gogo.DesignPattern.DesignPatternActivity;
import com.mj.gogo.R;
import com.mj.gogo.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by liuwei on 2/6/17.
 */

public class BookFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.bt_fac_mode)
    Button btFacMode;
    private Unbinder mUnbinder;

    public static BookFragment newInstance(String param1) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int loadFragmentView() {
        return R.layout.fragment_book;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void initData() {
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_fac_mode:
                Log.e("mijie"," bt_fac_mode");
                startActivity(new Intent(getActivity(), DesignPatternActivity.class));
        }
    }

    @OnClick(R.id.bt_fac_mode)
    public void onViewClicked() {
    }
}
