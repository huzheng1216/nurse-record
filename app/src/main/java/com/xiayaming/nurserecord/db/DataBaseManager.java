package com.xiayaming.nurserecord.db;

import android.app.Activity;
import android.content.Context;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.xiayaming.nurserecord.javabean.Baby;
import com.xiayaming.nurserecord.javabean.Record;
import com.xiayaming.nurserecord.system.TelephonyManagerTools;

import java.util.List;

/**
 * 数据库业务处理
 * Created by 37399 on 2017/1/11.
 */
public class DataBaseManager {

    private static LiteOrm liteOrm;

    public static volatile DataBaseManager dataBaseManager = null;
    private DataBaseManager(Context context){
        if (liteOrm == null) {
            DataBaseConfig config = new DataBaseConfig(context, TelephonyManagerTools.getSDCardPath() + "/nurserecord/baby.db");
            //"liteorm.db"是数据库名称，名称里包含路径符号"/"则将数据库建立到该路径下，可以使用sd卡路径。 不包含则在系统默认路径下创建DB文件。
            //例如 public static final String DB_NAME = SD_CARD + "/lite/orm/liteorm.db";     DataBaseConfig config = new DataBaseConfig(this, DB_NAME);
            config.dbVersion = 1; // set database version
            config.onUpdateListener = null; // set database update listener
            //独立操作，适用于没有级联关系的单表操作，
//            liteOrm = LiteOrm.newSingleInstance(config);
            //级联操作,适用于多表级联操作
             liteOrm=LiteOrm.newCascadeInstance(config);
        }
        liteOrm.setDebugged(true); // open the log
    }
    public static DataBaseManager getDataBaseManager(Context context){
        synchronized (DataBaseManager.class){
            if(dataBaseManager==null){
                dataBaseManager = new DataBaseManager(context);
            }
            return dataBaseManager;
        }
    }

    /**
     * 获取宝宝列表
     * @return
     */
    public List<Baby> getBabyList(){
        return liteOrm.single().query(Baby.class);
    }

    /**
     * 添加宝宝信息
     * @param baby
     */
    public void addBabyInfo(Baby baby){
        liteOrm.cascade().save(baby);
    }

    /**
     * 获取宝贝喂奶记录
     * @return
     */
    public Baby getBabyInfo(long id){
        return liteOrm.cascade().queryById(id, Baby.class);
    }




}
