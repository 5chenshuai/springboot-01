package com.chenxi.springboot01practice.service;

import com.chenxi.springboot01practice.bean.Student;
import com.chenxi.springboot01practice.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    StuMapper stuMapper;

    @Override
    public Student stuLoginService(String username, String password) {
        return stuMapper.stuLoginMapper(username,password);
    }

    public int updateStuService(Student student) {
        return stuMapper.updateStuMapper(student);
    }

}
