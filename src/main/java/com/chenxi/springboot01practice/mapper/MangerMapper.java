package com.chenxi.springboot01practice.mapper;

import com.chenxi.springboot01practice.bean.Manger;
import com.chenxi.springboot01practice.bean.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MangerMapper {
    @Select("select * from manger where username=#{username} and password=#{password}")
    public Manger login(@Param("username") String username,@Param("password") String password);

    @Update("update student set name=#{name} , age=#{age},hId=#{hId} , username=#{username} , password=#{password} where id=#{id}")
    public int updateStuMapper(Student student);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into student(id,name,age,hId,username,password) values(#{id},#{name},#{age},#{hId},#{username},#{password})")
    public int insertStuMapper(Student student);

}
