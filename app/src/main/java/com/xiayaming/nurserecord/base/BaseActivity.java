package com.xiayaming.nurserecord.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by 37399 on 2017/1/11.
 */
public abstract class BaseActivity extends Activity {

    private long lastClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initParam();
        initData();
    }

    public static void startActivity(Activity activity,Class c){
        activity.startActivity(new Intent(activity, c));
    }

    @Override
    public void startActivity(Intent intent) {
        if(Math.abs(System.currentTimeMillis() - lastClick)<1000)
        {
            return;
        }
        lastClick = System.currentTimeMillis();
        super.startActivity(intent);
    }

    /**
     * 初始化界面
     */
    protected abstract void initView();


    /**
     * 初始化全局变量
     */
    protected abstract void initParam();

    /**
     * 准备数据
     */
    protected abstract void initData();
}
