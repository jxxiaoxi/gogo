package com.mj.commonlib.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liuwei on 7/21/17.
 */

public abstract class ABSBaseFragment extends Fragment {
    public Context mContext;
    //Fragment的View加载完毕的标记
    private boolean isViewCreated;

    //Fragment对用户可见的标记
    private boolean isUIVisible;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    /**
     * 创建fragment视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return 视图view
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(loadContentView(), container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        loadData();
    }

    private void loadData() {
        if (isViewCreated && isUIVisible) {
            initData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }

    /**
     * @param isVisibleToUser ui是否对用户可见
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            loadData();
        } else {
            isUIVisible = false;
        }
    }

    /**
     * 加载视图
     *
     * @retur 返回Fragment显示的视图
     */
    public abstract int loadContentView();

    /**
     * 初始化视图，在这个方法中可以操作每一个控件。
     *
     * @param view
     */
    public abstract void initView(View view);

    /**
     * 初始化数据
     */
    public abstract void initData();
}
