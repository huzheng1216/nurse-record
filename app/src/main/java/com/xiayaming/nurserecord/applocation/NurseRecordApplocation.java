package com.xiayaming.nurserecord.applocation;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.xiayaming.nurserecord.config.AppConfig;
import com.xiayaming.nurserecord.db.DataBaseManager;
import com.xiayaming.nurserecord.system.DeviceConfig;

/**
 * Created by 37399 on 2017/1/11.
 */
public class NurseRecordApplocation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化手机配置参数
        DeviceConfig.initScreenSize(this);
        DeviceConfig.initDeviceData(this);
        //初始化crash捕获以及版本升级
//        Bugly.init(getApplicationContext(), "727a95f6b1", AppConfig.DEBUG);
        //初始化内存监测
//        refWatcher = LeakCanary.install(this);
        //初始化图片框架
//        Fresco.initialize(this);
        //初始化数据库
        DataBaseManager.getDataBaseManager(this);
    }
}
