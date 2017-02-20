package com.xiayaming.nurserecord;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xiayaming.nurserecord.addition.AdditionBabyInfoActivity;
import com.xiayaming.nurserecord.baby.BabyInfoActivity;
import com.xiayaming.nurserecord.base.BaseActivity;
import com.xiayaming.nurserecord.db.DataBaseManager;
import com.xiayaming.nurserecord.javabean.Baby;
import com.xiayaming.nurserecord.tools.LogTools;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ListView listview;
    private ArrayAdapter adapter;
    private List<String> list;
    private List<Baby> babys;

    @Override
    protected void initView() {

        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        listview = (ListView) findViewById(R.id.listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, BabyInfoActivity.class);
                intent.putExtra("id", babys.get(position).getId());
                MainActivity.this.startActivity(intent);
            }
        });
        list = getData();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
    }

    public List<String> getData(){
        babys = DataBaseManager.getDataBaseManager(this).getBabyList();
        List<String> list = new ArrayList<>();
        for(Baby b : babys){
            list.add(b.getName());
        }
        return list;
    }

    @Override
    protected void initParam() {

    }

    @Override
    protected void initData() {
        LogTools.showLogH(""+new Date());
    }

    public void add(View view){
        startActivity(this, AdditionBabyInfoActivity.class);
    }


    @Subscribe
    public void onEventMainThread(Activity activity) {
        List<String> l = getData();
        for(String s : l){
            if(list.contains(s)) continue;
            list.add(s);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
