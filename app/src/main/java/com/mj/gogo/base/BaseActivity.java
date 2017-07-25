package com.mj.gogo.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mj.commonlib.ui.ABSBaseActivity;

/**
 * Created by liuwei on 7/21/17.
 */

public abstract class BaseActivity extends ABSBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setOrientation(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 设置activity横屏还是竖屏显示，默认竖屏显示
     *
     * @param isLand 是否横屏
     */
    public void setOrientation(boolean isLand) {
        if (isLand) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//默认竖屏
        }
    }
}
