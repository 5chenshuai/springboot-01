package com.chenxi.springboot01practice.bean;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Integer hId;
    private String username;
    private String password;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer hId, String username, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hId = hId;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
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
