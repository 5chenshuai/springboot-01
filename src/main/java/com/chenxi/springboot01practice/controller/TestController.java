package com.chenxi.springboot01practice.controller;

import com.chenxi.springboot01practice.bean.Student;
import com.chenxi.springboot01practice.mapper.StuMapper;
import com.chenxi.springboot01practice.response.ListResult;
import com.chenxi.springboot01practice.response.ResultCodeEnum;
import com.chenxi.springboot01practice.response.SCResponsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    StuMapper stuMapper;
    //http://localhost:31001/test
    @PostMapping("/test")
    public Object test(){

        Student user = stuMapper.getUser(1);

        ListResult listResult = new ListResult();
        List<String> list = new ArrayList<>();
        list.add("11111");
        list.add("22222");
        listResult.setList(list);
        listResult.setTotal(list.size());



        SCResponsResult result = new SCResponsResult(ResultCodeEnum.SUCCESS,listResult);
        return user;
    }
}

