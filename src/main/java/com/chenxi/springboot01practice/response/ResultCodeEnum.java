package com.chenxi.springboot01practice.response;

import lombok.ToString;

@ToString
public enum ResultCodeEnum implements ResultCodeBase {

    SUCCESS("success",10000,"操作成功！"),
    LOGINSUCCESS("login success",1,"登录成功"),
    UNAUTHENTICATED("fail",10001,"此操作需要登陆系统！"),
    UNAUTHORISE("fail",10002,"权限不足，无权操作！"),
    INVALID_PARAM("fail",10003,"非法参数！"),
    FAIL("fail",11111,"操作失败！"),
    SERVER_ERROR("fail",99999,"抱歉，系统繁忙，请稍后重试！");

    //操作是否成功
    String flag;
    //操作代码
    int code;
    //提示信息
    String message;

    private ResultCodeEnum(String flag,int code, String message){
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    @Override
    public String flag() {
        return flag;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}
