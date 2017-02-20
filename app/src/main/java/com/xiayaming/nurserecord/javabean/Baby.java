package com.xiayaming.nurserecord.javabean;

import com.litesuits.orm.db.annotation.Mapping;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;
import com.litesuits.orm.db.enums.Relation;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 37399 on 2017/1/11.
 */
@Table("baby_info")
public class Baby {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private long id;
    @NotNull
    private String name;//名字
    private Date date;//出生日期
    private int gender;//0男孩 1女孩
    private String url;//照片
    private Date crite;//创建日期
    @Mapping(Relation.OneToMany)
    private ArrayList<Record> records;//喂奶记录

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCrite() {
        return crite;
    }

    public void setCrite(Date crite) {
        this.crite = crite;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }
}
