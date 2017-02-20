package com.xiayaming.nurserecord.baby;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xiayaming.nurserecord.R;
import com.xiayaming.nurserecord.javabean.Record;

import java.util.List;

/**
 * Created by 37399 on 2017/1/14.
 */
public class BabyInfoAdapter extends BaseAdapter {

    private Context context;
    private List<Record> data;

    public BabyInfoAdapter(Context context, List<Record> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Record getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder myViewHolder = null;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.baby_item, null);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        Record record = getItem(position);
        StringBuilder sb = new StringBuilder();
        sb.append("日期：").append(record.getYear()).append("年").append(record.getMoonth()).append("月").append(record.getDay()).append("日")
                .append(" - ").append("奶量：").append(record.getCount())
                .append(" - ").append("时长：").append(record.getStart()).append("结束时间：").append(record.getEnd())
                .append(" - ").append("类型：").append(record.getType()==0?"母乳":"奶粉");
        myViewHolder.tv.setText(sb.toString());
        return convertView;
    }

    class MyViewHolder{
        private TextView tv;

        public MyViewHolder(View root){
            this.tv = (TextView) root.findViewById(R.id.baby_item_info);
        }
    }
}
