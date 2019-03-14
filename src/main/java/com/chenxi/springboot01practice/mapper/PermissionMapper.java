package com.chenxi.springboot01practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PermissionMapper {

    @Select("select count(*) from permission p,rolePermission rp,role r,user u,userRole ur " +
            "WHERE r.roleId=rp.roleId AND rp.permissionId=p.perId AND u.userId=ur.userId AND ur.roleId=r.roleId " +
            " and p.perName=#{per} and  u.userId = ${id}")
    public Integer isUserPerById(@Param("per") String per,@Param("id") Integer id);

}