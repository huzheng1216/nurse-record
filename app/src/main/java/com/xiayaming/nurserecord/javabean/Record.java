package com.xiayaming.nurserecord.javabean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

import java.util.Date;

/**
 * 喂奶记录
 * Created by 37399 on 2017/1/11.
 */
@Table("record")
public class Record {

    @PrimaryKey(AssignType.BY_MYSELF)
    private long id;//对应baby的id
    private int year;//年份
    private int moonth;//月
    private int day;//日期
    private long start;//开始时间
    private long end;//结束时间
    private int count;//喂奶量
    private int type;//奶类型
    private String name;//奶粉名称

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMoonth() {
        return moonth;
    }

    public void setMoonth(int moonth) {
        this.moonth = moonth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
