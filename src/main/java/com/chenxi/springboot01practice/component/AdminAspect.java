package com.chenxi.springboot01practice.component;

import com.chenxi.springboot01practice.mapper.PermissionMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class AdminAspect {
    @Autowired
    PermissionMapper permissionMapper;

    @Pointcut(value = "@annotation(com.chenxi.springboot01practice.annotation.Admin)")
    public void annotationPointCut() {
    }

    @Around("annotationPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        System.out.println("方法名：" + methodName);
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session =request.getSession();
        System.out.println((Integer)session.getAttribute("id"));
        if(!validate(methodName,(Integer)session.getAttribute("id"))){
            return "没有权限";
        }
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            return null;
        }
    }

    private boolean validate(String methodName,Integer id){
        // TODO 实现自己的鉴权功能
        if(permissionMapper.isUserPerById(methodName,id)!=0) {
            return true;
        }
        return false;
    }

}

