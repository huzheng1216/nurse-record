package com.xiayaming.nurserecord.baby;

import android.view.View;
import android.widget.ListView;

import com.xiayaming.nurserecord.R;
import com.xiayaming.nurserecord.base.BaseActivity;
import com.xiayaming.nurserecord.db.DataBaseManager;
import com.xiayaming.nurserecord.javabean.Baby;
import com.xiayaming.nurserecord.javabean.Record;

import java.util.Calendar;

/**
 * Created by 37399 on 2017/1/14.
 */
public class BabyInfoActivity extends BaseActivity {

    private ListView listView;
    private BabyInfoAdapter adapter;
    private Baby baby;

    @Override
    protected void initView() {
        setContentView(R.layout.baby_main);
        listView = (ListView) findViewById(R.id.baby_listview);
        baby = DataBaseManager.getDataBaseManager(this).getBabyInfo(getIntent().getLongExtra("id", 1));
        BabyInfoAdapter adapter = new BabyInfoAdapter(this, baby.getRecords());
        listView.setAdapter(adapter);
    }

    @Override
    protected void initParam() {
    }

    @Override
    protected void initData() {

    }

    /** 添加母乳记录 **/
    public void addBreastMilk(View view){

    }

    /** 添加奶粉记录 **/
    public void addMilk(View view){
        Record r = new Record();
        r.setName("美赞臣");
        r.setCount(150);
        Calendar c = Calendar.getInstance();
        r.setYear(c.get(Calendar.YEAR));
        r.setMoonth(c.get(Calendar.MONTH));
        r.setDay(c.get(Calendar.DAY_OF_MONTH));
        r.setId(baby.getId());
        r.setType(1);

    }
}
