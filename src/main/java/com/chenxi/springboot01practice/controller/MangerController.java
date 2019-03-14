package com.chenxi.springboot01practice.controller;

import com.chenxi.springboot01practice.annotation.Admin;
import com.chenxi.springboot01practice.bean.Manger;
import com.chenxi.springboot01practice.bean.Student;
import com.chenxi.springboot01practice.response.MapResponsResult;
import com.chenxi.springboot01practice.response.MapResult;
import com.chenxi.springboot01practice.response.ResultCodeEnum;
import com.chenxi.springboot01practice.response.StuResponsResult;
import com.chenxi.springboot01practice.service.MangerService;
import com.chenxi.springboot01practice.service.StuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MangerController {

    @Autowired
    MangerService mangerService;

    @PostMapping(value = "/manger/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        System.out.println(username+password);
        Manger manger = mangerService.login(username, password);
        MapResult<String, Object> mapResult = new MapResult<>();
        map.put("manger",manger);
        mapResult.setMap(map);
        mapResult.setTotal(map.size());
        MapResponsResult result = new MapResponsResult(ResultCodeEnum.LOGINSUCCESS, mapResult);
        session.setAttribute("id", manger.getMid());
        //StuResponsResult result = new StuResponsResult(ResultCodeEnum.LOGINSUCCESS, student);
        return result;
    }

    @Admin
    @PutMapping("PUT/stuByMan/ID")
    public Object updateStuByMan(Student student) {
        int i = mangerService.updateStuService(student);
        MapResult<String, Object> mapResult = new MapResult<>();
        Map<String, Object> map = new HashMap<>();
        map.put("student",student);
        mapResult.setMap(map);
        mapResult.setTotal(i);
        MapResponsResult result = new MapResponsResult(ResultCodeEnum.SUCCESS, mapResult);
        return result;
    }

    @PostMapping("POST/stu")
    public Object insertStu(Student student) {
        int i = mangerService.insertStuService(student);
        MapResult<String, Object> mapResult = new MapResult<>();
        Map<String, Object> map = new HashMap<>();
        map.put("student",student);
        mapResult.setMap(map);
        mapResult.setTotal(i);
        MapResponsResult result = new MapResponsResult(ResultCodeEnum.SUCCESS, mapResult);
        return result;
    }

}
