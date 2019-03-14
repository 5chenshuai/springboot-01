package com.chenxi.springboot01practice.mapper;

import com.chenxi.springboot01practice.bean.Student;
import com.chenxi.springboot01practice.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StuMapper {
    @Select("select * from student where id=#{stuId}")
    public Student getUser(int stuId);

    @Select("select * from student where username=#{username} and password=#{password}")
    public Student stuLoginMapper(@Param("username") String username,@Param("password") String password);

    @Update("update student set name=#{name} , age=#{age} , username=#{username} , password=#{password} where id=#{id}")
    public int updateStuMapper(Student student);

}
