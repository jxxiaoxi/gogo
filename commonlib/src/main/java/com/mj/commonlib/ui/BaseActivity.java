package com.mj.commonlib.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by liuwei on 7/19/17.
 */

public abstract class BaseActivity extends FragmentActivity {
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 加载布局前的一些基本设置，如横竖屏，全屏显示等
     */
    protected void setBeforeLayout() {
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * @return 返回布局xml
     */
    protected abstract int getLayoutId();


    /**
     * @param context 当前activity
     * @param clz     跳转到的class
     */
    public void invoke(Context context, Class clz) {
        startActivity(new Intent(context, clz));
    }

    /**
     * @param str 需要显示的提示语
     */
    public void showToast(final String str) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
