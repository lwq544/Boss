package com.lwq.boss.application;

import android.app.Application;

import com.lwq.boss.utils.StaticClass;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2018/11/4.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Bmob
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);



    }
}
