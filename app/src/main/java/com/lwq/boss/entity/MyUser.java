package com.lwq.boss.entity;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2018/11/3.
 * 用户实体类
 */

public class MyUser extends BmobUser {
    //username默认有
    private int age;
    private boolean sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;


}
