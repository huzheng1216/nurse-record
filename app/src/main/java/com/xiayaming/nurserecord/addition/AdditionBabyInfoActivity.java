package com.xiayaming.nurserecord.addition;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.xiayaming.nurserecord.R;
import com.xiayaming.nurserecord.base.BaseActivity;
import com.xiayaming.nurserecord.db.DataBaseManager;
import com.xiayaming.nurserecord.javabean.Baby;

import org.greenrobot.eventbus.EventBus;

import java.util.Date;

/**
 * Created by 37399 on 2017/1/11.
 */
public class AdditionBabyInfoActivity extends BaseActivity {

    private EditText name;
    private EditText birth;
    private RadioGroup gender;

    @Override
    protected void initView() {
        setContentView(R.layout.addition_main);
        name = (EditText) findViewById(R.id.addition_name);
        birth = (EditText) findViewById(R.id.addition_birth);
        gender = (RadioGroup) findViewById(R.id.radioGroup);
    }

    @Override
    protected void initParam() {

    }

    @Override
    protected void initData() {

    }

    public void add(View view){
        Baby baby = new Baby();
        baby.setName(name.getText().toString());
        baby.setCrite(new Date());
        baby.setGender(gender.getCheckedRadioButtonId()==R.id.btnMan?0:1);
        DataBaseManager.getDataBaseManager(this).addBabyInfo(baby);
        EventBus.getDefault().post(this);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
