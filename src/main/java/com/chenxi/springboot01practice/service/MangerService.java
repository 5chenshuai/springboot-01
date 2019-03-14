package com.chenxi.springboot01practice.service;

import com.chenxi.springboot01practice.bean.Manger;
import com.chenxi.springboot01practice.bean.Student;
import com.chenxi.springboot01practice.mapper.MangerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MangerService {

    @Autowired
    MangerMapper mangerMapper;
    public Manger login(String username, String password) {
        Manger manger = mangerMapper.login(username, password);
        return manger;
    }

    public int updateStuService(Student student) {
        return mangerMapper.updateStuMapper(student);
    }
    public int insertStuService(Student student) {
        return mangerMapper.insertStuMapper(student);
    }

}
