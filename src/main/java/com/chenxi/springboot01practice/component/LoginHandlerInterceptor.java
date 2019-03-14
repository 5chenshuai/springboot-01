package com.chenxi.springboot01practice.component;


import com.chenxi.springboot01practice.response.MapResponsResult;
import com.chenxi.springboot01practice.response.MapResult;
import com.chenxi.springboot01practice.response.ResponseCode;
import com.chenxi.springboot01practice.response.ResultCodeEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.ws.api.message.Packet.State.ServerResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串【常用】

    @Autowired
    RedisTemplate redisTemplate;//操作k-v都是对象

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("id");
        //String msg = stringRedisTemplate.opsForValue().get("msg");
        //System.out.println(msg);
        System.out.println(user);
        if (user == null) {
            String str = "未登录";
            returnJson(response,str);
            return false;
        } else {
            return true;
        }

    }

    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            //logger.error("response error",e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }





}
