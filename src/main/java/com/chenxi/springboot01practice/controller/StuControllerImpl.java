package com.chenxi.springboot01practice.controller;

import com.chenxi.springboot01practice.bean.Student;
import com.chenxi.springboot01practice.response.*;
import com.chenxi.springboot01practice.service.StuService;
import com.chenxi.springboot01practice.service.StuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StuControllerImpl {

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串【常用】

    @Autowired
    RedisTemplate redisTemplate;//操作k-v都是对象

    @Autowired
    StuServiceImpl stuService;

    @PostMapping(value = "/stu/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        System.out.println(username+password);
        Student student = stuService.stuLoginService(username, password);
        if (student==null) {
            StuResponsResult result = new StuResponsResult(ResultCodeEnum.FAIL, student);
            return result;
        }
        MapResult<String, Object> mapResult = new MapResult<>();
        map.put("student",student);
        mapResult.setMap(map);
        mapResult.setTotal(map.size());
        session.setAttribute("id", student.getId());

        //stringRedisTemplate.opsForValue().append(username,username);
        MapResponsResult result = new MapResponsResult(ResultCodeEnum.LOGINSUCCESS, mapResult);
        //StuResponsResult result = new StuResponsResult(ResultCodeEnum.LOGINSUCCESS, student);
        return result;
    }

    @PutMapping("PUT/stu/ID")
    public Object updateStu(Student student) {
        int i = stuService.updateStuService(student);
        MapResult<String, Object> mapResult = new MapResult<>();
        Map<String, Object> map = new HashMap<>();
        map.put("student",student);
        mapResult.setMap(map);
        mapResult.setTotal(i);
        MapResponsResult result = new MapResponsResult(ResultCodeEnum.SUCCESS, mapResult);
        return result;
    }

}
