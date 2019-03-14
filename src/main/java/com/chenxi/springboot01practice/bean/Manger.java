package com.chenxi.springboot01practice.bean;

import lombok.ToString;

@ToString
public class Manger {
    private Integer mid;
    private String mName;
    private String username;
    private String password;

    public Manger() {
    }

    public Manger(Integer mid, String mName, String username, String password) {
        this.mid = mid;
        this.mName = mName;
        this.username = username;
        this.password = password;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
